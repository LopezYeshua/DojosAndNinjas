<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/js/bootstrap.min.js" defer></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript" src="/js/app.js" defer></script>
    <title></title>
</head>
<body class="bg-dark">
    <div class="container mt-5">
        <div class="row">
            <div class="col">
                <div class="card w-50">
                    <div class="card-header">
                        <h3>New Dojo</h3>
                    </div>
                    <div class="card-body">
                        <form:form action="/dojos" method="post" modelAttribute="dojo">
                            <form:label class="form-label" path="name">Name</form:label>
                            <form:input class="form-control" type="text" path="name"/>
                            <input type="submit" value="SUBMIT">
                        </form:form>
                    </div>
                    <div class="card-footer">
                        <a href="/ninjas">Create Ninja</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dojo" items="${dojos}">
                            <tr>
                                <td><a href="/dojos/show/${dojo.id}" class="unstyle">
                                    <c:out value="${dojo.name}"></c:out>
                                </a></td>
                                <td class="d-flex gap-3">
                                    <a class="btn btn-success" href="/dojos/edit/{id}">edit</a>
                                    <p>|</p>
                                    <form:form action="/dojos/delete/{id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input class="btn btn-danger" type="submit" value="DELETE">
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>