package com.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptop.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	
	Laptop findByName(String name);
	
	Laptop findByRamAvailable(String ramAvaliable);
	
	Laptop findByOsName(String osName);
	
	Laptop findByWebcam(String webCam);
	
	Laptop findByPrice(int price);
	
	List<Laptop> findByPriceGreaterThan(int price);
}
