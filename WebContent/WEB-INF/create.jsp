<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input a new movie into database</title>
</head>
<body>
	<div>
		<h1>Movie Creation Form!</h1>
	</div>
	<form:form name="input" method="post" modelAttribute="movie"
					action="Movie">
					<div>
						<label>Movie Title: </label>
						<form:input class="form-control" type="text" path="movieTitle" />
						<form:errors style="color: red;" path="movieTitle" />
					</div>
					<div>
						<label>Release Year: </label>
						<form:input class="form-control" type="number" path="releaseYear" />
						<form:errors style="color: red;" path="releaseYear" />
					</div>
										<div>
						<label>Rating: </label>
						<form:input class="form-control" type="number" path="rating" />
						<form:errors style="color: red;" path="rating" />
					</div>		
					<div>
						<input class="btn btn-info" type="submit" value="Submit">
					</div>
	</form:form>
</body>
</html>