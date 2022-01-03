package com.example.demo;


import com.example.demo.models.AuthenticationRequest;
import com.example.demo.models.AuthenticationResponse;
import com.example.demo.util.JwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class TimeEntriesController {
	@Autowired
	private  TimeEntriesRepositorie repository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwUtil jwtTokenUtil;
	
	@GetMapping("/add_timeentries")
	public ModelAndView addTimeEntry() throws Exception {
		TimeEntry timeEntry1 = new TimeEntry(LocalDateTime.now());
		//repository.insert(timeEntry1);
		repository.save(timeEntry1);
		return timeentries();
	}
	
	@GetMapping("/timeentries")
	public ModelAndView timeentries() {
		ModelAndView modelAndView = new ModelAndView("timeentrie");
		String title = "Zeiteinträge Anwendung";		
		modelAndView.addObject("title", title);
		modelAndView.addObject("timeEntries", repository.findAll());
		return modelAndView;
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity createAuthenticationstoken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPasswort())
			);
		}catch (BadCredentialsException e){
			throw new Exception("Incurrect username or passwort");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
