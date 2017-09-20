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
		
		for (var i = 0; i < nodes.length; i ++) {
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