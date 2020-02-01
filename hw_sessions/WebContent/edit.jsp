<%@ page import="org.itstep.CD"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType="text/html" language="java"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
	<form method="post">
		<h1>Edit disk</h1>
		<label>Name: <input name="name" required />
		</label><br /> <label>Cost: <input name="cost" min="0" required />
		</label><br />
		<button type="submit">Edit</button>
	</form>
	<%
		if ("POST".equals(request.getMethod())) {
			List<CD> disks = (List<CD>) session.getAttribute("disk");
			for (CD disk : disks) {
				if (request.getParameter("name").equals(disk.getName())) {
					disks.remove(disk);
					CD diskCd = new CD(disk.getName(),
							Integer.parseInt(request.getParameter("cost")));
					disks.add(diskCd);
					break;
				} else {
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