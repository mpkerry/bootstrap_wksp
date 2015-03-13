	function showHideOtherSelectedDiv(item) {
		if (item.val() == 'OTH') {
			$('#otherSelectedDiv').show();
		} else {
			$('#otherSelectedDiv').hide();
			$('#award-name').val('');
		}
	}
	
	$(function(){
		//onload
		showHideOtherSelectedDiv($('#award-type'));
		//onchange
		$('#award-type').change(function(){
			showHideOtherSelectedDiv($('#award-type'));
		});
	});