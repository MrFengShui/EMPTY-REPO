function show_hide_list(event) {
	var button = (event.target.nodeName == 'I') ? event.target.parentNode : event.target;
	var root = button.parentNode;
	var child = root.children[1];
	
	if (child.style.display == 'none' || child.style.display == '') {
		child.style.display = 'block';
		button.children[0].className = 'fa fa-minus-square-o'
	} else {
		child.style.display = 'none';
		button.children[0].className = 'fa fa-plus-square-o'
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
	var components = document.getElementsByClassName("date-time-text");
	
	for (var i = 0; i < components.length; i++) {
		components[i].innerHTML = year + "-" + bitFormat(month) + "-" + bitFormat(day) + "\t" + weekFormat(week) + "\t" + bitFormat(hour) + ":" + bitFormat(minute) + ":" + bitFormat(second);
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