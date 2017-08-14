/**
 * http://usejsdoc.org/
 */
function match_size() {
	var main_div = document.getElementById('main_div');
	console.log("hello");
	if (main_div) {
		main_div.style.width = 'calc(1000px - 250px)';
	}
}

function show_date_time() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var week = date.getDay();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var components = document.getElementsByClassName("top_dt_div");
	console.log("hello");
	for (var i = 0; i < components.length; i++) {
		components[i].innerHTML = "Current Date&Time: " + year + "-" + bitFormat(month) + "-" + bitFormat(day) + "\t" + weekFormat(week) + "\t" + bitFormat(hour) + ":" + bitFormat(minute) + ":" + bitFormat(second);
	}

	setTimeout(show_date_time, 1000);
}

function bitFormat(num) {
	return (num < 10) ? "0" + num : num;
}

function weekFormat(num) {
	switch(num) {
		case 0:
			return "Sun";
		case 1:
			return "Mon";
		case 2:
			return "Tue";
		case 3:
			return "Wed";
		case 4:
			return "Thu";
		case 5:
			return "Fri";
		case 6:
			return "Sat";
	}
}