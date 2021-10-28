

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
        <link rel="stylesheet" href="css/dashboard.css">
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
                <a href="/play">PLAY</a>   
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="LOGOUT">
                </form>
            </div>

        </header>


        <main>
            <section>

                <br>
                <br>
                <a href ="/play" class = "fancy">Play<i class="fa fa-pencil"></i></a>
                <a href="/history" class="fancy">History<i class="fa fa-history"></i></a>
                <a href="/profile" class="fancy">Profile<i class="fa fa-user"></i></a>

            </section>

        </main>
        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js"></script>           
    </body>

</html>
