// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];


// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
};

var puzzleID;
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});


$('.fa-thumbs-up, .fa-thumbs-down').on('click', function () {
    /* event.preventDefault();*/
    $('.active').removeClass('active');
    $(this).addClass('active');
    let liked;
    if ($(this).hasClass('fa-thumbs-up')) {
        liked = true;
    } else {
        liked = false;
    }
    console.log("ajax call");
    $.ajax({
        url: "/vote?id=" + puzzleID,
        method: "POST",
        contentType: 'application/json',
        data: JSON.stringify(liked)
    });

});

function updateLevel() {
   document.getElementById("pid").value= parseInt(document.getElementById("difficulty").value);
   document.getElementById("newG").href = "/play?id="+  parseInt(document.getElementById("difficulty").value);
      console.log("Value to be parsed: " + parseInt(document.getElementById("difficulty").value));

   console.log("Value in pid " +parseInt( document.getElementById("pid").value));
}
var solution = [];
var timestamp;


var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        let res = JSON.parse(this.responseText);
        fillDiagram(res.puzzle);
        fillPuzzleInfo(res);
        timestamp = new Date();
        console.log("start:" + timestamp);
    }
};
if (!document.getElementById("pid").value) {
    xhttp.open("GET", "/getGame", true);
    
} else {
    xhttp.open("GET", "/getGame?id=" + document.getElementById("pid").value, true);
}
xhttp.send();



function fillPuzzleInfo(puzzle) {
    document.getElementById('puzzleinfo').href += puzzle.id;
    document.getElementById('puzzleinfo').innerHTML = "# " + puzzle.id;
    let difficulty = "easy";
    if (puzzle.notes.length >4) {
        difficulty = "hard";
    } else if (puzzle.notes.difficulty>2) {
        difficulty = "moderate";
    }
    puzzleID = puzzle.id;
    let puzzleinfo = "<pre>";
    puzzleinfo += "Puzzle ID:      " + puzzle.id + "<br>";
    puzzleinfo += "Difficulty:     " + difficulty + "<br>";
    puzzleinfo += "Givens:         " + puzzle.clues + "<br>";
    puzzleinfo += "Uploaded on:    " + puzzle.created + "<br>";    
    puzzleinfo += "Author:         " + puzzle.author + "<br>";
    puzzleinfo += "</pre>";
    tippy('#puzzleinfo', {
        content: puzzleinfo,
        allowHTML: true,
        arrow: false
    });
}
function fillDiagram(game) {

    let container = document.getElementById("container");
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
                sudoGrid += "<input type='number' onkeydown='empty(this)' onkeyup='validate(this)' /> ";
            } else {
                sudoGrid += "<div class='clue'>" + content + "</div>";
            }
            sudoGrid += "</td>";
            counter++;
        }
        sudoGrid += "</tr>";
    }
    sudoGrid += "</table>";
    container.innerHTML = sudoGrid;
}

function empty(elem) {
    elem.value = "";
}

function validate(elem) {
    elem.blur();
    $('td>input').prop('disabled', false);
    $("td").css("box-shadow", "none");
    if (!elem.value || elem.value==="0"){
        elem.value="";
        return;
    }
    
    let timeDiff = new Date() - timestamp;
    timestamp = new Date();
    
    
    
    $('[id^=' + elem.parentNode.id.charAt(0) + ']').each(function () { //check column 
        if (this.firstChild.innerHTML === elem.value && elem.value !== "") {
            $(this).css("box-shadow", "0 0 5px 5px red");
            $('td:not(#' + elem.parentNode.id + ')>input').prop('disabled', true);
        }
    });
    $('[id$=' + elem.parentNode.id.charAt(2) + ']').each(function () { //check row   
        if (this.firstChild.innerHTML === elem.value && elem.value !== "") {
            $(this).css("box-shadow", "0 0 5px 5px red");
            $('td:not(#' + elem.parentNode.id + ')>input').prop('disabled', true);
        }
    });
    let y = Math.floor(elem.parentNode.id.charAt(0) / 3) * 3; //offsets to iterate on the right square
    let x = Math.floor(elem.parentNode.id.charAt(2) / 3) * 3;
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (elem.value !== "" && $('#' + (i + y) + '-' + (j + x)).children().html() === elem.value && elem.id !== (i + y) + '-' + (j + x)) {
                $('#' + (i + y) + '-' + (j + x)).css("box-shadow", "0 0 5px 5px red");
                $('td:not(#' + elem.parentNode.id + ')>input').prop('disabled', true);
            }
        }
    }

    let step = new Object();
    step.millis = timeDiff;
    step.number = elem.value;
    step.pos = elem.parentNode.id;
    solution.push(step);
    let cong = true;
    let inputs = $("#container").find("input");
    for (let i = 0; i < inputs.length; i++) {
        if (!(inputs[i].value > 0 && inputs[i].value < 10)) {
            cong = false;
        }
    }

    if (cong) {

        $.ajax({
            url: "/check?id=" + puzzleID,
            method: "POST",
            contentType: 'application/json',
            data: JSON.stringify(solution),
            success: function () {
                modal.style.display = "block";
                let player = document.querySelector("lottie-player");
                 player.play();
                confetti({
                    particleCount: 150,
                    spread: 180
                });
            }
        });

    }
}

