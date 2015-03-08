

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/vending-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/whitetest.jpg">

    </head>
    <body>
        <section>
            <div class="vending-template">
                <h1 style="border-bottom: 2px solid darkslategray">VENDING MACHINE</h1>
            </div>
        </section>




        <%@include file="moneyTableFragment.jspf"%>   
        <%@include file="insertMoneyModalFragment.jspf"%>
        <%@include file="vendingMachineGridFragment.jspf"%>
        <%@include file="vendingModalFragment.jspf"%>



        <div class="foot">
            <footer>
                <h2> Created and maintained by Buddhaworks.org </h2>
                <h4>example of holding information in the browser and manipulating it, no DB required</h4>
            </footer>
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingmachine.js"></script>
    </body>
</html>


