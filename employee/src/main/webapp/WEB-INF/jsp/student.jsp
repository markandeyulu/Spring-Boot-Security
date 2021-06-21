<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
#tamil {
	color: blue
}

#english {
	color: gray;
}

#science {
	color: purple;
}
</style>
<script>
	function findTotal() {

		/* var url = "/manoj/findTotal?";
		url += "tamil=" + document.getElementById("tamil").value + "&";
		url += "english=" + document.getElementById("english").value + "&";
		url += "maths=" + document.getElementById("maths").value + "&";
		url += "science=" + document.getElementById("science").value + "&";
		url += "social=" + document.getElementById("social").value;
		//alert(url);
		const request = new XMLHttpRequest();
		request.onload = function() {
		
		var json = JSON.parse(this.responseText);
		document.getElementById("total").innerHTML = "Your total marks : " + json["total"];
		
		}
		request.open("GET", url);
		request.send();
		 */
		/*  
		 var url = "/manoj/findTotal";
		 
		 const myMap = new Map();
		 myMap.set("tamil", document.getElementById("tamil").value);
		 myMap.set("english", document.getElementById("english").value);
		 myMap.set("maths", document.getElementById("maths").value);
		 myMap.set("science", document.getElementById("science").value);
		 myMap.set("social", document.getElementById("social").value);
		 
		var postUrl = JSON.stringify(Array.from(myMap.entries()));
		//alert(url);
		const request = new XMLHttpRequest();
		request.onload = function() {
		
		var json = JSON.parse(this.responseText);
		document.getElementById("total").innerHTML = "Your total marks : " + this.responseText;
		
		}
		request.open("POST", url);
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		console.log(JSON.stringify({tamil:"11", english:"22", maths:"22", science:"22", social:"22"}));
		request.send(JSON.stringify({"tamil":"11", "english":"22", "maths":"22", "science":"22", "social":"22"})); */

 var jsonStr = {tamil:"11",english:"22",maths:"22",science:"22",social:"22"};

var json = JSON.stringify(jsonStr);
		$.ajax({
			url : "/manoj/findTotal1",
			type : "post",
			data : json,
			contentType: "application/json",
			success : function(response, status, xhr) {
			console.log(status);
			console.log(xhr.status);
				document.getElementById("total").innerHTML = "Your total marks : " + response.total;
			},
			error : function(xhr, textStatus, err) {
				document.getElementById("total").innerHTML = xhr.status + textStatus + err;
			}
		});

	} 
</script>
</head>
<body>

	<form action="/manoj/processStudentData">

		<H3>Enter subject marks to calculate average</H3>
		<div>
			<pre>
<label for="tamil">Tamil</label>
<input type="text" name="tamil" id="tamil"><br><br>
<label for="english">English</label>
<input type="text" name="english" id="english"><br><br>
<label for="maths">Maths</label>
<input type="text" name="maths" id="maths"><br><br>
<label for="science">Science</label>
<input type="text" name="science" id="science"><br><br>
<label for="social">Social</label>
<input type="text" name="social" id="social">

<input type="button" value="Get Total" onclick="findTotal();">

<input type="button" value="Home"
					onclick="window.location = '/manoj/getStudent'">

</pre>
		</div>


		<div id="total"></div>

	</form>


</body>
</html>