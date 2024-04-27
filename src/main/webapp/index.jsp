<html>
<style>
body {
	background: linear-gradient(-45deg, #52ee67, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
	height: 100vh;
}

@
keyframes gradient { 0% {
	background-position: 0% 50%;
}

50


%
{
background-position


:


100
%


50
%;


}
100


%
{
background-position


:


0
%


50
%;


}
}
.button-16 {
	background-color: #ffffff;
	border: 3px solid rgb(111, 111, 111);
	border-radius: 10px;
	color: #000000;
	cursor: pointer;
	font-family: arial, sans-serif;
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

a:link, a:visited {
	background-color: rgba(175, 175, 175, 0.63);
	color: black;
	border: 3px solid rgb(0, 0, 0);
	border-radius: 10px;
	padding: 30px 300px;
	font-family: arial, sans-serif;
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
	display: block;
	width: 1000px;
	padding: 10px;
	border: 1px solid #111;
	transition: .3s background-color;
}

.type-3:hover {
	background-color: #fafafa;
}

form {
	display: flex;
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
<div>
	<div class="center">
		<body>
			<center>
				<h1
					style="font-size: 75px; font-family: arial, sans-serif; font-style: italic; font-weight: lighter;">SOUNDSYNC</h1>
				<br>
				<form name="search" method="post" action="search">
					<input type="text" name="search" class="type-3" /> </br> </br>
					<input type="submit" value="Search" class="button-16" /> </br>
				</form>
			</center>
			<br style="line-height: 5px;"></br>
			<center>
				<br> <a href="playlist.jsp" class="btn btn-success">Create
					Playlist</a> </br> <br> <a href="getplaylistupdate"
					class="btn btn-success">Update Playlist</a> </br> <br> <a
					href="getplaylistdelete" class="btn btn-success">Delete
					Playlist</a> </br>
			</center>
		</body>
	</div>
</div>
</html>
