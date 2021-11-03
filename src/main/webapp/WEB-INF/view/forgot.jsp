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
        <link rel="stylesheet" href="css/register.css">
        <style>
            #container {
                height:auto; 
                padding:50px;
                width:60%;
            }

            @media only screen and (max-width: 600px) {
                #container {
                    width:100%;
                    padding:30px;
                }
            }
        </style>
    </head>

    <body>
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

                <a href="/login">LOGIN</a>           
                <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
            </div>

        </header>
        <main>

            <section>
                <p>If you have forgotten your password, simply enter your email address and we will send you a link to reset your password</p>

            </section>
            <section>
                <div id="container">
                    <form:form action="/recover" method="POST" modelAttribute="userEmail">
                        <div class="field" style="margin-top:20px;">
                            <form:label path="email">Email</form:label>
                            <form:input id="email" type="email" path="email" required="required" minlength="6" maxlength="254"/>                       
                        </div>

                        <div class="field">
                            <input type="submit" value="SUBMIT"/>
                        </div>
                    </form:form>
                </div>

            </section>



        </main>

        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js" ></script>
    </body>

</html>
