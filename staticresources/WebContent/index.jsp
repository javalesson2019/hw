<html lang="en">
<head>
    <title>Registration</title>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<form action="<%=request.getContextPath()%>/registration" method="post">
    <p>Registration</p>
    <div>
        <label for="login">Login</label>
        <input name="login" id="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
    </div>
    <input type="submit" value="Sign Up"/>
</form>
<form action="<%=request.getContextPath()%>/user" method="post">
    <p>Entry</p>
    <div>
        <label for="log">Login</label>
        <input name="log" id="log"/>
    </div>
    <div>
        <label for="pass">Password</label>
        <input type="password" name="pass" id="pass"/>
    </div>
    <input type="submit" value="Sign in"/>
</form>
</body>
</html>