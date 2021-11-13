<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
    <div id="logo">
        <a href = "/">
            <img src="/img/sudoku_base-logo-blue.svg" alt="SudokuBase" height="45"> 
        </a>
        <button id ="crazyham" class="hamburger hamburger--spin icon" type="button" onclick="myFunction()">
            <span class="hamburger-box">
                <span class="hamburger-inner"></span>
            </span>
        </button>
    </div>

    <div id="homelinks">    
        <c:choose>
            <c:when test="${empty logged_in}">
                <a href="/login">LOGIN</a>           
                <a href="/register">REGISTER</a>
            </c:when>
            <c:otherwise>
                <a href="/">HOME</a>    
                <a href="/dashboard">DASHBOARD</a>   
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="LOGOUT">
                </form>
            </c:otherwise>
        </c:choose>

    </div>

</header>