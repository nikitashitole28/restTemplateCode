package demo.testexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.testexample.model.CustomerModel;
import demo.testexample.model.CustomerModel;
import demo.testexample.model.CustomerModel;
import demo.testexample.repository.CustomerRepository;
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<CustomerModel> getAllCustomer(){
		List<CustomerModel> findAll=(List<CustomerModel>) customerRepository.findAll();
		return findAll;
	}
		
	
	public void postCustomer(CustomerModel c) {
		customerRepository.save(c);
		
	}


	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
		
	}


	public void updateCustomer(Integer id, CustomerModel c) {
		Optional<CustomerModel> findById = customerRepository.findById(id);
		CustomerModel CustomerModel = findById.get();
		CustomerModel.setId(c.getId());
		CustomerModel.setName(c.getName());
		CustomerModel.setAddress(c.getAddress());
		
		customerRepository.save(CustomerModel);
		
	}
		
	}

	
	



