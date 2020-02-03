<html>
<head>
<meta charset="UTF-8">
<title>cookies hw</title>
</head>
<body>
	<h2>Create</h2>
	<form method="post" action="add">
		<table>
			<tr>
				<td><label for="keyAdd">Key:</label></td>
				<td><input id="keyAdd" name="key" /></td>
			</tr>
			<tr>
				<td><label for="valueAdd">Value:</label></td>
				<td><input id="valueAdd" name="value" /></td>
			</tr>
			<tr>
				<td><label for="timeAdd">Life time:</label></td>
				<td><input id="timeAdd" name="life time" /></td>
			</tr>
			<tr>
				<td><label for="domainAdd">Domain:</label></td>
				<td><input id="domainAdd" name="domain" /></td>
			</tr>
			<tr>
				<td><label for="httpHttpsAdd">HTTPS:</label></td>
				<td><input type="radio" id="httpHttpsAdd" name="httpHttps"
					value="HTTPS" checked /></td>
			</tr>
			<tr>
				<td><label for="httpHttpAdd">HTTP:</label></td>
				<td><input type="radio" id="httpHttpAdd" name="httpHttps"
					value="HTTP" /></td>
			</tr>
		</table>
		<button type="submit">Add</button>
	</form>


	<h2>Change</h2>
	<form method="post" action="changeCookie">
		<table>
			<tr>
				<td><label for="keyChange">Key:</label></td>
				<td><input id="keyChange" name="key" /></td>
			</tr>
			<tr>
				<td><label for="valueChange">Value:</label></td>
				<td><input id="valueChange" name="value" /></td>
			</tr>
			<tr>
				<td><label for="timeChange">Life time:</label></td>
				<td><input id="timeChange" name="life time" /></td>
			</tr>
			<tr>
				<td><label for="domainChange">Domain:</label></td>
				<td><input id="domainChange" name="domain" /></td>
			</tr>
		</table>
		<button type="submit">Change</button>
	</form>


	<h2>Delete</h2>
	<form method="post" action="delete">
		<table>
			<tr>
				<td><label for="keyDelete">Key:</label></td>
				<td class="inp"><input id="keyDelete" name="key" /></td>
			</tr>
		</table>
		<button type="submit">Delete</button>
	</form>


</body>
</html>