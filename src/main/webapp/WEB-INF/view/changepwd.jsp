<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>SudokuBase | Change Password</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
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
                <a href="#">ABOUT</a>   
                <a href="#" onclick="window.scrollTo({top: document.body.scrollHeight, behavior: 'smooth'})">HOW TO PLAY</a>

                <a href="/login">LOGIN</a>           
                <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
            </div>

        </header>
        <main>


            <section>
                <h3>Password Reset</h3>
                <form:form action="/newpass" method="POST" modelAttribute="tempUser">
                    <form:input type="hidden" path="email"/>
                    <div class="field" style="margin-top:20px;">
                        <form:label path="password">Enter your new password</form:label>
                        <form:input id="password" type="password" path="password" required="required" value="" minlength="6" maxlength="254"/>                       
                    </div>
                    <br><br>
                    <div class="field">
                        <input type="submit" value="SAVE"/>
                    </div>
                </form:form>
            </section>


        </main>

        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js" ></script>
    </body>

</html>