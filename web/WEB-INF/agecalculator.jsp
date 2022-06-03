<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="POST">
            <label>Enter your age:</label>
            <input type="text" name="age" value="">
            <br>
            <input type="submit" value="Age next birthday">
        </form>
        
        <c:if test="${notNum == true}">
            <a>You must enter a number.</a><br>
        </c:if>
        <c:if test="${inputNull == true}">
            <a>You must give your current age.</a><br>
        </c:if>
        <c:if test="${rightInput == true}">
            <a>Your age next birthday will be ${newAge}.</a><br>
        </c:if>
            
        <a href="arithmetic">Arithmetic Calculator</a>    
    </body>
</html>
