package com.app.spotify.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.spotify.model.Playlist;
import com.app.spotify.service.GetPlaylistService;
import com.app.spotify.util.DBUtil;

public class GetPlaylistServiceImpl  implements GetPlaylistService{

	private static final String GET_PLAYLIST_SQL = "SELECT * FROM playlist;";
	
	DBUtil dbutil = new DBUtil();

	public GetPlaylistServiceImpl() {
	}

	public GetPlaylistServiceImpl(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	@Override
	public List<Playlist> getPlaylist() throws SQLException {
		Connection connection = dbutil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_PLAYLIST_SQL);
		ResultSet result = preparedStatement.executeQuery();
		List<Playlist> playlistList = new ArrayList<>();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("playlist_name");
			Playlist playlist = new Playlist(id,name);
			playlistList.add(playlist);
			System.out.println(id + " "+ name);
		}
		return playlistList;
		
	}

}
