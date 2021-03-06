package org.bridgelabz.docsigner.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bridgelabz.docsigner.json.ErrorResponse;
import org.bridgelabz.docsigner.json.Response;
import org.bridgelabz.docsigner.json.SuccessResponse;
<<<<<<< HEAD
import org.bridgelabz.docsigner.json.TokenResponse;
=======
>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
import org.bridgelabz.docsigner.model.Token;
import org.bridgelabz.docsigner.model.User;
import org.bridgelabz.docsigner.service.TokenService;
import org.bridgelabz.docsigner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	private TokenService tokenService;

	@RequestMapping("/loginPage")
	public String init(HttpServletRequest request) {
		
		/*
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		if (user != null) {
			return "success";
		}
		*/
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Response login(@RequestParam("email") String email, @RequestParam("password") String password,
<<<<<<< HEAD
			HttpServletRequest request, HttpServletResponse response) {
		
=======
			HttpServletRequest request, @ModelAttribute("token") Token token) {
>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
		User user = userService.authUser(email, password);
		String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");
		
		if (user == null) {
			ErrorResponse er = new ErrorResponse();
			er.setStatus(-1);
			er.setDisplayMessage("Invalid credential");
			er.setErrorMessage("user not found");
			return er;
			// return "login";
		} else {
<<<<<<< HEAD
			Token token = new Token();
			token.setCreatedOn(new Date());
			token.setAccessToken(accessToken);
			token.setRefreshToken(refreshToken);
			token.setUserId(user.getId());
			token.setAccessTokenValidity(60);
			token.setRefreshTokenValidity(86400);
			tokenService.addToken(user, token);
			/* tokenService.addToken(token); */

			HttpSession session = request.getSession();
			/* session.invalidate(); */ // invalidate existing session
			/* session = request.getSession(); */
=======
			
			tokenService.generateToken(user, token);
			tokenService.addToken(token);
			
			HttpSession session = request.getSession();
			/*session.invalidate();*/ // invalidate existing session
			/*session = request.getSession();*/
>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
			session.setAttribute("user", user);
			
			SuccessResponse er = new SuccessResponse();
			er.setStatus(1);
			er.setMessage("successfully logged in");
<<<<<<< HEAD
			
			TokenResponse tr = new TokenResponse();
			tr.getAccessToken();
			tr.getRefreshToken();
			tr.setStatus(1);

			Cookie ck = new Cookie("access_token", token.getAccessToken());
			response.addCookie(ck);

			return tr;
=======
			session.setMaxInactiveInterval(60);
			return er;
>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
			// return "success";
		}
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public void signout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		try {
			response.sendRedirect("http://localhost:8080/DocumentSigner/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
