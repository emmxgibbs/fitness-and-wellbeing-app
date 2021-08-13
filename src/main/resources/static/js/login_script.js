document.onload = new function () {
    // URLSearchParams.delete();
    try {
        const accessToken = document.cookie
            .split('; ')
            .find(row => row.startsWith('currentUserToken'))
            .split('=')[1];
        window.location.href = "/console"
    }catch (e) {
        console.log("session access token either invalid or unavailable: " + e)
    }
}

document.getElementById("defaultTab").click();
function openTab(tabName, elmnt) {
    // Hide all elements with class="tabcontent" by default */
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Remove the background color of all tablinks/buttons
    tablinks = document.getElementsByClassName("loginRegTabLinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
        tablinks[i].style.color = "#707070";
    }

    // Show the specific tab content
    document.getElementById(tabName).style.display = "flex";

    // update color of button used to open the tab content
    try {
        elmnt.style.backgroundColor = "#EFEFEF";
        elmnt.style.color = "#707070"
    } catch (e) {
        console.log(e)
    }
}

function registerUser(){
    var full_name_inp = document.getElementById("full_name_reg");
    var username_inp = document.getElementById("username_reg");
    var pwd_inp = document.getElementById("pwd_reg");
    var user_type_inp = document.getElementById("user_type_reg");

    var full_name = full_name_inp.value;
    var username = username_inp.value;
    var pwd = pwd_inp.value;
    var user_type = user_type_inp.value;

    var requestBody = {
        full_name: full_name,
        username: username,
        password: pwd,
        user_type: user_type
    }

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", '/register', false); // true is asynchronous
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            console.log(xhttp.responseText);
            let object = JSON.parse(xhttp.responseText);
            console.log(object)
            if (object) {
                full_name_inp.value = "";
                username_inp.value = "";
                pwd_inp.value = "";
                user_type_inp.value = "";
                var requestBody = {
                    username: username,
                    password: pwd
                }
                sendAuthRequest(requestBody)
            }
        } else {
            console.error(xhttp.statusText);
        }
    };
    xhttp.send(JSON.stringify(requestBody));
}

function authenticateUser(){
    var username_inp = document.getElementById("username");
    var pwd_inp = document.getElementById("pwd");

    var username = username_inp.value;
    var pwd = pwd_inp.value;

    var requestBody = {
        username: username,
        password: pwd
    }
    sendAuthRequest(requestBody)
}

function sendAuthRequest(requestBody){
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", '/authenticate', false); // true is asynchronous
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            console.log(xhttp.responseText);
            let object = JSON.parse(xhttp.responseText);
            console.log(object)
            if (object) {
                //save access token as a cookie
                document.cookie = "currentUserToken="+object["jwt"];
                window.location.href = "/console";
            }
        } else {
            console.error(xhttp.statusText);
        }
    };
    xhttp.send(JSON.stringify(requestBody));
}