package com.facon.farm.controller;

import com.facon.farm.model.CheckoutRequest;
import com.facon.farm.model.CustomerOrder;  // Updated entity class name
import com.facon.farm.repository.CustomerOrderRepository;  // Updated repository class name
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@Controller
public class CheckoutController {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;  // Updated to use CustomerOrderRepository

    @PostMapping("/api/checkout")
    public String checkout(@ModelAttribute CheckoutRequest checkoutRequest, Model model) {
        // Log the received checkout request
        System.out.println("Checkout data received:");
        System.out.println("First Name: " + checkoutRequest.getFirstName());
        System.out.println("Last Name: " + checkoutRequest.getLastName());
        System.out.println("Email: " + checkoutRequest.getEmail());
        System.out.println("Phone: " + checkoutRequest.getPhone());
        System.out.println("Address: " + checkoutRequest.getAddress());
        System.out.println("Region: " + checkoutRequest.getRegion());
        System.out.println("Payment Method: " + checkoutRequest.getPaymentMethod());
        System.out.println("Total Items: " + checkoutRequest.getTotalItems());
        System.out.println("Total Price: " + checkoutRequest.getTotalPrice());

        // Create a new customer_order entity and set values from CheckoutRequest
        CustomerOrder customerOrder = new CustomerOrder();  // Updated to use CustomerOrder
        customerOrder.setFirstName(checkoutRequest.getFirstName());
        customerOrder.setLastName(checkoutRequest.getLastName());
        customerOrder.setEmail(checkoutRequest.getEmail());
        customerOrder.setPhone(checkoutRequest.getPhone());
        customerOrder.setAddress(checkoutRequest.getAddress());
        customerOrder.setRegion(checkoutRequest.getRegion());
        customerOrder.setPaymentMethod(checkoutRequest.getPaymentMethod());
        customerOrder.setTotalItems(checkoutRequest.getTotalItems());
        customerOrder.setTotalPrice(BigDecimal.valueOf(checkoutRequest.getTotalPrice()));

        // Save the customer_order to the database
        customerOrderRepository.save(customerOrder);

        // Optionally, add an attribute to the model
        model.addAttribute("message", "Order successfully placed!");

        // Redirect to a confirmation page (you can change this URL as needed)
        return "checkout-success"; // Assuming "checkout-success" is a view name
    }
}
