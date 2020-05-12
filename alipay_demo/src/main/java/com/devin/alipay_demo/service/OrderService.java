package com.devin.alipay_demo.service;

import com.alipay.api.AlipayApiException;
import com.devin.alipay_demo.dao.UserOrderMapper;
import com.devin.alipay_demo.dto.AlipayBean;
import com.devin.alipay_demo.entity.UserOrder;
import com.devin.alipay_demo.util.AliPayUtil;
import com.devin.alipay_demo.util.OrderEnum;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author Devin Zhang
 * @className OrderService
 * @description TODO
 * @date 2020/5/12 10:53
 */

@Service
public class OrderService {


    @Resource
    private UserOrderMapper userOrderMapper;

    @Resource
    private AliPayUtil aliPayUtil;

    /**
     * 下单
     *
     * @param orderAmount 订单金额
     * @return 返回支付结果页面内容
     * @throws AlipayApiException
     */
    public String orderPay(BigDecimal orderAmount) throws AlipayApiException {

        //1. 产生订单
        UserOrder order = new UserOrder();
        order.setOrderNo(System.currentTimeMillis() + "");
        order.setUserId(UUID.randomUUID().toString());
        order.setOrderAmount(orderAmount);
        order.setOrderStatus(OrderEnum.ORDER_STATUS_NOT_PAY.getStatus());
        String format = "yyyy-MM-dd HH:mm:ss";
        order.setCreateTime(DateFormatUtils.format(new Date(), format));
        order.setLastUpdateTime(DateFormatUtils.format(new Date(), format));

        userOrderMapper.insert(order);

        //2. 调用支付宝
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(order.getOrderNo());
        alipayBean.setSubject("充值:" + order.getOrderAmount());
        alipayBean.setTotal_amount(orderAmount.toString());
        String pay = aliPayUtil.pay(alipayBean);
        System.out.println("pay:" + pay);
        return pay;
    }

    /**
     * 根据订单号查询订单
     *
     * @param orderNo
     * @return 返回订单信息
     */
    public UserOrder getOrderByOrderNo(String orderNo) {
        Example example = new Example(UserOrder.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNo", orderNo);
        return userOrderMapper.selectOneByExample(example);
    }

    /**
     * 更新订单
     *
     * @param userOrder 订单对象
     * @return 返回更新结果
     */
    public int updateOrder(UserOrder userOrder) {
        return userOrderMapper.updateByPrimaryKeySelective(userOrder);
    }
}
