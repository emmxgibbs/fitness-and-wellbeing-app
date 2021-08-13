document.onload = new function () {
    try {
        const accessToken = document.cookie
            .split('; ')
            .find(row => row.startsWith('currentUserToken'))
            .split('=')[1];
        verifyConsoleType(accessToken);
    }catch (e) {
        console.log("something went wrong trying to retrieve user info: " + e)
        window.location.href = "/login"
    }
}

function verifyConsoleType(accessToken){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", '/verifyUser', false); // true is asynchronous
    xhttp.setRequestHeader("Authorization", "Bearer "+accessToken);
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let object = xhttp.responseText
            if (object) {
                console.log(object)
                document.write(object)
            }
        }else{
            console.log(xhttp.status +": " + xhttp.statusText)
            if(xhttp.status === 403){
                deleteCookie("currentUserToken")
                window.location.href = "/login"
            }
        }
    };
    xhttp.send();
}

function deleteCookie(name) { setCookie(name, '', -1); }

function setCookie(name, value, days) {
    var d = new Date;
    d.setTime(d.getTime() + 24*60*60*1000*days);
    document.cookie = name + "=" + value + ";path=/;expires=" + d.toGMTString();
}