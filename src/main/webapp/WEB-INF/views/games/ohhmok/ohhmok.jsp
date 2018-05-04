<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Moon's Ohhmok !!</title>
	<script type="text/javascript" src="resources/JS/jquery-3.2.1.min.js"></script>
	<!-- <script type="text/javascript" src="resources/JS/Ohhmok.js"></script> -->
	<script type="text/javascript">
		$(document).ready(function() {
			var win = document.getElementById("win");
			
			if (win == 'Black') {
				alert('Black wins this game!!');
			}else if(win == 'White') {
				alert('White wins this game!!');
			}
		} );
		
		function winTest(){
			var win = document.getElementById("win");
			
			if (win == 'Black') {
				alert('Black wins this game!!');
			}else if(win == 'White') {
				alert('White wins this game!!');
			}
		}
		function pointClicked(j,i){
			/* var p1 = document.getElementById("1p");
			var p2 = document.getElementById("2p"); */
		
			location.href="p2PointClicked?j="+j+"&i="+i;
			/* if (p2.checked == true) {
				location.href="p2PointClicked?j="+j+"&i="+i;
			}else{		
				location.href="p1PointClicked?j="+j+"&i="+i;
			} */
		}
		function reset(){
			location.href="resetOhhmok";
		}	
	</script>
	<link rel=stylesheet href="resources/Styles/Ohhmok.css" type="text/css">
</head>
<body>

<h1>오목!</h1>

<div class="container">
	<div>
		<img alt="board" src="resources/Images/GoBoard.png" class="board" usemap="#board">
		<map name="board">
			<c:forEach var="i" begin="0" end="9">
				<c:forEach var="j" begin="0" end="9">
					<area shape="circle" coords="${25+j*50 },${25+i*50 },15"
					 onclick="pointClicked(${j},${i})" name="area" class="crossPoint" id="a${j}${i}" >
				</c:forEach>
			</c:forEach>
		</map>
	</div>
	
	<c:if test="${sessionScope.dlist != null }">
		<c:forEach var="dots" items="${sessionScope.dlist }">
				<c:choose>
					<c:when test="${dots.color == 1 }">
						<div class="dots" style="top:${8+dots.coord_y*50}px; left:${8+dots.coord_x*50}px;">
							<img alt="" src="resources/Images/blackGo.png">
						</div>
					</c:when>
					<c:when test="${dots.color == -1 }">
						<div class="dots" style="top:${8+dots.coord_y*50}px; left:${8+dots.coord_x*50}px;">
							<img alt="" src="resources/Images/whiteGo.png">
						</div>
					</c:when>
				</c:choose>
		</c:forEach>
	</c:if>
</div>

<div>
	<label>같이 하기
		<input type="radio" name="plyaerNum" id="2p" value="2p" checked="checked" >
	</label>
	<label>혼자 하기
		<input type="radio" name="plyaerNum" id="1p" value="1p">
	</label>
	<input type="button" value="리셋" onclick="javascript:reset()">
</div>

<div>
	<input type="hidden" value="${sessionScope.win }" id="win">
</div>

</body>
</html>