function close_alert_dialog(event) {
	var dialog = (event.target.nodeName == 'I') 
			? event.target.parentNode.parentNode.parentNode
			: event.target.parentNode.parentNode;
	
	if (dialog) {
		dialog.style.display = 'none';
	}
}

window.addEventListener('DOMContentLoaded', function(event) {
	var closeButtons = document.querySelectorAll('.alert-dialog-head button');
	
	if (closeButtons) {
		for (var i = 0; i < closeButtons.length; i ++) {
			closeButtons[i].addEventListener('click', close_alert_dialog);
		}
	}
});