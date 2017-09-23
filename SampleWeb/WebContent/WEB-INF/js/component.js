function show_menu(event) {
	var node = (event.target.nodeName == 'I') ? event.target.parentNode
			: event.target;
	var item = document.getElementById(node.id + '-list');
	var pos = node.getBoundingClientRect();

	if (node.className.includes('menu-title')) {
		item.style.top = (pos.top + pos.height) + 'px';
		item.style.left = pos.left + 'px';
		hide_menu();
	} else {
		var nodes = node.parentNode.children;

		for (var i = 0; i < nodes.length; i++) {
			var temp = document.getElementById(nodes[i].id + '-list');
			temp.style.display = 'none';
		}

		item.style.top = pos.top + 'px';
		item.style.left = (pos.left + pos.width) + 'px';
	}

	item.style.display = 'inline-block';
	item.style.zIndex = '' + (item.zIndex + 10);
	item.addEventListener('mouseover', show_menu);
}

function hide_menu() {
	var items = document.getElementsByClassName('menu-list');

	if (items) {
		for (var i = 0; i < items.length; i++) {
			items[i].style.display = 'none';
		}
	}
}

var images = document.getElementsByClassName('image-item');
var image = document.querySelector('.image-content img');
var thread;

function switch_image_slide(event) {
	if (image) {
		clearTimeout(thread);
		image.src = event.target.src;

		if (images) {
			for (var i = 0; i < images.length; i++) {
				images[i].style.backgroundColor = 'rgb(234, 234, 234)';
			}
		}

		var parent = event.target.parentNode;
		parent.style.backgroundColor = 'rgb(32, 32, 32)';
		event.target.onmouseout = function() {
			for (var i = 0; i < images.length; i++) {
				if (parent === images[i]) {
					switch_image_auto(i);
					break;
				}
			}
		}
	}
}

function switch_image_auto(index) {
	if (images[index]) {
		if (images) {
			for (var i = 0; i < images.length; i++) {
				images[i].style.backgroundColor = 'rgb(234, 234, 234)';
			}
		}

		image.src = images[index].children[0].src;
		images[index].style.backgroundColor = 'rgb(32, 32, 32)';

		if (index == images.length - 1) {
			index = 0;
		} else {
			index++;
		}

		thread = setTimeout(switch_image_auto, 2500, index);
	}
}

var panels = document.getElementsByClassName('title-panel');

function switch_title_panel(event) {
	var button = (event.target.nodeName == 'I') ? event.target.parentNode
			: event.target;
	var panel = button.parentNode.parentNode;

	if (panel) {
		for (var i = 0; i < panels.length; i++) {
			panels[i].id = null;
			panels[i].style.height = 'auto';
			panels[i].children[1].style.display = 'none';
		}

		panel.id = 'title-panel-collapsed';
		collapse_title_panel();
	}
}

function collapse_title_panel() {
	if (panels) {
		for (var i = 0; i < panels.length; i++) {
			if (panels[i].id == 'title-panel-collapsed') {
				panels[i].style.height = 'calc(100% - '
						+ ((panels.length - 1) * 32) + 'px)';
				panels[i].children[1].style.display = 'block';
				break;
			}
		}
	}
}

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