package com.ola.in.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ola.in.entity.CustomerItem;
import com.ola.in.service.ICustomerItemService;

@RestController
@RequestMapping("/customeritem")
public class CustomerItemController {

	@Autowired
	private ICustomerItemService customerItemService;
	
	/*{
		  "itemId": 2,
		  "name": "puma Tshirt",
		  "color": "white",
		  "category": "shirt",
		  "quantity": 2,
		  "material": "cotton",
		  "description": "na",
		  "customer": {
		    "userId": "2002",
		    "password": "Xyza@1234",
		    "name": "Ram",
		    "email": "ram@gmail.com",
		    "contactNo": "9012741122",
		    "dob": "2003-11-13"
		  }
		}*/
	
	//Add CustomerItem 
	@PostMapping("/add")
	public ResponseEntity<Object> addItem(@RequestBody CustomerItem item) {
		ResponseEntity<Object> response=null;
		CustomerItem ci=customerItemService.addItem(item);
		response= new ResponseEntity<Object>(ci,HttpStatus.CREATED);
		return response;
	}

	//Remove CustomerItem by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeItem(@PathVariable long id)throws Exception {
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.removeItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	//Update CustomerItem by id
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateItem(@PathVariable long id,@RequestBody CustomerItem item) throws Exception{
			ResponseEntity<Object> response = null;
			CustomerItem ci=customerItemService.updateItem(id, item);
			response = new ResponseEntity<Object>(ci, HttpStatus.ACCEPTED);
			return response;
		}

		//Get Item by id
		@GetMapping("/get/{id}")
		public ResponseEntity<Object> getItem(@PathVariable long id) throws Exception{
			ResponseEntity<Object> response = null;
			CustomerItem ci= customerItemService.getItem(id);
			response = new ResponseEntity<Object>(ci, HttpStatus.OK);
			return response;
		}
		//Get by customerId
		@GetMapping("/getbycustomer/{customerId}")
		public ResponseEntity<Object> getItemsByCustomer(@PathVariable String customerId)throws Exception{
			ResponseEntity<Object> response = null;
			List<CustomerItem> ci= customerItemService.getItemsByCustomer(customerId);
			response = new ResponseEntity<Object>(ci, HttpStatus.OK);
			return response;
		}
	}

