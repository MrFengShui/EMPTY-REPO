function border_panel_match_size() {
	var bodies = document.getElementsByClassName('border-panel-body');

	if (bodies) {
		var tops = document.getElementsByClassName('border-panel-top');
		var bottoms = document.getElementsByClassName('border-panel-bottom');

		if (tops && bottoms) {
			for (var i = 0; i < bodies.length; i++) {
				var topDimension = tops[i].getBoundingClientRect();
				var bottomDimension = bottoms[i].getBoundingClientRect();
				var sum = topDimension.height + bottomDimension.height;
				bodies[i].style.height = 'calc(100% - ' + sum + 'px)';
			}
		}
	}
}

function split_panel_horizontal_move(event) {
	if (event.type == 'mousedown') {		
		parent = (event.target.className == 'split-panel-horizontal') ? event.target : event.target.parentNode;
		left = parent.children[0];
		separator = parent.children[1];
		right = parent.children[2];
		parentPosition = parent.getBoundingClientRect();
		separatorPosition = separator.getBoundingClientRect();
		leftPosition = left.getBoundingClientRect();
		rightPosition = right.getBoundingClientRect();
		startX = event.clientX;
	} else if (event.type == 'mouseup') {
		parent = null;
		left = null;
		separator = null;
		right = null;
		parentPosition = null;
		separatorPosition = null;
		leftPosition = null;
		rightPosition = null;
	} else {
		if (typeof leftPosition !== 'undefined'
				&& typeof rightPosition !== 'undefined') {
			if (leftPosition !== null && rightPosition !== null) {
				var endX = event.clientX;
				var leftPercent = (leftPosition.width + (endX - startX)) * 100
						/ (parentPosition.width - separatorPosition.width);
				var rightPercent = (rightPosition.width - (endX - startX)) * 100
						/ (parentPosition.width - separatorPosition.width);

				if (leftPercent >= 0 && leftPercent <= 100) {
					left.style.width = leftPercent + '%';
					right.style.width = rightPercent + '%';
				}
			}
		}
	}
}

function split_panel_vertical_move(event) {
	if (event.type == 'mousedown') {		
		parent = (event.target.className == 'split-panel-vertical') ? event.target : event.target.parentNode;
		left = parent.children[0];
		separator = parent.children[1];
		right = parent.children[2];
		parentPosition = parent.getBoundingClientRect();
		separatorPosition = separator.getBoundingClientRect();
		leftPosition = left.getBoundingClientRect();
		rightPosition = right.getBoundingClientRect();
		startY = event.clientY;
	} else if (event.type == 'mouseup') {
		parent = null;
		left = null;
		separator = null;
		right = null;
		parentPosition = null;
		separatorPosition = null;
		leftPosition = null;
		rightPosition = null;
	} else {
		if (typeof leftPosition !== 'undefined'
				&& typeof rightPosition !== 'undefined') {
			if (leftPosition !== null && rightPosition !== null) {
				var endY = event.clientY;
				var leftPercent = (leftPosition.height + (endY - startY)) * 100
						/ (parentPosition.height - separatorPosition.height);
				var rightPercent = (rightPosition.height - (endY - startY)) * 100
						/ (parentPosition.height - separatorPosition.height);

				if (leftPercent >= 0 && leftPercent <= 100) {
					left.style.height = leftPercent + '%';
					right.style.height = rightPercent + '%';
				}
			}
		}
	}
}

function show_tabbed_panel() {
	var items = document.getElementsByClassName('tabbed-panel-item');
	
	for (var i = 0; i < items.length; i ++) {
		if (items[i].id.includes('-selected')) {
			select_tabbed_panel(items[i]);
			break;
		}
	}
}

function select_tabbed_panel(node) {
	var span = node.children[0];
	var index = node.id.lastIndexOf('-selected');
	var content = document.getElementById(node.id.substr(0, index) + '-content');
	node.style.boxShadow = '0 0 15px rgba(234, 234, 234, 0.25), 0 0 15px rgba(234, 234, 234, 0.25)';
	span.style.color = 'rgb(234, 234, 234)';
	content.style.display = 'block';
	
	if (node.children.length > 1) {
		var button = node.children[1];
		button.style.backgroundColor = 'rgb(32, 32, 32)';
		button.style.color = 'rgb(234, 234, 234)';
	}
}

function switch_tabbed_content(event) {
	var items = document.getElementsByClassName('tabbed-panel-item');
	var contents = document.getElementsByClassName('tabbed-panel-content');
	
	if (contents) {
		for (var i = 0; i < contents.length; i ++) {
			contents[i].style.display = 'none';
		}
	}
	
	if (items) {
		for (var i = 0; i < items.length; i ++) {
			items[i].id = 'tabbed-' + (i + 1);
			items[i].style.boxShadow = 'none';
			items[i].children[0].style.color = 'rgb(234, 234, 234)';
			
			if (items[i].children.length > 1) {
				items[i].children[1].style.color = 'rgb(234, 234, 234)';
			}
		}
	}
	
	var node = event.target.parentNode;
	node.id += '-selected';
	select_tabbed_panel(node);
}

function close_tabbed_panel(event) {
	var title = document.querySelector('.tabbed-panel-items');
	var content = document.querySelector('.tabbed-panel-body');
	var button = (event.target.nodeName == 'I') ? event.target.parentNode : event.target;
	var node = button.parentNode;
	
	if (content) {
		title.removeChild(node);
		content.removeChild(document.getElementById(node.id + '-content'));
	}
}

window.addEventListener('DOMContentLoaded', function(event) {
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
	
	var horizontalSplits = document.querySelectorAll('.split-panel-horizontal');

	if (horizontalSplits) {
		for (var i = 0; i < horizontalSplits.length; i++) {
			horizontalSplits[i].addEventListener('mousedown',
					split_panel_horizontal_move);
			horizontalSplits[i].addEventListener('mousemove',
					split_panel_horizontal_move);
			horizontalSplits[i].addEventListener('mouseup',
					split_panel_horizontal_move);
		}
	}
	
	var verticalSplits = document.querySelectorAll('.split-panel-vertical');

	if (verticalSplits) {
		for (var i = 0; i < verticalSplits.length; i++) {
			verticalSplits[i].addEventListener('mousedown',
					split_panel_vertical_move);
			verticalSplits[i].addEventListener('mousemove',
					split_panel_vertical_move);
			verticalSplits[i].addEventListener('mouseup',
					split_panel_vertical_move);
		}
	}
});