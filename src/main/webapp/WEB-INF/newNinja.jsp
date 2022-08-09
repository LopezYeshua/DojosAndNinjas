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
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                New Ninja
            </div>
            <div class="card-body">
                <form:form action="/ninjas" method="post" modelAttribute="ninja">
                    <div>
                        <form:label class="form-label" path="dojo">Dojo</form:label>
                        <form:select path="dojo">
                            <c:forEach var="dojo" items="${dojos}">
                                <option value="${dojo.id}">${dojo.name}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div>
                        <form:label class="form-label" path="firstName">First Name</form:label>
                        <form:input class="form-control" type="text" path="firstName"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="lastName">Last Name</form:label>
                        <form:input class="form-control" type="text" path="lastName"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="age">Age</form:label>
                        <form:input class="form-control" type="number" path="age"/>
                    </div>
                    <input type="submit" value="SUBMIT">
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>