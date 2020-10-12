<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAnonymous()">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a  class="btn btn--small btn--without-border">Zalogowano</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <li><a style="color: brown" href="/adminPanel" class="btn btn--small btn--without-border">Panel administratora</a></li>
            </sec:authorize><br>

            <sec:authorize access="isAuthenticated()">
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="btn btn--small btn--without-border" type="submit" value="Wyloguj">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="/donation" class="btn btn--without-border active">Start</a></li>
            <li><a href="#stats" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about" class="btn btn--without-border">O nas</a></li>
            <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>