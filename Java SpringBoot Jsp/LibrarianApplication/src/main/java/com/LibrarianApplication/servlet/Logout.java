package com.LibrarianApplication.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet controller to logout the current session
 * @author premgupta
 *
 */
@Controller
public class Logout {

	/**
	 * method to logout the current user
	 * @param request represents the current HttpServletRequest
	 * @param session represents the current session
	 * @return return the signin.jsp page
	 */
	@RequestMapping("/logoutUser")
	public String logOut(HttpServletRequest request,HttpSession session) {
  
        // invalidating the session.
        request.getSession(false);
  
        // Invalidate the session.
        session.invalidate();
        return "signin";
  
	}
}
