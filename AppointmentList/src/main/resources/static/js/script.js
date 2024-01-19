console.log('script.js loaded')

window.addEventListener('load', function(e) {
	console.log('Page loaded, DOM complete');
	init();
});

function init() {

	loadAppointmentList();

}

function loadAppointmentList() {

	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/appointments');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let appointmentList = JSON.parse(xhr.responseText);
				console.log(appointmentList);
				displayAppointmentList(appointmentList);
			}
		}
	}

	xhr.send();
}

function displayAppointmentList(appointmentList) {
	let tbody = document.getElementById('appoListTableBody');
	for (let appo of appointmentList) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		let td = document.createElement('td');
		td.textContent = appo.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = appo.patientName;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = appo.doctorName;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = appo.diagnose;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = appo.prescription;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = formatDateTime(appo.arrivalTime);
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = formatDateTime(appo.departureTime);
		tr.appendChild(td);
	}


}

function getAppointment(appointmentId) {
	// TODO:
	// * Use XMLHttpRequest to perform a GET request to "api/films/"
	//   with the filmId appended.
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/appointments/' + appointmentId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				//   and pass the film object to displayFilm().
				let film = JSON.parse(xhr.responseText);
				displayFilm(film);
				displayActors(filmId);
			} else {
				displayError('Film not found');
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.
			}
		}
	}
	xhr.send();
}

function formatDateTime(dateTimeString) {
	var options = { year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric', hour12: false,timeZoneName: 'short' };
	return new Date(dateTimeString).toLocaleDateString(undefined, options);
}




