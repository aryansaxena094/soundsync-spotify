package com.app.spotify.service;

import java.sql.SQLException;

public interface AddTracksService {

	String addRecords(String[] records, String playlist) throws SQLException;

}
