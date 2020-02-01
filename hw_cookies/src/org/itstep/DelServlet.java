package org.itstep;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isNull(request.getParameter("key"))) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals(request.getParameter("key"))) {
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
			}
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
