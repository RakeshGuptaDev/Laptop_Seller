package com.laptop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.dto.LaptopDto;
import com.laptop.entity.Laptop;
import com.laptop.repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;
	
	public Laptop addLaptop(Laptop laptop) {
		return laptopRepository.save(laptop);
	}
	
//	public Laptop updateLaptop(LaptopDto laptopDto,int id) {
//		Laptop laptopSave =  laptopRepository.findById(id).get();
//		laptopSave.setName(laptopDto.getName());
//		laptopSave.setOsName(laptopDto.getOsName());
//		laptopSave.setPrice(laptopDto.getPrice());
//		laptopSave.setRamAvailable(laptopDto.getRamAvailable());
//		laptopSave.setWebcam(laptopDto.getWebcam());
//		
//		return laptopRepository.save(laptopSave);
//	}
	
	

	public Laptop updateLaptop(Laptop laptop,int id) {
			
		Laptop laptopSave =  laptopRepository.findById(id).get();
		return laptopRepository.save(laptopSave);
	}
	
	
	
	
	public String deleteLaptop(int id) {
		
		laptopRepository.deleteById(id);
		
		return id+"is Deleted";
	}
	
	
	public Laptop getLaptop(int id) {
		return laptopRepository.findById(id).get();
	}
	
	public List<Laptop> getAllLaptop() {
		return laptopRepository.findAll();
	}
	
	
	
}
