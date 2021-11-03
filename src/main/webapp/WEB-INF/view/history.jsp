<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
        <link rel="stylesheet" href="css/history.css">
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
                <a href="/play">PLAY</a>   
                <a href="/dashboard">DASHBOARD</a>
                <form action="/logout" method=post>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="LOGOUT">
                </form>
            </div>

        </header>
        <main style="background-color:#f4f8e8">
            <section>
                <h1>Puzzle History</h1>
                <br><br>
                <table>
                    <tr>
                        <th>Puzzle ID</th>
                        <th>Givens</th>
                        <th>Solving Time</th>
                        <th>Solved on</th>

                    </tr>
                    <c:forEach items="${puzzles}" var="element"> 

                        <tr>
                            <td><a href = "/puzzle?id=${element.puzzle.id}" class="underline">${element.puzzle.id}</a></td>
                            <td>${element.puzzle.clues}</td>

                            <td>
                                <fmt:formatNumber type="number" value="${element.duration}" /> ms    
                            </td>

                            <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" 
                                            value = "${element.datesolved}" /></td>
                        </tr>
                    </c:forEach>
                </table>

            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="/js/common.js"></script>
    </body>

</html>
