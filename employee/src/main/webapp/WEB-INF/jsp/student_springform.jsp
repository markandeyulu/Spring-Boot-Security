<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Form Example</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<script>
		$(function() {
			$('#showTotal').on("click", function() {

				$("#changedEnglishMark").show();

			});
		});
	</script>


	<form:form action="getCollegeMarkRequest" modelAttribute="collegeMarks"
		method="post">
		<div>
			<pre>
<label for="English">English</label>
				<form:input path="english" />
				<br>
<label for="Maths">Maths</label>
				<form:input path="maths" />
				<br>
<label for="Physics">Physics</label>
				<form:input path="physics" />
				<br>
<input type="submit" id="submitbtn" value="Submit"><br>
<input type="button" id="showTotal" value="Get Total"><br>
</pre>
		</div>
		<div id="changedEnglishMark" style="display: none;">Your Total
			Marks : ${collegeMarks.total}</div>
	</form:form>

</body>
</html>