const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);

if (urlParams.has('error')) {
    
    tippy('#err', {
        showOnCreate: true,
        content: "Invalid credentials or confirmation required!",
        arrow: false,
        trigger: 'manual',
        placement: 'auto'
    });
}

