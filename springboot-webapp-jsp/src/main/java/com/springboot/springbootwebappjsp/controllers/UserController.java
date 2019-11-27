package com.springboot.springbootwebappjsp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.springbootwebappjsp.models.User;
import com.springboot.springbootwebappjsp.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("users",userRepo.findAll());
		return "home";
	}
	
//    @PostMapping("/users")
	public String saveUser(Model model, @RequestParam("saved") String name) {
		User user = new User();
		user.setName(name);
		userRepo.save(user);
		model.addAttribute("users",userRepo.findAll());
		return "home";
	}
	
//    @PostMapping("/users/edit")
	public String editUser(Model model, int id, @RequestParam("edit") String name) {
		userRepo.findById(id).map(user -> {
			user.setName(name);
			return userRepo.save(user);
		});
		model.addAttribute("users",userRepo.findAll());
		return "home";
	}
	
//    @PostMapping("/users")
	public String removeUser(Model model, @RequestParam("remove") int id) {
		userRepo.deleteById(id);
		model.addAttribute("users",userRepo.findAll());
		return "home";
	}
	
	@PostMapping("/users")
	public String redirect(Model model, 
				@RequestParam("type") String type,
				@RequestParam("id") int id,
				@RequestParam("name") String name) {
		if(type.equals("remove")) {
			return removeUser(model, id);
		}else if(type.equals("save")) {
			return saveUser(model, name);
		}else {
			return editUser(model, id, name);
		}
		
	}
}
