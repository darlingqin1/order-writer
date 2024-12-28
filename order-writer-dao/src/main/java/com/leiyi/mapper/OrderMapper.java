package com.leiyi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leiyi.dataobject.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper extends BaseMapper<Order> {

}
