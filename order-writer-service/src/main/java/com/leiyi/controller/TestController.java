package com.leiyi.controller;


import com.leiyi.dataobject.Order;
import com.leiyi.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/insertOrderTest")
    public String insertOrderTest(@RequestParam("orderId") Long orderId) {
        Order order = new Order();
        order.setOrderId(String.valueOf(orderId));
        int insert = orderMapper.insert(order);
        return String.valueOf(insert);
    }
}
