package demo.testexample.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import demo.testexample.model.CustomerModel;

@RestController
@RequestMapping("client")
public class CustomerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<CustomerModel>> getAllCustomer1() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CustomerModel> entity = new HttpEntity<CustomerModel>(header);
		ResponseEntity<List<CustomerModel>> cus = restTemplate.exchange("http://localhost:8080/customer/getall", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<CustomerModel>>() {
				});
	 return cus;
	 
	}
	
	@PostMapping("/post")
	public String postCustomer(@RequestBody CustomerModel c) throws JsonMappingException, JsonProcessingException  {
			HttpEntity<CustomerModel> entity = new HttpEntity<CustomerModel>(c);
			ResponseEntity<CustomerModel> res = restTemplate.exchange("http://localhost:8080/customer/post", HttpMethod.POST, entity,
					CustomerModel.class);
			//ObjectMapper mapper = new ObjectMapper();
			//CustomerModel rootNode = mapper.readValue(res.toString(), CustomerModel.class);
			return "saved";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		HttpEntity<Integer> entity = new HttpEntity<Integer>(id);
		Map<String, Integer> vars = new HashMap<>();
		vars.put("id", id);
		ResponseEntity<String> res = restTemplate.exchange("http://localhost:8080/customer/delete/{id}", HttpMethod.DELETE,
				entity, String.class, vars);
		return res.getBody();
	}
	
	
	@PutMapping("/put/{id}")
	public String updateCustomer(@PathVariable Integer id,@RequestBody CustomerModel e) {
		HttpEntity<CustomerModel> entity = new HttpEntity<CustomerModel>(e);
		Map<String, Integer> vars = new HashMap<>();
		vars.put("id", id);
		ResponseEntity res = restTemplate.exchange("http://localhost:8080/customer/put/{id}", HttpMethod.PUT, entity,
				CustomerModel.class,vars);
		//CustomerModel b1 = (CustomerModel) res.getBody();
		return "updated";	}
	
	
	

}
