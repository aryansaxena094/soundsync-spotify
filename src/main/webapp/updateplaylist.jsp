<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="com.app.spotify.model.Playlist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		padding: 10 100px;
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
	
	a:link, a:visited {
		background-color: rgba(175, 175, 175, 0.63);
		color: black;
		border: 3px solid rgb(0, 0, 0);
		border-radius: 10px;
		padding: 10px 50px;
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
	}
	
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
	<title>Update PlayList</title>
</head>

<div class="center">
	<body>
		<body>
			<form ACTION="updateplaylist">
				<h3>Select a playlist:&nbsp;</h3><select name="getplaylist">
					<%
					List<Playlist> playlistList = (List<Playlist>) request.getAttribute("playlistList");
						for (Playlist playlist : playlistList) {
							%>
							<option value="<%=playlist.getId()%>"><%=playlist.getName()%></option>
							<%}%>
						</select>
					</form>
					<br>
					<form ACTION="updateplaylist">
						<h3>Update playlist to:</h3> <input type="text" name="playlistname"; value="";/> <br /></form>
						<br></br>
						<form ACTION="updateplaylist">
							<input type="submit" value="submit" class="button-16"/>
						</form>
					</br>
					<center><a href="index.jsp" class="btn btn-success">Return To Home Page</a></center>
				</body>
			</body>
		</div>
		</html>