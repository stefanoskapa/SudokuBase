<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Dashboard</title>      
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/profile.css">
    </head>

    <body>
        <header>
            <div id="logo">
                <img src="/img/zeitvertreib.png" alt="logo" width="40" height="40"> 
                <button id ="crazyham" class="hamburger hamburger--spin icon" type="button"  onclick="myFunction()">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>
            </div>

            <div id="homelinks">             
                <a href="/play">Play</a>        
                <a href="/dashboard">Dashboard</a> 
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Logout">
                </form>
            </div>

        </header>
        <header>
            <div id="logo">
                <img src="/img/sudoku_base-logo-blue.svg" alt="SudokuBase" height="45"> 

                <button id ="crazyham" class="hamburger hamburger--spin icon" type="button" onclick="myFunction()">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>

            </div>

            <div id="homelinks">             
                <a href="/play">PLAY</a>              
                <a href="/dashboard">DASHBOARD</a>              
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="LOGOUT">
                </form>
            </div>

        </header>

        <main>

            <section>
                <div id="container">
                    <form:form action="/save" method="POST" modelAttribute="tempUser">


                        <div class="field">
                            <form:label path="username">username</form:label>
                            <form:input id = "username" type="text"  path="username" required="required" minlength="1" maxlength="16"/>
                            <form:errors path="username"/>                            
                        </div>
                        <br>
                        <div class="field">
                            <form:label path="email">email</form:label>
                            <form:input id = "email" type="text" path="email" readonly="true" />
                            <form:input id = "password" type="text" path="password" value="123456" readonly="true" hidden="true"/>
                        </div>                  
                        <br>

                        <div class="field">
                            <form:label path="fname">first name</form:label>
                            <form:input id = "fname" type="text" path="fname" maxlength="30"/>
                            <form:errors path="fname"/>                            
                        </div>
                        <br>

                        <div class="field">
                            <form:label path="lname">last name</form:label>
                            <form:input id = "lname" type="text" path="lname" maxlength="30"/>
                            <form:errors path="lname"/>                            
                        </div>
                        <br>

                        <div class="field">
                            <form:label path="country">country</form:label>
                            <form:select path="country">
                                <option value = "none">Not specified</option>
                                <c:forEach items="${countries}" var="element"> 
                                    <option value="${element.code2}" <c:if test="${element.code2 eq tempUser.country.code2}"> selected </c:if>>${element.name}  </option>
                                </c:forEach> 
                            </form:select>
                            <form:errors path="country" /> 
                        </div>
                        <br>

                        <div class="field">
                            <input type="submit" value="SAVE"/>
                        </div>
                    </form:form>
                </div>
                <br><br>
                <a href="/delete" id="delete" class="underline">Delete Account</a>
            </section>

            <section></section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js"></script>
    </body>

</html>
