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
        case "Program":
            let programTabPanel = document.getElementById(tabName);
            programTabPanel.innerHTML = "";
            getClientProgram(programTabPanel, elmnt);
            break;

        case "DoExercise":
            //display clients progress here
            break;

        case "Progress":
            //display clients progress here
            break;

        case "Comment":
            //display clients progress here
            break;
        case "Routines":
            //load routines info tab content
        case "Profile":
            //load comment info tab content;
            break;
    }
}

function getClientProgram(panel, elmnt) {
    let workout_container = document.createElement("div");
    workout_container.setAttribute("class", "workout_container");

    let workout_day_txt = document.createElement("div");
    workout_day_txt.setAttribute("class", "workout_day_txt");
    workout_day_txt.innerHTML = "Monday"

    let exercise_tag_container = document.createElement("div");
    exercise_tag_container.setAttribute("class","exercise_tag_container")

    for(let count = 1; count <= 3; count++){
        let exercise_tag = document.createElement("div");
        exercise_tag.setAttribute("class", "exercise_tag");
        let exercise_tag_lbl = document.createElement("div");
        exercise_tag_lbl.innerHTML = "Exercise " + count;
        exercise_tag.onclick = function () {
            openPage("DoExercise",  elmnt);
        }

        exercise_tag.appendChild(exercise_tag_lbl)
        exercise_tag_container.appendChild(exercise_tag)
    }

    workout_container.appendChild(workout_day_txt)
    workout_container.appendChild(exercise_tag_container)

    panel.appendChild(workout_container)
}