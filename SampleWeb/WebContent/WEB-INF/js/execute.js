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
});