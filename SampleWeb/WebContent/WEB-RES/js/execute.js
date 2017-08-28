window.addEventListener('DOMContentLoaded', function(event) {
	var buttons = document.getElementsByClassName("index-item-button");
	
	if (buttons) {
		for (var i = 0; i < buttons.length; i ++) {
			buttons[i].addEventListener('click', show_hide_list);
		}
	}
	
	var links = document.querySelectorAll('.tab-title a');
	
	if (links) {
		for (var i = 0; i < links.length; i ++) {
			links[i].addEventListener('click', switch_tab_pane);
		}
	}
	
	var editButtons = document.getElementsByClassName('about-edit');
	
	if (editButtons) {
		for (var i = 0; i < editButtons.length; i ++) {
			editButtons[i].addEventListener('click', show_modal_dialog);
		}
	}
	
	var modalCloses = document.getElementsByClassName('modal-close-button');
	
	if (modalCloses) {
		for (var i = 0; i < modalCloses.length; i ++) {
			modalCloses[i].addEventListener('click', hide_modal_dialog);
		}
	}
});