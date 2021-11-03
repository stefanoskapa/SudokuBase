<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Play Sudoku Online</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/register.css">
        <style>
            #container {
                height:auto; 
                padding:50px;
                width:40%;
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
    <dummy>

    </dummy>
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

            <a href="/">HOME</a>
            <a href="/login">LOGIN</a>           
            <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
        </div>

    </header>
    <main>
        <section>
            <div id="container">
                <br>
                <h1>We are sorry to see you go!</h1>

                <br>
                Please confirm the deletion of your account. <br>
                By clicking the button below your account will be removed. 
                <br><br><br>

                <form action="/delete" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Delete Account">
                </form>

            </div>
            <br><br>
            <a href="/dashboard" class="underline">I changed my mind</a>


        </section>
    </main>
    <jsp:include page="footer.jsp"/>
    <script src="/js/common.js"></script>
</body>

</html>
