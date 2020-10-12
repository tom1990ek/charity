<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<body>

<header class="header--form-page">

    <jsp:include page="admin_header.jsp"/>

   <div class="slogan container container--90">

        <div style="font-size: large">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Zarządzaj</th>
                </tr>
                <c:forEach var="institutions" items="${institutions}">
                    <tr>
                        <td>${institutions.id}</td>
                        <td>${institutions.name}</td>
                        <td>${institutions.description}</td>
                        <td><a href="institution/edit/${institutions.id}" role="button">Edytuj</a>
                            <a href="institution/delete/${institutions.id}" role="button">Usuń</a></td>
                    </tr>
                </c:forEach>
                <div class="slogan--item">
                    <h3>Dodaj organizację</h3>
                    <a href="institution/add" class="btn" role="button">+ Dodaj</a>
                </div>
            </table>
        </div>
    </div>


</header>


<jsp:include page="footer.jsp"/>

</body>
</html>
