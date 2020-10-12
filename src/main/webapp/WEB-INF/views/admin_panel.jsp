<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
<%--    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>--%>
</head>

<body>

<header class="header--form-page">

    <jsp:include page="admin_header.jsp"/>

    <center><br/><br/><a href="/adminPanel/institution" class="btn" role="button">Zarządzaj organizacjami</a><br/><br/></center>
    <center><br/><br/><a href="/adminPanel/allUsers" class="btn" role="button">Zarządzaj użytkownikami</a><br/><br/></center>
    <center><br/><br/><a href="/admins" class="btn" role="button">Zarządzaj administratorami</a><br/><br/></center>
</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
