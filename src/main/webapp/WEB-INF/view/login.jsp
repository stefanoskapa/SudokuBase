<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Login</title>
        <link rel="stylesheet" href="css/classes.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/login.css">
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
                <a href="/">HOME</a>           
                <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
            </div>

        </header>
        <main>
            <section>
                <div id="container">

                    <div id="err"></div>
                    <form:form action="/auth" method="POST">

                        <div class="field">
                            <label>Username<br></label>
                            <input type="text" name="username" required="required" maxlength="16"/>
                        </div>
                        <div class="field">
                            <label>Password</label>
                            <input type="password" name="password" required="required" minlength ="6" maxlength="68"/>
                        </div>

                        <div class="field">
                            <input type="submit" value="LOGIN">  
                        </div>


                    </form:form>

                </div>
                <br><br>
                <a href="/recover" class="underline">Forgot your password?</a>

            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.min.js"></script>
        <script src="https://unpkg.com/tippy.js@6/dist/tippy-bundle.umd.js"></script>
        <script src="/js/common.js"></script>
        <script src="/js/login.js"></script>
    </body>

</html>
