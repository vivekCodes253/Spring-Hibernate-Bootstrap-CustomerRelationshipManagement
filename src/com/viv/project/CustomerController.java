package com.viv.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viv.project.dao.CustomerDAO;
import com.viv.project.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject dao into controller
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		List<Customer> theCustomer = customerDAO.getCustomers();
		
		//add customers to model
		theModel.addAttribute("customers",theCustomer);
		
		return "list-customer";
	}

}
