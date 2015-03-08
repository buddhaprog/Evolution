<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact List</title>

    </head>
    <body>
        <h1>Company Contacts</h1>
        <a href="${pageContext.request.contextPath}/index.jsp">Home</a><br>
        <a href="${pageContext.request.contextPath}/displayNewContactForm">Add a Contact</a>
        <hr>
        
        
        
<!--        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>-->

    </body>
</html>



