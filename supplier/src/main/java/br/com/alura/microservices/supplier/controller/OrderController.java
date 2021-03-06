package br.com.alura.microservices.supplier.controller;

import br.com.alura.microservices.supplier.dto.OrderItemDTO;
import br.com.alura.microservices.supplier.model.Order;
import br.com.alura.microservices.supplier.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order placeOrder(@RequestBody List<OrderItemDTO> products) {
        LOG.info("Order received");
        return orderService.placeOrder(products);
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
