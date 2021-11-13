<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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

        <sec:authorize access="isAuthenticated()">    
            <a href="/dashboard">DASHBOARD</a>   
            <form action="/logout" method=post>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="LOGOUT">
            </form>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <a href="/login">LOGIN</a>           
            <a href="/register">REGISTER</a>
        </sec:authorize>






    </div>

</header>