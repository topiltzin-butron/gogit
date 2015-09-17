/*
 * 
 * GoGIT JS 
 * 
 */

function search() {
	var term = document.getElementById("term");
	var value = term.value;
	var url = CONTEXT_ROOT + "/interviews/giphy/search";
	var query = "term=" + value;
	var req = new XMLHttpRequest();
    req.open("POST", url, true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    req.onreadystatechange = function() {
	    if(req.readyState == 4 && req.status == 200) {
		    var returnData = req.responseText;
		    var imageContainer = document.getElementById("imageContainer");
		    imageContainer.innerHTML = returnData; 
	    }
    }
	req.send(query);
	return false;
}