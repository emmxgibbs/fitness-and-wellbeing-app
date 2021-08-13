let newRoutineVideos = [];

document.onload = new function () {
    try {
        //get access token stored as cookie
        const accessToken = document.cookie
            .split('; ')
            .find(row => row.startsWith('currentUserToken'))
            .split('=')[1];

        getUserVideos(accessToken);
        getUserRoutines(accessToken);
    } catch (e) {
        console.log("could not load access token from cookie: " + e)
        window.location.href = "/login"
    }
}

function getUserVideos(accessToken) {
    //set up new http request and add headers
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", '/getVideosForUser', true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Authorization", "Bearer " + accessToken);

    //handles the result of the request
    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            const videos = JSON.parse(xhttp.responseText);
            console.log(videos);
            addVideosToRoutineForm(videos);
        } else {
            console.error(xhttp.statusText);
        }
    };
    //send the request
    xhttp.send();
}

function getUserRoutines(accessToken) {
    //set up new http request and add headers
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", '/routines', true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Authorization", "Bearer " + accessToken);

    //handles the result of the request
    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            const routines = JSON.parse(xhttp.responseText);
            console.log(routines);
            const blob = document.createElement("div")
            blob.setAttribute("class", "workout-name")
            const videoName = document.createElement("h4")
            // videoName.innerHTML = routines[]
        } else {
            if (xhttp.status === 403) {
                window.location.href = "/login";
            }
            console.error(xhttp.statusText);
        }
    };
    //send the request
    xhttp.send();
}

function addVideosToRoutineForm(videoList) {
    //for each video in video list, add an html element to the form
    videoList.map((video) => {
        const videoNode =
            `<div class="video-list-item">
                <div class="thumbnail-column">
                
                </div>
                
                <div class="details-column">
                    <div id='${video.id}'>
                      <!--        need to input routine name here and allocate number of reps and sets           -->
                                              <div><h4>Routine Information</h4></div>
                                              <label for="routine-name" class="routine-name-label">Routine Name: </label>
                                              <input type="text" name="routine-name" id="routine-name" class="routine-name-input" required>
                                              <div> <h4 class="video-title">${video.title}</h4>
                                                  <div> <p class="video-description">${video.description}</p>
                                                  <input type="checkbox" id="${video.id}" onchange="addVideoToList(this)" class="checkbox">
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
            </div>`
        document.getElementById("video-list").innerHTML += videoNode;
    });
}

function addVideoToList(checkboxElem) {
    const videoId = parseInt(checkboxElem.id);

    if (checkboxElem.checked) {
        newRoutineVideos.push(videoId);
    } else {
        newRoutineVideos = newRoutineVideos.filter((it) => it !== videoId);
    }
    console.log(newRoutineVideos);
}

//function to close modal
const closeModal = () => {
    //get modal
    const modal = document.getElementById("create-modal");
    modal.style.display = "none";
    newRoutineVideos = [];
    clearCheckbox();
}

//function to display the modal on page
const openModal = () => {
    //get modal
    const modal = document.getElementById("create-modal");
    modal.style.display = "block";
    newRoutineVideos = [];
    clearCheckbox();
}

function clearCheckbox() {
    const formCheckboxes = document.getElementsByClassName("checkbox");

    for (let i = 0; i < formCheckboxes.length; i++) {
        formCheckboxes[i].checked = false;
    }
}

function sendRoutineToServer() {
    const accessToken = document.cookie
        .split('; ')
        .find(row => row.startsWith('currentUserToken'))
        .split('=')[1];

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", '/routine', true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Authorization", "Bearer " + accessToken);

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            alert("Routine created successfully!");
            closeModal();
        } else {
            console.error(xhttp.statusText);
        }
    };

    const routineData = {
        videoIdList: newRoutineVideos,
        name: document.getElementById("routine-name").value
    }

    //send the request
    xhttp.send(JSON.stringify(routineData));
}

