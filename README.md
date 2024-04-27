# Spotify Web API with Java

## Overview

This project explores the development of a web application using Spotify's REST API. The application adheres to various coding standards and software design methodologies. A backend database is integrated to manage data retrieved from Spotify's API, facilitating the display of specific information on the web application. Comprehensive testing has been conducted using Java’s JUnit 5 to ensure the robustness and reliability of the code.

## Features

### Simple Web Interface
The web application features a user-friendly interface where users can:
- **Search**: Enter a track name to find playlists containing the track along with related tracks.
- **Create Playlist**: Users can create new playlists and add tracks.
- **Update Playlist**: Existing playlists can be renamed.
- **Delete Playlist**: Users have the option to delete unwanted playlists.

### Data Handling and Storage
All user actions that modify playlists are reflected in a backend database which supports further data retrieval and validation.

### Testing and Quality Assurance
- **Unit Testing**: Each component of the application is tested using the JUnit 5 framework to validate individual pieces of the code.
- **Regression Testing**: Ensures that new updates do not disrupt existing functionalities.

### Software Refactoring
The application code undergoes continuous refinement to enhance quality, maintainability, and performance. Various refactoring techniques are employed to mitigate issues arising from code evolution.

## Application Flow

1. **Initial Page Load**:
   ![Initial Web Interface](https://github.com/ananyavarsha/spotifyv2/blob/master/1.jpg)
   - **Search Bar**: Look up albums or tracks.
   - **Create Playlist**: Initiate a new playlist.
   - **Update Playlist**: Modify the name of an existing playlist.
   - **Delete Playlist**: Remove an existing playlist.

2. **Search Results**:
   When a track is searched, all albums containing that track are displayed.
   ![Search Results Interface](https://github.com/ananyavarsha/spotifyv2/blob/master/2.jpg)

3. **Album Tracks**:
   Clicking on an album name displays all tracks within that album.
   ![Album Tracks Interface](https://github.com/ananyavarsha/spotifyv2/blob/master/3.jpg)

## Additional Resources
- **Full Demonstration Video**: [View Demo](https://liveconcordia-my.sharepoint.com/:f:/g/personal/ar_saxe_live_concordia_ca/El49r-Dgkw5Fk72EVfn3UlkBqKujlyiTOhaegpLVuaChwg?e=yTN6f0)

This documentation provides a structured overview of the project, facilitating easier understanding and navigation of the application’s capabilities and features.
