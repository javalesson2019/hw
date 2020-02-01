<%@ page import="org.itstep.CD"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html" language="java"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete</title>
</head>
<body>
	<form method="post">
		<h1>Delete disk</h1>
		<label>NameDisk: <input name="name" required />
		</label>
		<button type="submit">Delete</button>
	</form>
	<%
		if ("POST".equals(request.getMethod())) {
			List<CD> disks = (List<CD>) session.getAttribute("disk");
			for (CD disk : disks) {
				if (request.getParameter("name").equals(disk.getName())) {
					disks.remove(disk);
					break;
				}
			}
		}
		if (session.isNew() || session.getAttribute("disk") == null) {
			session.setAttribute("disk", new ArrayList<CD>());
		}
	%>
	<footer>
		<a href="<%=request.getContextPath()%>">Back</a>
	</footer>
</body>
</html>