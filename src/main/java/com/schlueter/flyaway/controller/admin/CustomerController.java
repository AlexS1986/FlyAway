package com.schlueter.flyaway.controller.admin;

import com.schlueter.flyaway.entity.Customer;
import com.schlueter.flyaway.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/customers")
public class CustomerController {

	// load employee data

	private CustomerService customerService;

	@Autowired // is optional
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customers = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("customers", customers);

		return "admin/customers/list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "admin/customers/customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "admin/customers/customer-form";
	}


	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/admin/customers/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") long id) {
		customerService.deleteById(id);

		return "redirect:/admin/customers/list";
	}
}









