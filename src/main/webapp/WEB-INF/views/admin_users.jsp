<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<header class="header--form-page">

    <jsp:include page="admin_header.jsp"/>

    <div class="slogan container container--90">
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Zarządzaj</th>
                </tr>
                <c:forEach var="users" items="${allusers}">
                    <tr>
                        <td>${users.id}</td>
                        <td>${users.firstName}</td>
                        <td>${users.lastName}</td>
                        <td>${users.email}</td>

                        <td><a href="edit/${users.id}" role="button">Edytuj</a>
                            <a href="delete/${users.id}" role="button">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>