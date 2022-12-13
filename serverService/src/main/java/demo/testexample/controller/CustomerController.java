package demo.testexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.testexample.model.CustomerModel;
import demo.testexample.model.CustomerModel;
import demo.testexample.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getall")
	public List<CustomerModel> getAllCustomer1() {
	 List<CustomerModel> lst= customerService.getAllCustomer();
	
	 return lst;
	 
	}
	
	@PostMapping("/post")
	public CustomerModel postCustomer(@RequestBody CustomerModel c) {
		customerService.postCustomer(c);
		return c;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
    	return "customer deleted successfully";
	}
	
	
	@PutMapping("/put/{id}")
	public String updateCustomer(@PathVariable Integer id,@RequestBody CustomerModel e) {
		customerService.updateCustomer(id,e);
    	return " customer updated successfully";
	}
	
	@GetMapping("/getbyname")
	public List<CustomerModel> getAllCustomer() {
	 List<CustomerModel> lst= customerService.getAllCustomer();
	
	 return lst;
	 
	}
	

}
