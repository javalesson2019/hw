<%@ page contentType="text/html" language="java"%>
<%@ page import="org.itstep.CD"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CD</title>

</head>
<body>
	<h1>Here is the list of disks.</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Cost</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (session.getAttribute("disk") != null) {
					List<CD> disks = (List<CD>) session.getAttribute("disk");
					for (CD disk : disks) {
						out.write("<tr>");
						out.write("<td>" + disk.getName() + "</td>");
						out.write("<td>" + disk.getCost() + "</td>");
						out.write("</tr>");
					}
				}
			%>
		</tbody>
	</table>
	<footer>
		<a href="<%=request.getContextPath()%>/add.jsp">Add</a><br /> <a
			href="<%=request.getContextPath()%>/delete.jsp">Delete</a><br /> <a
			href="<%=request.getContextPath()%>/edit.jsp">Edit</a><br />
	</footer>
</body>
</html>