document.onload = new function () {
    try {
        const accessToken = document.cookie
            .split('; ')
            .find(row => row.startsWith('currentUserToken'))
            .split('=')[1];
        getProfileDetails(accessToken);
    }catch (e) {
        console.log("something went wrong trying to retrieve user info: " + e)
        window.location.href = "/login"
    }


}

function getProfileDetails(accessToken) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", '/getUserInfo', true); // true is asynchronous
    xhttp.setRequestHeader("Authorization", "Bearer "+accessToken);
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let object = JSON.parse(xhttp.responseText);
            console.log(object)
            if (object) {
                //put profile info where necessary
                var currentUserTag = document.getElementById("currentUserTag");
                currentUserTag.innerHTML = "[@" + object["user_id"] + "] " + object["full_name"]
            }
        } else {
            console.error(xhttp.statusText);
            if(xhttp.status === 403){
                logout()
            }
        }
    };
    xhttp.send();
}

function logout(){
    deleteCookie("currentUserToken")
    window.location.href = "/login"
}

function showProfile() {
    window.location.href="/completeDetails"

}
function profile() {
    window.location.href="/showDetails"

}

var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
})

function deleteCookie(name) { setCookie(name, '', -1); }

function setCookie(name, value, days) {
    var d = new Date;
    d.setTime(d.getTime() + 24*60*60*1000*days);
    document.cookie = name + "=" + value + ";path=/;expires=" + d.toGMTString();
}