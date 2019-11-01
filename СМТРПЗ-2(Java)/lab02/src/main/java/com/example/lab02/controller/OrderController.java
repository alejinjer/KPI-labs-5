package com.example.lab02.controller;

import com.example.lab02.entity.Order;
import com.example.lab02.entity.OrderElement;
import com.example.lab02.service.OrderElementsService;
import com.example.lab02.service.OrderService;
import com.example.lab02.service.ProductService;
import com.example.lab02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

    @Autowired
    public OrderElementsService orderElementsService;

    @Autowired
    public OrderService orderService;

    @GetMapping("/createOrder/{userId}")
    public String createOrder(@PathVariable("userId") long id, Model model, @ModelAttribute("order") Order order) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("products", productService.getAll());
        return "newOrder";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order) {
        orderService.add(order);
        return "redirect:/users";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "productList";
    }

    @PostMapping
        public String addProduct(@ModelAttribute("orderElement") OrderElement orderElement) {
        return "";
    }
}
