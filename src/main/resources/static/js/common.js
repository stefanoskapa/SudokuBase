function myFunction() {
    var x = document.getElementById("homelinks");
    var y = document.getElementById("crazyham");
    if (x.style.display === "flex") {
        x.style.display = "none";
        y.classList.remove("is-active");
        document.getElementsByTagName("header")[0].style.paddingTop = "0px";
        document.getElementsByTagName("header")[0].style.paddingBottom = "0px";
        document.getElementsByTagName("header")[0].style.height = "80px";
    } else {
        document.getElementsByTagName("header")[0].style.height = "auto";
        document.getElementsByTagName("header")[0].style.paddingTop = "10px";
        document.getElementsByTagName("header")[0].style.paddingBottom = "20px";

        x.style.display = "flex";
        y.classList.add("is-active");
    }
}



