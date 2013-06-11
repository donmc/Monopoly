<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monopoly</title>
<link rel="stylesheet" type="text/css" href="style/monopoly.css">
</head>
<body>
<center><img src="images/Monopoly-logo.jpg" width="500" height="190"/></center>
<c:forEach items="${game.players}" var="player">
<p>${player.token} is on ${player.location.name}</p>

</c:forEach>
<a href="/MonopolyWeb">Home</a>
</body>
</html>