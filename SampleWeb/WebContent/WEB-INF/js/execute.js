window.addEventListener('DOMContentLoaded', function(event) {
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
			titles[i].addEventListener('mouseover', show_submenu);
			titles[i].addEventListener('mouseout', hide_submenu);
		}
	}
	
	var items = document.querySelectorAll('.menu-items');
	
	if (items) {
		for (var i = 0; i < items.length; i ++) {
			items[i].addEventListener('mouseover', show_submenu);
			items[i].addEventListener('mouseout', hide_submenu);
		}
	}
});