/**
 * 
 */
function winTest(){
	var win = document.getElementById("win");
	
	if (win == 'Black') {
		alert('Black wins this game!!');
	}else if(win == 'White') {
		alert('White wins this game!!');
	}
}
function pointClicked(j,i){
	var p1 = document.getElementById("1p");
	var p2 = document.getElementById("2p");
	
	if (p2.checked == true) {
		location.href="p2PointClicked?j="+j+"&i="+i;
	}else{		
		location.href="p1PointClicked?j="+j+"&i="+i;
	}
}
function reset(){
	location.href="resetOhhmok";
}