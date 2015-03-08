

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bluray</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
<!--            <h1>Bluray Library</h1>-->
            <div class="navbar" style="box-shadow: 10px 10px 5px #888888">
                <ul class="nav nav-pills">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Bluray Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Bluray Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Bluray Stats</a></li>
                </ul>    
            </div>
                            <hr/>
            <div class="row">
                <div class="col-md-6">
                    <h2>My Snazzy Blurays</h2>
                    <%@include file="bluraySummaryTableFragment.jsp"%>     
                   
                </div>
                <div class="col-md-6">
                    <h2>New Bluray Form</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-title" placeholder="Title">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-release-date" placeholder="Release Date">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-mpaa-rating" class="col-md-4 control-label">
                                MPAA Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-mpaa-rating" placeholder="MPAA Rating">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-director" placeholder="Director">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-studio" placeholder="Studio">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-user-rating" class="col-md-4 control-label">
                                User Rating
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-user-rating" placeholder="User Rating">
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-user-notes" class="col-md-4 control-label">
                                User Notes:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-user-notes" placeholder="User Notes">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn-btn-default">Create Bluray</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="detailsEditModalFragment.jsp"%>


        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bluray.js"></script>
    </body>
</html>

