<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<header>

    <jsp:include page="admin_header.jsp"/>

    <div class="slogan container container--90">
        <div style="font-size: large">
            <form:form method="post" action="/adminPanel/institution/save" modelAttribute="institution">
                <form:input placeholder="${institution.id}" path="id" class="form-control input-md" readonly="true" />
                Name: <form:input path="name"/><br/>
                Description: <form:input path="description"/><br/>

                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>