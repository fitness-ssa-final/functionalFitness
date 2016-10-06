function connectToAPI() {
    $.get("https://wger.de/api/v2/exercise.json/?language=2&limit=999&equipment=1",
        parseAPIResponse(data));
}

function parseAPIResponse(data) {
    for (var i = 0; i < data.results.length; i++) {
        // data[i];

        var name = data.results[i].name;
        var description = data.results[i].description;
        var muscleCategory = data.results[i].category;
        var equipment = data.results[i].equipment;
        var index = equipment.indexOf(1);

        if (index !== -1) {
            equipment[index] = "Barbell";

        }

        $('body').append(
            "Name:   " + name + '<hr>' + "Directions:   " +
            description + '<hr>' + "Muscle Category:   " +
            muscleCategory + '<hr>' + "Equipment Needed:    " +
            equipment + '<hr><br><br>');
    }
    //				if (muscleCategory.equals) {
    //
    //				} else {
    //
}
