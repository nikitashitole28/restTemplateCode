package demo.testexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.testexample.model.CustomerModel;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Integer> {

	public CustomerModel getByName(String name);
	
}
