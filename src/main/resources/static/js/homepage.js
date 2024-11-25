document.getElementById("task-date").addEventListener("input", updateReminderOptions);
document.addEventListener("DOMContentLoaded", function () {
    const dateTimeInput = document.getElementById("task-date");
    const now = new Date();


    dateTimeInput.min = now.toISOString().slice(0, 16);
});




const allOptions = [
    { label: "one week before", value: "1W" },
    { label: "2 days before", value: "2D" },
    { label: "one day before", value: "1D" },
    { label: "2 hrs before", value: "2H" },
    { label: "1 hr before", value: "1H" },
    { label: "30 min before", value: "30M" },
    { label: "15 min before", value: "15M" }
];

// Function to update dropdown based on selected date and time
function updateReminderOptions() {
    const dateInput = document.getElementById("task-date").value;
    const reminderDropdown = document.getElementById("reminder-options");

    if (!dateInput) return; // Exit if no date is selected

    const selectedDate = new Date(dateInput);
    const currentDate = new Date();
    const timeDiff = selectedDate - currentDate; // Time difference in milliseconds

    // Clear existing options in the dropdown
    reminderDropdown.innerHTML = "";

    // Determine options to show based on time difference
    let optionsToShow;
     if (timeDiff > 7 * 24 * 60 * 60 * 1000) { // More than 1 week
        optionsToShow = allOptions; // display all options
    } else if (timeDiff > 48 * 60 * 60 * 1000) { // More than 2 day
        optionsToShow = allOptions.slice(1); // Display from "2 days before"
    }else if (timeDiff > 24 * 60 * 60 * 1000) { // More than 2 day
         optionsToShow = allOptions.slice(2); // Display from "1 days before"
     }
     else if (timeDiff > 2 * 60 * 60 * 1000) { // More than 2 hours
        optionsToShow = allOptions.slice(3); // Display from "2 hrs before"
    } else if (timeDiff > 60 * 60 * 1000) { // More than 1 hour
        optionsToShow = allOptions.slice(4); // Display from "1 hr before"
    }else if (timeDiff > 30 * 60 * 1000) { // More than 30min
         optionsToShow = allOptions.slice(5); // Display from "30 min before"
     }
     else {
        optionsToShow = allOptions.slice(6); // Display only "30 min before" and "15 min before"
    }

    // Populate dropdown with the determined options
    optionsToShow.forEach(option => {
        const optionElement = document.createElement("option");
        optionElement.value = option.value;
        optionElement.textContent = option.label;
        reminderDropdown.appendChild(optionElement);
    });
}


function sortList() {
    const ul = document.getElementById("remindersList");
    const items = Array.from(ul.querySelectorAll(".reminder-item"));
    const sortCriteria = document.getElementById("sortCriteria").value; // Get the selected sort criterion

    // Debug: Log selected criterion
    console.log("Selected Sort Criterion:", sortCriteria);

    items.sort((a, b) => {
        let valueA, valueB;

        // Get the main text content for each item
        const textA = a.querySelector("span").innerText;
        const textB = b.querySelector("span").innerText;

        // Split the text based on " - " to get category, task, and due date
        const partsA = textA.split(" - ");
        const partsB = textB.split(" - ");

        if (sortCriteria === "category") {
            valueA = partsA[0]; // Category name
            valueB = partsB[0];
            console.log("Sorting by Category:", valueA, valueB);
        } else if (sortCriteria === "task") {
            valueA = partsA[1]; // Task name
            valueB = partsB[1];
            console.log("Sorting by Task Name:", valueA, valueB);
        } else if (sortCriteria === "duedate") {
            valueA = new Date(textA.match(/Due: (.+)$/)[1]); // Due date
            valueB = new Date(textB.match(/Due: (.+)$/)[1]);
            console.log("Sorting by Due Date:", valueA, valueB);
        }

        // Compare values for sorting
        if (sortCriteria === "duedate") {
            return valueA - valueB; // Numeric comparison for dates
        } else {
            return valueA.localeCompare(valueB); // Alphabetical comparison for text
        }
    });

    // Clear and re-append sorted items to the ul
    items.forEach(item => ul.appendChild(item));
}


let originalReminders = document.getElementsByClassName('task-list');
let remindersParent = document.getElementById('remindersList');


let allReminderElements = Array.from(originalReminders);

function filterList() {
    let textEntered = document.getElementById('searchBox').value.toString().toUpperCase();


    let currentReminders = Array.from(remindersParent.getElementsByClassName('task-list'));


    currentReminders.forEach(element => {
        let reminderText = element.innerText.toUpperCase();


        if (!reminderText.includes(textEntered)) {
            element.remove();
        }
    });


    if (textEntered.trim() === "") {
        allReminderElements.forEach(element => {
            // Re-append elements that were removed
            remindersParent.appendChild(element);
        });
    }
}
