# Spotify Web API with Java

##Introduction

The use of Spotify’s REST API to create a web application in accordance to several coding standards and software design methodologies have been studied in this project. 
A database is created to handle the incoming information from the API and the same is being used to display specific information on the web application. 
The entire code base has been thoroughly tested using Java’s JUnit 5.

A simple web interface has been developed, that takes a string value which is basically a name of a track.
The user is now displayed with a list of playlists that contains this track along with its related tracks. 
Furthermore, the user is provided with an option to create a new playlist of his/her choice and add this track to it. 
Once this action is performed, the user’s playlist data is stored in a backend database, which is further used for information retrieval and validation.
The individual components or pieces of methods/classes have been extensively tested using JUnit 5 framework. 
Complementing this unit testing, regression testing has also been performed, which makes certain that the latest fix, enhancement, or patch did not break existing functionality.
The components of the code tend to undergo several iterations, changes and enhancements which deteriorate the quality, maintainability and efficiency of the software. We have also studied and utilized several refactoring methodologies to overcome this cause an effect. 

##Description

This is a JAVA application that externally calls Spotify’s API and retrieves the records of the same and renders to a web page.

The first web page that renders when you run the application is Fig 

<p align="center">
  <img src="https://github.com/ananyavarsha/spotifyv2/blob/master/1.jpg" alt="IMAGE" style="width:400px;"/>
</p>

This page has four entities. 
Search Bar: to search for the albums that you wish to see.
Create Playlist: If you want to add tracks into your system, you first need to create a playlist.
Update Playlist: If you wish to change the name of your existing playlist, you can do it using update playlist button.
Delete Playlist: If you wish to delete the playlist, it can be done using delete playlist button.

When you search for a particular track, and hit the search button, it will display all the albums containing the tracks you searched for. This is shown in the Fig 

<p align="center">
  <img src="https://github.com/ananyavarsha/spotifyv2/blob/master/2.jpg" alt="IMAGE" style="width:400px;"/>
</p>

If you wish to see the track list for a particular album, you can do it by clicking on the Name field’s result, which will take you to the next page that will list all the tracks in that album.


<p align="center">
  <img src="https://github.com/ananyavarsha/spotifyv2/blob/master/3.jpg" alt="IMAGE" style="width:400px;"/>
</p>


Full demo is shown in a video avaiable in the following link:
[video link](https://liveconcordia-my.sharepoint.com/:f:/g/personal/ar_saxe_live_concordia_ca/El49r-Dgkw5Fk72EVfn3UlkBqKujlyiTOhaegpLVuaChwg?e=yTN6f0)
