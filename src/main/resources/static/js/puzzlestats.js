var likes = parseInt(document.getElementById("ups").value);
var dislikes = parseInt(document.getElementById("downs").value);
console.log("likes: " + likes);
console.log("dislikes: " + dislikes);
var total = likes+dislikes;
console.log("total: " + total);
var likePerc = (likes/total)*100;
var dislikePerc = (dislikes/total)*100;
console.log("likePerc: " + likePerc);

$(document).ready(function() {
    $(".likes").css("width", likePerc);
    $(".dislikes").css("width", dislikePerc);
});

fillDiagram(document.getElementById("puzzlestring").value);
function fillDiagram(game) {

    let container = document.getElementById("puzzle");
    let counter = 0;
    let sudoGrid = "";
    sudoGrid += "<table><colgroup><col><col><col></colgroup>";
    sudoGrid += "<colgroup><col><col><col></colgroup>";
    sudoGrid += "<colgroup><col><col><col></colgroup>";

    for (let j = 0; j < 9; j++) {
        if (j % 3 === 0) {
            sudoGrid += "<tbody>";
        }
        sudoGrid += "<tr>";
        for (let i = 0; i < 9; i++) {

            sudoGrid += "<td id = '" + j + "-" + i + "'>";
            let content = game.charAt(counter);
            if (content === "0") {
                content = " ";
            }
            
                sudoGrid += "<div class='clue'>" + content + "</div>";
            
            sudoGrid += "</td>";
            counter++;
        }
        sudoGrid += "</tr>";
    }
    sudoGrid += "</table>";
    container.innerHTML = sudoGrid;
}

