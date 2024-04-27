package com.app.spotify.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.spotify.service.DeletePlaylistService;
import com.app.spotify.util.DBUtil;

public class DeletePlaylistServiceImpl implements DeletePlaylistService {

	private static final String DELETE_PLAYLIST_SQL = "DELETE FROM playlist WHERE id = ?";

	private static final String DELETE_TRACKS_SQL = "DELETE FROM track WHERE pid = ?";

	DBUtil dbutil = new DBUtil();

	public DeletePlaylistServiceImpl() {
	}

	public DeletePlaylistServiceImpl(DBUtil dbutil) {
		this.dbutil = dbutil;
	}

	@Override
	public String deletePlaylist(String deletedplaylist) throws SQLException {
		Connection connection = dbutil.getConnection();

		PreparedStatement preparedStatementDeleteTrack = connection.prepareStatement(DELETE_TRACKS_SQL);
		preparedStatementDeleteTrack.setInt(1, Integer.valueOf(deletedplaylist));
		System.out.println();
		int resultOfTrack = preparedStatementDeleteTrack.executeUpdate();
		String status;
		if (resultOfTrack == 1)
			status = "successful";
		else
			status = "failed";
		System.out.println("-------------track deleted status-------------" + status);

		PreparedStatement preparedStatementDeletePlaylist = connection.prepareStatement(DELETE_PLAYLIST_SQL);
		preparedStatementDeletePlaylist.setInt(1, Integer.valueOf(deletedplaylist));
		int result = preparedStatementDeletePlaylist.executeUpdate();

		if (result == 1)
			return "successfully inserted";
		else
			return "failed";
	}

}
