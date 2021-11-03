<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="SudokuBase is a free online sudoku platform. Play Sudoku, solo or multiplayer, explore our large puzzle collection and make new friends around the globe!">
        <meta name="keywords" content="Sudoku, SudokuBase, Puzzles, Logic games, Play Sudoku Online, Free Sudoku, Sudoku Platform, Sudoku Community, Sudoku Base,Sudoku Database, SudokuBase, Sudoku Multiplayer, Puzzle Database ">
        <sec:csrfMetaTags />
        <title>SudokuBase | Play Sudoku Online</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>     
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">       
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/play.css">      
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
                <a href="/register">REGISTER</a>
            </div>

        </header>
        <main>
            <input type="text" id="pid" value = "0" hidden/>
            <section>
                <p><b>The Daily Puzzle</b></p>
                <a id="puzzleinfo" href = "/puzzle?id="></a>
                <br>
                <div id="container" class="bg-white">
                </div>
                <br>
            </section>

            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times&nbsp;</span>
                    <div id = "congrats">
                        <br>
                        <h2>Congratulations!</h2><br><br>   
                        <p>For tons of puzzles and additional features <a href="/register">create an account</a>, its completely free!</p><br>

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
