<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <sec:csrfMetaTags />
        <title>SudokuBase | Play</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Cedarville+Cursive&display=swap" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>     
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/play.css">
    </head>

    <body>
        <header>
            <div id="logo">
                <a href = "/home">
                <img src="/img/sudoku_base-logo-blue.svg" alt="SudokuBase" height="45"> 

                <button id ="crazyham" class="hamburger hamburger--spin icon" type="button" onclick="myFunction()">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>
            </a>
            </div>

            <div id="homelinks">             
                <a href="/dashboard">DASHBOARD</a>   
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="LOGOUT">
                </form>
            </div>

        </header>
        <main>
            <input type="text" id="pid" value = "${pid}" hidden/>

            <section>
                <p><b>Random Puzzle</b></p>
                <a id="puzzleinfo" href = "/puzzle?id="></a>
                <br>
                <div id="container">

                </div>
                <br>

                <div id="underpuzzle">
                    <select id = "difficulty" onchange="updateLevel()">
                        <option value="1" selected>easy</option>
                        <option value="2">moderate</option>
                        <option value="3">hard</option>
                    </select>
                    <a href="/play" class="newgame" id = "newG"><button class="btn">New Puzzle</button></a>

                </div>


            </section>
            <!-- The Modal -->
           <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times&nbsp;</span>
                    <div id = "congrats">
                        <br>
                        <h2>Congratulations!</h2><br><br>   
                        <p>Fancy another one? Solve a new <a href="/play">random puzzle</a></p><br>
                        
                    </div>
                </div>
            </div>

        </main>
        <jsp:include page="footer.jsp"/>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.min.js"></script>
        <script src="https://unpkg.com/tippy.js@6/dist/tippy-bundle.umd.js"></script>
        <script src="/js/common.js"></script>
        <script src="/js/play.js"></script>
    </body>

</html>
