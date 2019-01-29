package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from DAO
		List<Customer> customers = customerService.getCustomers();
		
		//add Customer to Spring Model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model theModel) {
		
		// create model attribute to add data too
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer tempCustomer) {
		
		// save customer using service
		customerService.saveCustomer(tempCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomerForm(@RequestParam("customerId") int theId, Model theModel) {
		
		//get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as model attribute to populate form
		theModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
	@GetMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("search")
	public String searchCustomers(@RequestParam("theSearch") String theSearch, Model theModel) {
		
		List<Customer> customers = customerService.searchCustomers(theSearch);
		
		//add Customer to Spring Model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
}
