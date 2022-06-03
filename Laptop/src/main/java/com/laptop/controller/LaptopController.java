package com.laptop.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.dto.LaptopDto;
import com.laptop.entity.Laptop;
import com.laptop.exception.LaptopNotFoundException;
import com.laptop.services.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	

//	@PostMapping
//	public ResponseEntity<Laptop>  addLaptop(@RequestBody Laptop laptop) {
//		return new ResponseEntity<>(laptopService.addLaptop(laptop),HttpStatus.CREATED);
//	}
//	
	@PostMapping
	public ResponseEntity<Laptop>  addLaptop(@RequestBody @Valid LaptopDto laptop) {
		return new ResponseEntity<>(laptopService.addLaptop(laptop),HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/{id}")
	public Laptop updateLaptop(@RequestBody Laptop laptop,@PathVariable int  id ) {
		return laptopService.updateLaptop(laptop,id);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteLaptop(@PathVariable int id) {
		return laptopService.deleteLaptop(id);
	}
	
	
	@GetMapping
	public List<Laptop> getAllLaptop() {
		return laptopService.getAllLaptop();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable int id) throws LaptopNotFoundException{
//		return laptopService.getLaptop(id);
		  return ResponseEntity.ok(laptopService.getLaptop(id));
	}
	
	@GetMapping("/name/{name}")
	public Laptop getLaptopByName(@PathVariable String name) throws LaptopNotFoundException {
		return laptopService.getLaptopByName(name);
	}
	
	@GetMapping("/ramAvailable/{ramAvailable}")
	public Laptop getLaptopByRam(@PathVariable String ramAvailable) throws LaptopNotFoundException{
		return laptopService.getLaptopByRamAvaliable(ramAvailable);
	}
	
	@GetMapping("/webcam/{webcam}")
	public Laptop getLaptopByWebCam(@PathVariable String webcam) throws LaptopNotFoundException{
		return laptopService.getLaptopByWebcam(webcam);
	}
	
	@GetMapping("/price/{price}")
	public Laptop getLaptopByPrice(@PathVariable int price) throws LaptopNotFoundException {
		return laptopService.getLaptopByPrice(price);
	}
	
	@GetMapping("/price/custom/{price}")
	public List<Laptop> getLaptopByPriceGreater(@PathVariable int price) throws LaptopNotFoundException {
		return laptopService.getLaptopByPriceGreater(price);
	}
	
}
