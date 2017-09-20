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
});