<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monopoly</title>
<link rel="stylesheet" type="text/css" href="style/monopoly.css">
</head>
<body>
<center>
<img src="images/Monopoly-logo.jpg" width="500" height="190"/>
<form action="Play">
How many players? <input type="text" name="numberOfPlayers" size="1"/>
<input type="submit" value="Play!"/>
<input type="hidden" name="newGame" value="true"/>
</form>
</center>
</body>
</html>