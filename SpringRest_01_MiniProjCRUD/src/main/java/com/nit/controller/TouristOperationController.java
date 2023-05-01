package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Tourist;
import com.nit.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationController {
	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		//use service
		try {
			String resultMsg=service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);//201 content created success
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in Tourist enrollment",HttpStatus.INTERNAL_SERVER_ERROR);	//500 error
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists(){
		try {
			List<Tourist> list=service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem Fetching Tourist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id")Integer id){
		try {
			Tourist tourist=service.fechTouristById( id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Tourist Not Found "+id,
													HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		try {
			String msg=service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
