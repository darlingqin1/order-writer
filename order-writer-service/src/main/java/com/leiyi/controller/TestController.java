package com.leiyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leiyi.dataobject.Order;
import com.leiyi.mapper.OrderMapper;
import org.apache.http.entity.HttpEntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/insertOrderTest")
    public String insertOrderTest(@RequestParam("orderId") Long orderId) {
        Order order = new Order();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        order.setOrderId(String.valueOf(orderId));
        int insert = orderMapper.insert(order);
        return String.valueOf(order.getId());
    }
}
