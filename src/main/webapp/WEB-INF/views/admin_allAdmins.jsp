<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<header class="header--form-page">

    <jsp:include page="admin_header.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h2>Dodaj admina</h2>
            <a href="/registeradmin" class="btn" role="button">+ Dodaj</a>
        </div>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Zarządzaj</th>
                </tr>
                <c:forEach var="admin" items="${admins}">
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.firstName}</td>
                        <td>${admin.lastName}</td>
                        <td>${admin.email}</td>
                        <td><a href="adminPanel/edit/${admin.id}" role="button">Edytuj</a>
                            <a href="adminPanel/delete/${admin.id}" role="button">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
