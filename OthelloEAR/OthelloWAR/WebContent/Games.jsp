<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Create New Game
<br>
<form method="POST" action="CreateGame">
   <table>
    <tr>
        <td> Game Name</td>
        <td><input type="text" name="gameName" /></td>
    </tr>
        
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>
<br>
<br>
<br>
<h1> Current Game </h1>
<c:forEach var="current" items="${AllGames}" >

	<c:if test="${current.gameStatus == 'CURRENT' }">
  <a href="StartGame?gameId=${current.gameId}" > ${current.gameName}</a>
<br>
  </c:if>
 </c:forEach>

<h1> Available Game </h1>
<c:forEach var="current" items="${AllGames}" >

	<c:if test="${current.gameStatus == 'WAIT' }">
  <a href="StartGame?gameId=${current.gameId}" > ${current.gameName}</a>
<br>
  </c:if>
 </c:forEach>



<h1> Your Pending Games </h1>

<c:forEach var="current" items="${AllGames}" >

<c:if test="${current.gameStatus == 'PENDING' }">
    ${current.gameName}
 <br> 
</c:if>
 </c:forEach>

<h1> Your Completed Games</h1>

</body>
</html>