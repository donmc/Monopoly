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
<center>
<img src="images/Monopoly-logo.jpg" width="500" height="190"/>
<form action="Play">
<input type="submit" value="Play a Round"/>
<input type="hidden" name="newGame" value="false"/>
</form>
<br/>
<c:forEach items="${game.players}" var="player">
	<c:choose>
		<c:when test="${player.isFirstRoll}">
			<p>
				<b>${player.token}</b> is on <b>${player.location.name}</b> and
				has <b>$${player.money}</b>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<b>${player.token}</b> rolled <b>${player.lastRoll}</b> and landed
				on <b>${player.location.name}</b> and has <b>$${player.money}</b>
			</p>
		</c:otherwise>
	</c:choose>

</c:forEach>
<br/>
<p><a href="/MonopolyWeb">Reset Game</a></p>
</center>
</body>
</html>