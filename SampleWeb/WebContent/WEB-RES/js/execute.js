window.addEventListener('DOMContentLoaded', function(event) {
	var buttons = document.getElementsByClassName("main_item_button");
	
	if (buttons) {
		for (var i = 0; i < buttons.length; i ++) {
			buttons[i].addEventListener('click', show_hide_list);
		}
	}
});