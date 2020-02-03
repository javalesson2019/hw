package org.itstep;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changeCookie")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeServlet() {
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
		if (cookies != null) {
			for (Cookie c : cookies) {

				if (c.getName().equals(request.getParameter("key"))) {
					if (!isNull(request.getParameter("value"))) {
						c.setValue(request.getParameter("value"));
					} else {
						c.setValue(c.getValue());
					}

					if (!isNull(request.getParameter("life time"))) {
						c.setMaxAge(Integer.parseInt(request.getParameter("life time")));
					} else {
						c.setMaxAge(c.getMaxAge());
					}
					response.addCookie(c);
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
