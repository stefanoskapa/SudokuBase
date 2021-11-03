<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Privacy Policy</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/register.css">
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
                <a href="/login">LOGIN</a>           
                <a href="/register" id="create">CREATE YOUR ACCOUNT</a>
            </div>
            <style>

                #container {
                    height:90%;
                    width:50%;
                }
                @media only screen and (max-width: 700px) {
                    #container {
                        height:90%;
                        width:90%;
                    }
                }
            </style>

        </header>
        <main>


            <section>


                <div id="container">

                    <div id="err"></div>
                    <form:form action="/contact" method="POST">

                        <div class="field">
                            <label>Name<br></label>
                            <input type="text" name="name" required="required" maxlength="60"/>
                        </div>
                        <div class="field">
                            <label>Email</label>
                            <input type="email" name="email" required="required" minlength ="6" maxlength="68"/>
                        </div>
                        <div class="field">
                            <label for="message">Message</label>
                            <textarea id="subject" name="message" style="height:200px; resize: none; padding:5px;"></textarea>
                        </div>

                        <div class="field">
                            <input type="submit" value="SEND">  
                        </div>


                    </form:form>
                </div>





            </section>

        </main>
        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js" ></script>
    </body>

</html>
