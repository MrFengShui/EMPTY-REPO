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