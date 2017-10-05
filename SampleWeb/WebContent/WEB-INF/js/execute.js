window.addEventListener('DOMContentLoaded', function(event) {
	var body = document.querySelector('body');
	
	if (body) {
		body.addEventListener('click', hide_menu);
	}
	
	var slideImages = document.querySelectorAll('.image-item img');
	
	if (slideImages) {
		for (var i = 0; i < slideImages.length; i ++) {
			slideImages[i].addEventListener('mouseover', switch_image_slide);
		}
	}
	
	var collapseButtons = document.querySelectorAll('.title-panel button');
	
	if (collapseButtons) {
		for (var i = 0; i < collapseButtons.length; i ++) {
			collapseButtons[i].addEventListener('click', switch_title_panel);
		}
	}

	var slide = document.querySelector('.slide-bar');
	
	if (slide) {
		slide.addEventListener('mousedown', move_slide);
		slide.addEventListener('mousemove', move_slide);
		slide.addEventListener('mouseup', move_slide);
	}
});