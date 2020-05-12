package com.devin.alipay_demo.dao;

import com.devin.alipay_demo.entity.UserOrder;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Devin Zhang
 * @className UserOrderMapper
 * @description TODO
 * @date 2020/5/12 10:54
 */

public interface UserOrderMapper extends Mapper<UserOrder>, MySqlMapper<UserOrder> {
}
