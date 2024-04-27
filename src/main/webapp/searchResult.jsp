
<%@page
import="se.michaelthelin.spotify.model_objects.specification.AlbumSimplified"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style>
	body {
		background: linear-gradient(-45deg, #52ee67, #e73c7e, #23a6d5, #23d5ab);
		background-size: 400% 400%;
		animation: gradient 15s ease infinite;
		height: 100vh;
	}
	
	@keyframes gradient {
		0% {
			background-position: 0% 50%;
		}
		50% {
			background-position: 100% 50%;
		}
		100% {
			background-position: 0% 50%;
		}
	}
	
	.button-16 {
		background-color: #ffffff;
		border: 3px solid rgb(111, 111, 111);
		border-radius: 10px;
		color: #000000;
		cursor: pointer;
		font-family: arial,sans-serif;
		font-size: 25px;
		height: 50px;
		line-height: 27px;
		min-width: 100px;
		padding: 0 100px;
		text-align: center;
		user-select: none;
		-webkit-user-select: none;
		touch-action: manipulation;
		white-space: pre;
	}
	
	.button-16:hover {
		border-color: #000000;
		box-shadow: rgba(0, 0, 0, .1) 0 1px 1px;
		color: #202124;
	}
	
	.button-16:focus {
		border-color: #4285f4;
		outline: none;
	}
	
	/* a:link, a:visited {
		background-color: rgba(175, 175, 175, 0.63);
		color: black;
		border: 3px solid rgb(0, 0, 0);
		border-radius: 10px;
		padding: 30px 300px;
		font-family: arial,sans-serif;
		font-size: 22px;
		text-align: center;
		align-items: center;
		text-decoration: none;
		display: inline-block;
	}
	
	a:hover, a:active {
		background-color: rgb(94, 94, 94);
		color: white;
	} */
	
	.type-3 {
		display:block;
		width:1000px;
		padding: 10px;
		border:1px solid #111;
		transition: .3s background-color;
	}
	
	.type-3:hover {
		background-color: #fafafa;
	}
	
	form {
		display:flex;
		justify-content: center;
	}
	.center {
		margin: 0;
		position: absolute;
		top: 50%;
		left: 50%;
		-ms-transform: translate(-50%, -50%);
		transform: translate(-50%, -50%);
	}
	
	.div-1 {
		background-color: #9cf2a7;
		height: 100vh;
		display: flex;
		justify-content: center;
	}
</style>

<head>
	<meta charset="UTF-8">
	<title>Search Result</title>
</head>
<div class="center">
	<body>
		<center><h1 style="font-size: 30px;font-family: arial,sans-serif; font-style: italic; font-weight: lighter;">SOUNDSYNC</h1>
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Album Group</th>
				<th>Album Type</th>
				<th>URL</th>
			</tr>
			<%
			ArrayList<AlbumSimplified> list = (ArrayList<AlbumSimplified>) request.getAttribute("items");
				for (AlbumSimplified album : list) {
					%>
					<%-- Arranging data in tabular form
					--%>
					<tr>
						<td><%=album.getId()%></td>
						<td><a href="album?id=<%=album.getId()%>"><%=album.getName()%></a></td>
						<td><%=album.getAlbumGroup()%></td>
						<td><%=album.getAlbumType()%></td>
						<td><%=album.getExternalUrls()%></td>
					</tr>
					<%}%>
				</table>
				<br></br>
				<input type="submit" value="Submit" class = "button-16">
			</body>
		</div>
		</html>