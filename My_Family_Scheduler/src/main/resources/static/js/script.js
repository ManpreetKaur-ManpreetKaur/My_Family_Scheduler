function getEvent(id) {
    if (document.getElementById("event" + id).innerHTML == "") {
        document.getElementById("event" + id).innerHTML = "hello!";

        fetch('http://localhost:8080/getEvent/' + id) // Update the endpoint as per your server setup
            .then(response => response.json()) // JSONify the data returned
            .then(function (event) {
                // modify textToDisplay below here!

                var textToDisplay = ""; // create and append to a blank var
                //textToDisplay += "ID: " + event.id + "<br>";
                textToDisplay += "Title: " + event.title + "<br>";
                textToDisplay += "Date: " + event.date + "<br>";
                textToDisplay += "Time: " + event.time + "<br>";
                textToDisplay += "Brief Message: " + event.briefMessage + "<br>";
                textToDisplay += "Additional Info: " + event.additionalInfo + "<br>";
                textToDisplay += "Enable Notification: " + event.enableNotification + "<br>";
                textToDisplay += "Notification Time: " + event.notificationTime + "<br>";

                // finally, change our relevant div to display the var
                document.getElementById("event" + id).innerHTML = textToDisplay;
            });

    } else {
        document.getElementById("event" + id).innerHTML = "";
    }
}
