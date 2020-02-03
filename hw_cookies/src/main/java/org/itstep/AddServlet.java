package org.itstep;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		boolean check = true;

		Cookie cookie;
		for (Cookie c : cookies) {
			if (c.getName().equals(request.getParameter("key"))) {
				check = false;
			}
		}
		if (!isNull(request.getParameter("key")) && check) {
			cookie = new Cookie(request.getParameter("key"), "");

			if (!isNull(request.getParameter("value"))) {
				cookie.setValue(request.getParameter("value"));
			}
			if (!isNull(request.getParameter("domain"))) {
				cookie.setDomain(request.getParameter("domain"));
			}
			if (!isNull(request.getParameter("life time"))) {
				cookie.setMaxAge(Integer.parseInt(request.getParameter("life time")));
			}

			if (request.getParameter("httpHttps").equals("HTTPS")) {
				cookie.setSecure(true);
			} else {
				cookie.setSecure(false);
			}
			response.addCookie(cookie);
		}

		response.sendRedirect(getServletContext().getContextPath() + "/");
	}

	public boolean isNull(String s) {
		if (s != null && !s.isEmpty()) {
			return false;
		}
		return true;
	}
}