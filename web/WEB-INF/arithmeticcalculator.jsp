<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST">
            <label>First:</label>
            <input type="text" name="first" value="${firstInput}">
            <br>
            <label>Second:</label>
            <input type="text" name="second" value="${secondInput}">
            <br>
            <input type="submit" name="action" value="+" />
            <input type="submit" name="action" value="-" />
            <input type="submit" name="action" value="*" />
            <input type="submit" name="action" value="%" />
        </form>
            <br>
        <c:if test="${outPut != null}">
        <a>Result: ${outPut}</a>
        </c:if>
        <c:if test="${outPut == null}">
            Result: ${outPut = "---"}
        </c:if>
        
            <br>
        <a href="age">Arithmetic Calculator</a>
    </body>
</html>
