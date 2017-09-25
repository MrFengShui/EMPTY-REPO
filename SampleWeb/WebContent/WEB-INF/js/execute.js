window.addEventListener('DOMContentLoaded', function(event) {
	var body = document.querySelector('body');
	
	if (body) {
		body.addEventListener('click', hide_menu);
	}
	
	var nodes = document.getElementsByClassName("tree-node");
	
	if (nodes) {
		for (var i = 0; i < nodes.length; i ++) {
			nodes[i].addEventListener('dblclick', show_hide_list);
		}
	}
	
	var buttons = document.querySelectorAll('.tree-node i');
	
	if (buttons) {
		for (var i = 0; i < buttons.length; i ++) {
			buttons[i].addEventListener('click', show_hide_list);
		}
	}
	
	var titles = document.querySelectorAll('.menu-title');
	
	if (titles) {
		for (var i = 0; i < titles.length; i ++) {
			titles[i].addEventListener('mouseover', show_menu);
		}
	}
	
	var slideImages = document.querySelectorAll('.image-item img');
	
	if (slideImages) {
		for (var i = 0; i < slideImages.length; i ++) {
			slideImages[i].addEventListener('mouseover', switch_image_slide);
		}
	}
	
	var collapseButtons = document.querySelectorAll('.title-panel button');
	
	if (collapseButtons) {
		for (var i = 0; i < collapseButtons.length; i ++) {
			collapseButtons[i].addEventListener('click', switch_title_panel);
		}
	}
	
	var tabbedTitles = document.querySelectorAll('.tabbed-panel-item span');
	
	if (tabbedTitles) {
		for (var i = 0; i < tabbedTitles.length; i ++) {
			tabbedTitles[i].addEventListener('click', switch_tabbed_content);
		}
	}
	
	var tabbedButtons = document.querySelectorAll('.tabbed-panel-item button');
	
	if (tabbedButtons) {
		for (var i = 0; i < tabbedButtons.length; i ++) {
			tabbedButtons[i].addEventListener('click', close_tabbed_panel);
		}
	}
	
	var slideButton = document.querySelector('.slide-bar button');
	
	if (slideButton) {
		slideButton.addEventListener('mousedown', move_slide);
		slideButton.addEventListener('mousemove', move_slide);
		slideButton.addEventListener('mouseup', move_slide);
	}
});