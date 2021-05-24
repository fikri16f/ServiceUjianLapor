package com.lapor.main.controller;

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

import com.lapor.main.entity.User;
import com.lapor.main.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;

//	@GetMapping("/nama/{value}")
//	public User getByNama(@PathVariable("value") String value) {
//		return userRepo.findByNama(value);
//	}
	
	@GetMapping("/")
	public List<User> getAllUsers (){
	return (List<User>) userRepo.findAll();
	}

	@GetMapping("/{title}")
	public List<User> findAllData(@PathVariable String title) {
		return userRepo.findAllData(title);
	}
	
	@PostMapping("/add/")
	public String adduser(@RequestBody User user) {
		userRepo.save(user);
		return "Berhasil";
	}

	@DeleteMapping("/hapus/{id}")
	public String hapus(@PathVariable String id) {
		userRepo.deleteById(Long.parseLong(id));
	return "Hapus Data Berhasil";
	}
	
	@PutMapping("/ubah/{id}")
	public String ubah (@PathVariable String id,@RequestBody User user) {
		user.setId(Long.parseLong(id));
		userRepo.save(user);
		return"Update Berhasil";
	}
	
	
	
}
