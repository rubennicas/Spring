package es.jsomoza.i18nvalidation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.jsomoza.i18nvalidation.commands.OrderCommand;
import es.jsomoza.i18nvalidation.service.OrderService;
import jakarta.validation.Valid;

@Controller
public class OrderController {

  private OrderService orderService;
    
    public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @RequestMapping(value={"/orders","/"})
    public String list (Model model) {      
      model.addAttribute("orders", orderService.getOrders());
        return "orders.html";
    }
  
  @RequestMapping("/orders/add")
    public String add (Model model) {      
        model.addAttribute("orderCommand", new OrderCommand());
        return "addOrder";
    }
  
    @PostMapping("/orders")
    // Note: we could set @ModelAttribute("orderCommand") to match other names
    // Take this into account for i18n messages
    public String saveOrder(Model model, 
    		@Valid @ModelAttribute("orderCommand") OrderCommand orderCommand, 
    		BindingResult bindingResult) {
        
    	if (bindingResult.hasErrors()) {
          System.err.println("Error in validation " + bindingResult.getAllErrors());
            model.addAttribute("orderCommand", orderCommand);
            return "addOrder";
        }
      OrderCommand savedOrderCommand = orderService.saveOrder(orderCommand);
      model.addAttribute("order", savedOrderCommand);
        return "orderSaved";
    }
}