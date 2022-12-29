package com.contact.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contact.Exception.ConatctException;
import com.contact.Repository.UserDao;
import com.contact.helper.Messages;
import com.contact.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public String home()	
	{
		return "home";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register-Smart Contact Form");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	//For user Registartion handler
	
	@PostMapping("/register")
	public String resgiterUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue="false")boolean agreement,Model model,HttpSession session) throws ConatctException
	{
		try {
			if(!agreement)
			{
				System.out.println("Agreement not selected");
				throw new Exception("Agreement not selected");
			}
			
			user.setRole("USER_ROLE");
			user.setEnabled(true);
			User userReturn= this.userDao.save(user);
			model.addAttribute("user", new User());
			//Setting Return message
			session.setAttribute("message", new Messages("User Signup Successfully..","alert-success"));
			return "signup";
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("user",user);
			session.setAttribute("message", new Messages("Something Went Wrong" + e.getMessage(),"alert-danger"));
			return "signup";

		}
	}
	
	
}
