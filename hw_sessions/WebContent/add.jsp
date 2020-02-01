<%@ page contentType="text/html" language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="org.itstep.CD"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add</title>
</head>
<body>
	<form method="post">
		<h1>Add disk</h1>
		<label> Name: <input name="name" required />
		</label><br /> <label> Cost: <input name="cost" min="0" required />
		</label><br />
		<button type="submit">Add</button>
	</form>
	<%
		if (session.isNew() || session.getAttribute("disk") == null) {
			session.setAttribute("disk", new ArrayList<CD>());
		}
		if ("POST".equals(request.getMethod())) {
			List<CD> disks = (List<CD>) session.getAttribute("disk");
			CD diskCd = new CD(request.getParameter("name"),
					Double.parseDouble(request.getParameter("cost")));
			disks.add(diskCd);
		}
	%>
	<footer>
		<a href="<%=request.getContextPath()%>">Back</a>
	</footer>
</body>
</html>