package com.nghia.ivector.controller;

import com.nghia.ivector.domain.OrderRequest;
import com.nghia.ivector.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/page")
    public String fwOrderPage(Model model) {
        model.addAttribute("orderRequest", new OrderRequest());
        return "order/orders";
    }
}
