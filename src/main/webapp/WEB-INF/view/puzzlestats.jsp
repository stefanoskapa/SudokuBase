<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>SudokuBase | Puzzle Info</title>
        <link rel="stylesheet" href="css/classes.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/hamburgers.css" rel="stylesheet">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/puzzlestats.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>    
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
            <input type ="number" id ="ups" value = "${positive}" hidden/>
            <input type ="number" id ="downs" value = "${negative}" hidden/>
            <input type ="text" id ="puzzlestring" value = "${puzzle}" hidden/>
            <section class="blue">

                <div id="container">
                    <div class = "infocolumn">    
                        <div id="puzzle"></div>
                        <br>
                        <h4>Puzzle Information</h4>
                        <br>
                        <p>Puzzle ID:&nbsp ${id}</p>
                        <p>Givens:&nbsp&nbsp&nbsp&nbsp&nbsp ${clues}</p>
                        <p>Created:&nbsp&nbsp&nbsp ${created}</p>
                        <p>Author:&nbsp&nbsp&nbsp&nbsp&nbsp ${author}</p>
                        <p>Grade:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${notes}</p>
                        <c:forEach items="${techniques}" var="element">  
                            <button style="margin:4px; padding:8px; background-color: #e7e7e7;color:black; border-radius: 15px; border:none;" class="btn">
                                ${element} <br>
                            </button>



                        </c:forEach>

                        <br>
                        <a href="/play?id=${id}" class="newgame"><button class="btn">SOLVE</button></a>
                        <br><br>
                    </div>

                    <div class="infocolumn">
                        <h4>Solver Statistics</h4><br>

                        <c:if test = "${scorer !=null}">
                            <p>Best time: ${bestTime} ms by ${scorer}</p>
                        </c:if>

                        <c:if test = "${solvers != 0}">
                            <p>Solved by ${solvers} 
                                <c:if test = "${solvers == 1}">
                                    person
                                </c:if>
                                <c:if test = "${solvers > 1}">
                                    people
                                </c:if>
                            </p>
                        </c:if>

                        <c:if test = "${solvers == 0}">
                            <p> Nobody has solved this puzzle yet</p>
                        </c:if>


                        <c:if test = "${positive != 0 || negative != 0 }">
                            <div id="votes">
                                <p>Upvotes/Downvotes: &nbsp </p>
                                <div class='progressBar'>
                                    <div class='likes'>
                                        <c:if test = "${positive != 0}">
                                            <b> ${positive}</b>
                                        </c:if>
                                    </div>
                                    <div class='dislikes'>
                                        <c:if test = "${negative != 0}">
                                            <b> ${negative}</b>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <br><br>
                    </div>

                    <div class="infocolumn">
                        <h4>Your statistics</h4><br>
                        <p>Solved: 
                            <c:if test = "${isSolved == true}">
                                <i class ="fa fa-check-circle" style="color:green"></i>
                            </c:if>
                            <c:if test = "${isSolved == false}">
                                <i class ="fa fa-times-circle" style="color:red"></i>
                            </c:if>
                        </p>
                    </div>
                </div>
            </section>



        </main>

        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js" ></script>
        <script src="/js/puzzlestats.js" ></script>
    </body>

</html>
