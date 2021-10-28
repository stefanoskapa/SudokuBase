let err1 = document.getElementById("err1").value;
if (err1) {
    tippy('#username', {
        showOnCreate: true,
        content: err1,
        trigger: 'manual',
        placement: 'auto'
    });
}

let err2 = document.getElementById("err2").value;
if (err2) {
    tippy('#email', {
        showOnCreate: true,
        content: err2,
        trigger: 'manual',
        placement: 'auto'
    });
}

$(".toggle-password").click(function() {
    console.log("clicked");

  $(this).toggleClass("fa-eye fa-eye-slash");
  var input = $($(this).attr("toggle"));
  if (input.attr("type") == "password") {
    input.attr("type", "text");
  } else {
    input.attr("type", "password");
  }
});



