function menu_bar_build(menu, array) {
	var ul = document.createElement('ul');
	ul.setAttribute('class', 'menu-bar medium-border-positive');
	menu.appendChild(ul);
	
	for (var i = 0; i < array.length; i ++) {
		var li = document.createElement('li');
		li.setAttribute('class', 'menu-title');
		ul.appendChild(li);
		
		var button = document.createElement('button');
		button.setAttribute('class', 'menu-title-button medium-text-font');
		button.setAttribute('id', array[i]['id']);
		li.appendChild(button);
		
		var text = document.createTextNode(array[i]['text']);
		button.appendChild(text);
		
		if (i < array.length - 1) {
			var split = document.createElement('li');
			split.setAttribute('class', 'separator-vertical');
			ul.append(split);
		}
	}
}

function menu_list_build(menu, json) {
	if (json['type'] == 'menu' || json['type'] == 'list') {
		var ul = document.createElement('ul');
		ul.setAttribute('class', 'menu-list positive-shadow');
		ul.setAttribute('id', json['id'] + '-list');
		menu.appendChild(ul);
		
		for (var j = 0; j < json['list'].length; j ++) {
			var item = json['list'][j];
			
			var li = document.createElement('li');
			li.setAttribute('class', 'menu-item');
			ul.appendChild(li);
			
			if (item['type'] == 'list') {
				var span = document.createElement('span');
				span.setAttribute('class', 'menu-item-span medium-text-font div-left-center');
				span.innerHTML = (item['icon'] == '') ? '&nbsp;&nbsp;&nbsp;&nbsp;' : item['icon'] + '&nbsp;';
				li.appendChild(span);
				
				var text = document.createTextNode(item['text']);
				span.appendChild(text);
				
				var button = document.createElement('button');
				button.setAttribute('class', 'menu-item-button medium-text-font div-left-center');
				button.setAttribute('id', item['id']);
				li.appendChild(button);
				
				var i = document.createElement('i');
				i.setAttribute('class', 'fa fa-angle-double-right');
				i.setAttribute('aria-hidden', true);
				button.appendChild(i);
			} else {
				var a = document.createElement('a');
				a.setAttribute('class', 'menu-item-link medium-text-font div-left-center');
				a.innerHTML = (item['icon'] == '') ? '&nbsp;&nbsp;&nbsp;&nbsp;' : item['icon'] + '&nbsp;';
				li.appendChild(a);
				
				var text = document.createTextNode(item['text']);
				a.appendChild(text);
			}
			
			menu_list_build(menu, item);
		}
	}
}

function menu_build(json) {
	var menu = document.querySelector('.navigate-menu');
	menu_bar_build(menu, json);
	json.forEach(function(item) {
		menu_list_build(menu, item);
	});
}

function show_menu(event) {
	var node = (event.target.nodeName == 'I') ? event.target.parentNode
			: event.target;
	var item = document.getElementById(node.id + '-list');
	var pos = node.getBoundingClientRect();
	
	if (node.className.includes('menu-title')) {
		item.style.top = (pos.top + pos.height + 4) + 'px';
		item.style.left = pos.left + 'px';
		hide_menu();
	} else {
		var nodes = node.parentNode.parentNode.children;
		
		for (var i = 0; i < nodes.length; i++) {
			var child = nodes[i].children[1];
			var temp = document.getElementById(child.id + '-list');
			temp.style.display = 'none';
		}
		
		if (item != null) {
			item.style.top = pos.top + 'px';
			item.style.left = (pos.left + pos.width) + 'px';
		}
	}
	
	if (item != null) {
		item.style.display = 'block';
		item.style.zIndex = '' + (item.zIndex + 10);
		item.addEventListener('mouseover', show_menu);
	}
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
/**/
function show_hide_tree_node(event) {
	var button = (event.target.nodeName == 'I') ? event.target.parentNode : event.target;
	var root = button.parentNode.parentNode;
	var child = root.children[1];
	
	if (child.style.display == 'none' || child.style.display == '') {
		child.style.display = 'flex';
		button.children[0].className = 'fa fa-minus-square-o'
	} else {
		child.style.display = 'none';
		button.children[0].className = 'fa fa-plus-square-o'
	}
}
/**/
function move_slide(event) {
	if (event.type == 'mousedown') {
		parent = event.target.type == 'DIV' ? event.target : event.target.parentNode;
		left = parent.children[0];
		button = parent.children[1];
		right = parent.children[2];
		parentPosition = parent.getBoundingClientRect();
		buttonPosition = button.getBoundingClientRect();
		leftPosition = left.getBoundingClientRect();
		rightPosition = right.getBoundingClientRect();
		startX = event.clientX;
	} else if (event.type == 'mouseup') {
		parent = null;
		left = null;
		button = null;
		right = null;
		parentPosition = null;
		buttonPosition = null;
		leftPosition = null;
		rightPosition = null;
	} else {
		var endX = event.clientX;
		var leftPercent = (leftPosition.width + (endX - startX)) * 100 / (parentPosition.width - buttonPosition.width);
		var rightPercent = (rightPosition.width - (endX - startX)) * 100 / (parentPosition.width - buttonPosition.width);
		
		if (leftPercent >= 0 && leftPercent <= 100) {
			left.style.width = leftPercent + '%';
			right.style.width = rightPercent + '%';
		}
	}
}

function tree_node_build(json, contain, space, size) {
	var text = json['text'];
	var type = json['type'];
	
	if (type == 'node') {
		var item = document.createElement('div');
		item.setAttribute('class', 'tree-item');
		item.setAttribute('style', 'width: calc(100% + ' + size + 'px);');
		contain.appendChild(item);
		
		var head = document.createElement('div');
		head.setAttribute('class', 'tree-item-head');
		item.appendChild(head);
		
		var indent = document.createTextNode(space);
		head.innerHTML = space;
		
		var button = document.createElement('button');
		button.setAttribute('class', 'medium-text-font div-center-center');
		head.appendChild(button);
		
		var i = document.createElement('i');
		i.setAttribute('class', 'fa fa-plus-square-o');
		i.setAttribute('aria-hidden', true);
		button.appendChild(i);
		
		var header = document.createElement('header');
		header.setAttribute('class', 'medium-text-font div-left-center');
		head.appendChild(header);
		
		var title = document.createTextNode(text);
		header.appendChild(title);
		
		var body = document.createElement('div');
		body.setAttribute('class', 'tree-item-body');
		item.appendChild(body);
		
		space += '&nbsp;&nbsp;&nbsp;';
		var child = json['child'];
		child.forEach(function(item) {
			tree_node_build(item, body, space, size);
		});		
	} else {
		var a = document.createElement('a');
		a.setAttribute('href', '#');
		a.setAttribute('class', 'tree-leaf medium-text-font');
		a.innerHTML = space;
		contain.appendChild(a);
		
		var i = document.createElement('i');
		i.setAttribute('class', 'fa fa-flag');
		i.setAttribute('aria-hidden', true);
		a.appendChild(i);
		
		var title = document.createTextNode(' ' + text);
		a.appendChild(title);
		a.href = json['link'];
	}
}

function tree_build(json, size) {
	var tree = document.querySelector('.tree');
	json.forEach(function(item) {
		tree_node_build(item, tree, '', size);
	});
}

window.addEventListener('DOMContentLoaded', function(event) {
	var nodes = document.querySelectorAll(".tree-item-head header");
	
	if (nodes) {
		for (var i = 0; i < nodes.length; i ++) {
			nodes[i].addEventListener('dblclick', show_hide_tree_node);
		}
	}
	
	var buttons = document.querySelectorAll('.tree-item-head button');
	
	if (buttons) {
		for (var i = 0; i < buttons.length; i ++) {
			buttons[i].addEventListener('click', show_hide_tree_node);
		}
	}
	
	var titles = document.querySelectorAll('.menu-title');
	
	if (titles) {
		for (var i = 0; i < titles.length; i ++) {
			titles[i].addEventListener('mouseover', show_menu);
		}
	}
});
	