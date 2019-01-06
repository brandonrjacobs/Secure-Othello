<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${middleName}</td>
    </tr>
</table>  
</body>
</html>
