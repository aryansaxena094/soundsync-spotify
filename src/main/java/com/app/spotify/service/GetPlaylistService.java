package com.app.spotify.service;

import java.sql.SQLException;
import java.util.List;

import com.app.spotify.model.Playlist;

public interface GetPlaylistService {

	List<Playlist> getPlaylist() throws SQLException;

}
