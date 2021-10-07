/**
 * 
 */
package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.report.pdf.GeneratePdf;


/**
 * @author Dell
 *
 */

@RestController
public class UserListController {
	
	List<String> usersList = null;
	@GetMapping(value ="/users")
	public ArrayList<String> getUsers() {
		try {
		final String uri = "https://reqres.in/api/users/";
	    RestTemplate restTemplate = new RestTemplate();
	    String users = restTemplate.getForObject(uri, String.class);
	    System.out.println("@@@@@@@ User List @@@@@@@@@"+usersList);
	    
	    GeneratePdf exporter = new GeneratePdf(usersList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

}
