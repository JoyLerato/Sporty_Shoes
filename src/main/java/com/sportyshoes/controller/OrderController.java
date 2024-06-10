package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.Order;
import com.sportyshoes.model.OrderItem;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.ShoppingCart;
import com.sportyshoes.service.OrderService;
import com.sportyshoes.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class OrderController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        Product product = productService.findById(id).orElseThrow();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(product, 1);
        return "redirect:/products/list";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String customerName, @RequestParam String customerEmail, @RequestParam String shippingAddress, HttpSession session, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            model.addAttribute("message", "Cart is empty");
            return "cart";
        }

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setShippingAddress(shippingAddress);

        cart.getItems().forEach((product, quantity) -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
        });

        orderService.save(order);
        cart.clear();
        model.addAttribute("message", "Order placed successfully");
        return "order-confirmation";
    }
}
