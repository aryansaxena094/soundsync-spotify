package com.app.spotify.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.service.AddTracksService;
import com.app.spotify.util.DBUtil;

public class AddTracksServiceImpl implements AddTracksService {
	
	Logger logger = Logger.getLogger(AddTracksServiceImpl.class.getName());

	private static final String INSERT_PLAYLIST_SQL = "INSERT INTO track (track_name,pid) VALUES (?,?);";

	DBUtil dbutil = new DBUtil();

	public AddTracksServiceImpl() {
	}

	public AddTracksServiceImpl(DBUtil dbutil) {
		this.dbutil=dbutil;
	}

	@Override
	public String addRecords(String[] records, String playlist) throws SQLException {

		List<String> trackRecords = Arrays.asList(records);
		Connection connection = dbutil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLIST_SQL);
		int result = 0;
		for (String track : trackRecords) {
			preparedStatement.setString(1, track);
			preparedStatement.setInt(2, Integer.valueOf(playlist));
			result = preparedStatement.executeUpdate();
			logger.log(Level.INFO, "track {0}" , track);
			if (result == 1)
				logger.log(Level.INFO, "successfully inserted");
			else
				logger.log(Level.INFO, "failed");
		}

		if (result == 1)
			return "successfully inserted";
		else
			return "failed";
	}

}
