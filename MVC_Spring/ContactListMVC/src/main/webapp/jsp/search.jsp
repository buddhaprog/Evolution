<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">        
    </head>
    <body>
        <div class="container">
            <h1>Search</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">
                            Contact List (No Ajax)
                        </a>
                    </li>
                </ul>    
            </div>

            <div class="row">
                <!-- This holds the summary Contact table -->
                <div class="col-md-6">
                    <h2>My Contacts</h2>
                    <h2 id="num-contacts"></h2>
                    <%@include file="contactSummaryTableFragment.jsp" %>

                </div>

                <!-- This holds the new contact form -->
                <div class="col-md-6">
                    <h2>Search Form</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-first-name" class="col-md-4 control-label">
                                First Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-first-name" placeholder="First Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-last-name" class="col-md-4 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-last-name" placeholder="Last Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-company" class="col-md-4 control-label">
                                Company:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-company" placeholder="Company">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-email" class="col-md-4 control-label">
                                Email:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-email" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-phone" class="col-md-4 control-label">
                                Phone:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-phone" placeholder="Phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="search-button" class="btn btn-default">Search Contact</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                <%@include file="detailsEditModalFragment.jsp" %>


                <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>    
                <script src="${pageContext.request.contextPath}/js/contactList.js"></script>

                </body>
                </html>