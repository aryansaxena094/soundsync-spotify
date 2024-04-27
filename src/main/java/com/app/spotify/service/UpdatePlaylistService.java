package com.app.spotify.service;

import java.sql.SQLException;

public interface UpdatePlaylistService {

	String updatePlaylist(String updatePlaylist, String playlistName) throws SQLException;

}
