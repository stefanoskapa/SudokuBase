<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Sudokubase | Confirmation</title>
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
    <dummy></dummy>
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
            <div id ="container">
                <h1>Almost done!</h1>
                <br><br>
                <p>An email has been sent to <b>${email}</b> containing an activation link.              
                    Please click on the link to activate your account. If you do not receive
                    the email within a few minutes, please check your spam folder.</p>


            </div>
        </section>
    </main>
    <jsp:include page="footer.jsp"/>
    <script src="/js/common.js"></script>
</body>

</html>
