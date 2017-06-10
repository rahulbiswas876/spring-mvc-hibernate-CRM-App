package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.entity.Customer;
import com.rahul.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customerList",customerService.getCustomers());
		return "customer-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer-add";
	}
	

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute(value="customer")Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer =	customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
