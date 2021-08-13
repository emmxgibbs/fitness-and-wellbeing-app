// Get the tab element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

function openPage(tabName, elmnt) {
    // Hide all elements with class="tabcontent" by default */
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Remove the background color of all tablinks/buttons
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
        tablinks[i].style.color = "#707070";
    }

    // Show the specific tab content
    document.getElementById(tabName).style.display = "flex";

    // update color of button used to open the tab content
    try {
        elmnt.style.backgroundColor = "#707070";
        elmnt.style.color = "#E8E8E8"
    } catch (e) {
        console.log(e)
    }

    loadTabItems(tabName, elmnt);
}

function loadTabItems(tabName, elmnt) {
    switch (tabName) {
        case "Clients":
            let clientTabPanel = document.getElementById(tabName);
            clientTabPanel.innerHTML = "";
            getClients(clientTabPanel, elmnt);
            break;

        case "Calendar":
            //load calendar tab content
            break;

        case "ClientInfo":
            //load client info tab content;
            break;

        case "Comment":
            //load comment info tab content;
            break;

        case "Routines":
            //load trainer routines in here
            break;
    }
}

function getClients(panel, elmnt) {
    var clientsList = []
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", '/getClientList', false); // true is asynchronous
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            console.log(xhttp.responseText);
            let object = JSON.parse(xhttp.responseText);
            console.log(object)
            if (object) {
                for (count = 0; count < object.length; count++) {
                    let clientObject = object[count];

                    var clientTag = document.createElement("div");
                    clientTag.setAttribute("class", "client_tag")
                    clientTag.onclick = function () {
                        openPage("ClientInfo", elmnt);
                    }

                    var clientPic = document.createElement("img");
                    // clientPic.setAttribute("src", clientObject["picUrl"])
                    clientPic.setAttribute("src", clientObject["picUrl"])
                    clientPic.setAttribute("class", "profile_img")

                    var clientName = document.createElement("p");
                    clientName.innerHTML = clientObject["firstName"] + " " + clientObject["lastName"]

                    clientTag.appendChild(clientPic);
                    clientTag.appendChild(clientName);
                    panel.appendChild(clientTag)
                }
            }
        } else {
            console.error(xhttp.statusText);
        }
    };
    xhttp.send();
    return clientsList;
}



function submitCommentSuccess() {
    alert("Comment successful!")

}