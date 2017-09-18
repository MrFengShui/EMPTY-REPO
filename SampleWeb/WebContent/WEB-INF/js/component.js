var items = document.querySelector('.menu-items');

function show_submenu(event) {
	var button = (event.target.nodeName == 'I') ? event.target.parentNode.parentNode : event.target.parentNode;
	var pos = button.getBoundingClientRect();
	console.log(button, pos);
	if (items) {
		var x = pos.x;
		var y = pos.y + 40;
		items.style.display = 'inline-block';
		items.style.top = y + 'px';
		items.style.left = x + 'px';
	}
}

function hide_submenu() {
	if (items) {
		items.style.display = 'none';
	}
}