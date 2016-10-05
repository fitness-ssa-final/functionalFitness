$.get('https://wger.de/api/v2/exercise.json/?language=2&limit=999&equipment=1',
		function(data) {
			for (var i = 0; i < data.results.length; i++) {
				data[i];

				var name = data.results[i].name;
				console.log('Name : ', name);

				var description = data.results[i].description;
				console.log('Description : ', description);

				var muscleCategory = data.results[i].category;
				console.log('Muscle Category : ', muscleCategory);

				var equipment = data.results[i].equipment;
				console.log('Equipment : ', equipment);
				
//				if (muscleCategory.equals) {
//					
//				} else {
//
//				}

				var index = equipment.indexOf(1);
				if (index !== -1) {
					equipment[index] = "Barbell"

				}

				$('body').append(
						"Name:   " + name + '<hr>' + "Directions:   "
								+ description + '<hr>' + "Muscle Category:   "
								+ muscleCategory + '<hr>'
								+ "Equipment Needed:    " + equipment
								+ '<hr><br><br>');

			}

		});
