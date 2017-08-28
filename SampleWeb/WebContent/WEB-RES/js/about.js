function switch_tab_pane(event) {
	var id = event.target.id;
	var tables = document.querySelectorAll('.tab-content table');
	
	if (tables) {
		for (var i = 0; i < tables.length; i ++) {
			tables[i].style.display = 'none';
		}
	}
	
	var table = document.getElementById('about-table-' + id);
	table.removeAttribute('style');
}

function show_modal_dialog() {
	var backbones = document.getElementsByClassName('modal-dialog-backbone');
	
	if (backbones) {
		for (var i = 0; i < backbones.length; i ++) {
			backbones[i].style.display = 'block';
		}
	}
}

function hide_modal_dialog() {
	var backbones = document.getElementsByClassName('modal-dialog-backbone');
	
	if (backbones) {
		for (var i = 0; i < backbones.length; i ++) {
			backbones[i].style.display = 'none';
		}
	}
}