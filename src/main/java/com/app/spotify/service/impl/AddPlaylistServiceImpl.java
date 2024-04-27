package com.app.spotify.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.spotify.service.AddPlaylistService;
import com.app.spotify.util.DBUtil;

public class AddPlaylistServiceImpl  implements AddPlaylistService{

	private static final String INSERT_PLAYLIST_SQL = "INSERT INTO playlist (playlist_name) VALUES (?);";
	
	DBUtil dbutil = new DBUtil();
	
	public AddPlaylistServiceImpl() {
	}
	
	public AddPlaylistServiceImpl(DBUtil dbutil) {
		this.dbutil=dbutil;
	}
	
	@Override
	public String addPlaylist(String submit) throws SQLException {
		Connection connection = dbutil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLIST_SQL);
		preparedStatement.setString(1, submit);
		int result = preparedStatement.executeUpdate();
		if(result == 1)
			return "successfully inserted";
		else
			return "failed";
	}

}
