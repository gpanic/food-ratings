function selectListItem(id) {
	document.selectListItemForm.idItem.value=id;
	document.selectListItemForm.submit();
}

function deleteListItem(id) {
	document.deleteListItemForm.idItem.value=id;
	document.deleteListItemForm.submit();
}