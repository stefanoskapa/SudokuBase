<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Register</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>     
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/register.css">

    </head>

    <body>
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

                <a href="/">HOME</a>           
                <a href="/login" >LOGIN</a>
            </div>

        </header>
        <main>
            <section>
                <div id="container">

                    <input id ="err1" type="text" value="${error1}" hidden/>
                    <input id ="err2" type="text" value="${error2}" hidden/>


                    <form:form action="/register" method="POST" modelAttribute="newUser">

                        <div class="field">
                            <form:label path="username">Username</form:label>
                            <form:input id = "username" type="text" path="username" required="required" minlength="1" maxlength="16"/>
                            <form:errors path="username"/>                            
                        </div>

                        <div class="field">
                            <form:label path="password">Password</form:label>
                            <form:input type="password" id="password-field" path="password" required="required" minlength="6" maxlength="68" />
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            <form:errors path="password"/>       

                        </div>

                        <div class="field" style="margin-top:20px;">
                            <form:label path="email">Email</form:label>
                            <form:input id="email" type="email" path="email" required="required" minlength="6" maxlength="254"/>
                            <form:errors path="email"/>
                        </div>

                        <div class="field">
                            <input type="submit" value="REGISTER"/>
                        </div>
                    </form:form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.min.js"></script>
        <script src="https://unpkg.com/tippy.js@6/dist/tippy-bundle.umd.js"></script>
        <script src="/js/common.js"></script>
        <script src="/js/register.js"></script>
    </body>

</html>