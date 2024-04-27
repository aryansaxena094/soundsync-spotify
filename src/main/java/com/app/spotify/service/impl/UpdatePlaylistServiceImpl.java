package com.app.spotify.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.spotify.service.UpdatePlaylistService;
import com.app.spotify.util.DBUtil;

public class UpdatePlaylistServiceImpl implements UpdatePlaylistService {

	private static final String UPDATE_PLAYLIST_SQL = "UPDATE playlist SET playlist_name=? where id=?";

	DBUtil dbutil = new DBUtil();

	public UpdatePlaylistServiceImpl() {
	}

	public UpdatePlaylistServiceImpl(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	@Override
	public String updatePlaylist(String updatePlaylist, String playlistName) throws SQLException {
		Connection connection = dbutil.getConnection();

		PreparedStatement preparedStatementUpdateTrack = connection.prepareStatement(UPDATE_PLAYLIST_SQL);
		preparedStatementUpdateTrack.setString(1, updatePlaylist);
		preparedStatementUpdateTrack.setInt(2, Integer.valueOf(playlistName));
		System.out.println();
		int result = preparedStatementUpdateTrack.executeUpdate();
		if (result == 1)
			return "successfully inserted";
		else
			return "failed";
	}

}
