<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Home | Success</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
    </head>

    <body>
    <dummy></dummy>
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
            <a href="/login">LOGIN</a>           
            <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
        </div>

    </header>
    <main>
        <section>
            <br><br>
            <h3>Token expired!</h3>
            <br><br>


        </section>
    </main>
    <jsp:include page="footer.jsp"/>
    <script src="/js/common.js"></script>
</body>

</html>
