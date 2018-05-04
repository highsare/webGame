/**
 * 
 */

function initialize(){
	var ckbox1 = document.getElementById(1);
	var ckbox2 = document.getElementById(2);
	var ckbox3 = document.getElementById(3);
	var ckbox4 = document.getElementById(4);
	var ckbox5 = document.getElementById(5);
	var ckbox6 = document.getElementById(6);
	var ckbox7 = document.getElementById(7);
	var ckbox8 = document.getElementById(8);
	var ckbox9 = document.getElementById(9);
	ckbox1.checked = true;
	ckbox5.checked = true;
	ckbox9.checked = true;
	ckbox2.checked = false;
	ckbox3.checked = false;
	ckbox4.checked = false;
	ckbox6.checked = false;
	ckbox7.checked = false;
	ckbox8.checked = false;
}

function clicked(i){
	var checkbox = document.getElementById(i);
	var ckbox1 = document.getElementById(1);
	var ckbox2 = document.getElementById(2);
	var ckbox3 = document.getElementById(3);
	var ckbox4 = document.getElementById(4);
	var ckbox5 = document.getElementById(5);
	var ckbox6 = document.getElementById(6);
	var ckbox7 = document.getElementById(7);
	var ckbox8 = document.getElementById(8);
	var ckbox9 = document.getElementById(9);

	switch(i){
	case 1:
		if (ckbox3.checked) {
			ckbox3.checked = false;
		}else{
			ckbox3.checked = true;
		}
		if (ckbox4.checked) {
			ckbox4.checked = false;
		}else{
			ckbox4.checked = true;
		}break;
	case 2:
		if (ckbox3.checked) {
			ckbox3.checked = false;
		}else{
			ckbox3.checked = true;
		}
		if (ckbox6.checked) {
			ckbox6.checked = false;
		}else{
			ckbox6.checked = true;
		}break;
	case 3:
		if (ckbox4.checked) {
			ckbox4.checked = false;
		}else{
			ckbox4.checked = true;
		}
		if (ckbox6.checked) {
			ckbox6.checked = false;
		}else{
			ckbox6.checked = true;
		}break;
	case 4:
		if (ckbox2.checked) {
			ckbox2.checked = false;
		}else{
			ckbox2.checked = true;
		}break;
	case 5:
		if (ckbox8.checked) {
			ckbox8.checked = false;
		}else{
			ckbox8.checked = true;
		}
		if (ckbox6.checked) {
			ckbox6.checked = false;
		}else{
			ckbox6.checked = true;
		}
		if (ckbox9.checked) {
			ckbox9.checked = false;
		}else{
			ckbox9.checked = true;
		}break;
	case 6:
		if (ckbox9.checked) {
			ckbox9.checked = false;
		}else{
			ckbox9.checked = true;
		}break;
	case 7:
		if (ckbox4.checked) {
			ckbox4.checked = false;
		}else{
			ckbox4.checked = true;
		}break;
	case 8:
		break;
	case 9:
		if (ckbox2.checked) {
			ckbox2.checked = false;
		}else{
			ckbox2.checked = true;
		}break;
	}
}

function isClean(){
	var ckbox1 = document.getElementById(1);
	var ckbox2 = document.getElementById(2);
	var ckbox3 = document.getElementById(3);
	var ckbox4 = document.getElementById(4);
	var ckbox5 = document.getElementById(5);
	var ckbox6 = document.getElementById(6);
	var ckbox7 = document.getElementById(7);
	var ckbox8 = document.getElementById(8);
	var ckbox9 = document.getElementById(9);
	if(!(ckbox1.checked||ckbox2.checked||ckbox3.checked||ckbox4.checked||ckbox5.checked||
			ckbox6.checked||ckbox7.checked||ckbox8.checked||ckbox9.checked)){
		alert("Congratulatuon!!");
	}else{
		alert("I don't think so :(")
	}
}