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

<%= request.getAttribute("Message") %>
<form method="POST" action="PlayGame">
   <table>
    <tr>
        <td> Input Row</td>
        <td><input type="text" name="rowId" /></td>
    </tr>
    <tr>
        <td>Input Column</td>
        <td><input type="text" name="colId" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>
<br><br><br>

<c:forEach var="current" items="${BoardStates}" >

${current}
  

<br>
 </c:forEach>

</body>
</html>