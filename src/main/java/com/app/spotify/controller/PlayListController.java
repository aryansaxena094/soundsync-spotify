package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.service.AddTracksService;
import com.app.spotify.service.impl.AddTracksServiceImpl;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PlaylistController extends HttpServlet{
	
	Logger logger = Logger.getLogger(PlaylistController.class.getName());

	private static final long serialVersionUID = 1L;

	DBUtil dbutil = new DBUtil();
	
	public PlaylistController() {
		
	}
	public PlaylistController(DBUtil dbutil) {
		this.dbutil=dbutil;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO,"---------------entered create playlist----------------");
		String[] records = request.getParameterValues("select");
		String playlist = request.getParameter("getplaylist");
		if (records != null && records.length != 0) {
			logger.log(Level.INFO,"You have selected the option is: ");
			for (int i = 0; i < records.length; i++) {
				logger.log(Level.INFO,"{0}",records[i]);
			}
		}
		logger.log(Level.INFO,"playlist selected is {0}",playlist);
		
		AddTracksService trackService = new AddTracksServiceImpl(dbutil);
		try {
			String status = trackService.addRecords(records,playlist);
			logger.log(Level.INFO,"data added {0} into track database",status);
			logger.log(Level.INFO,"---------------exited create playlist----------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
