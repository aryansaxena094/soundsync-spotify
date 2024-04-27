package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.service.DeletePlaylistService;
import com.app.spotify.service.UpdatePlaylistService;
import com.app.spotify.service.impl.DeletePlaylistServiceImpl;
import com.app.spotify.service.impl.UpdatePlaylistServiceImpl;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePlaylistController extends HttpServlet{

	Logger logger = Logger.getLogger(UpdatePlaylistController.class.getName());
	
	private static final long serialVersionUID = 1L;

	DBUtil dbutil = new DBUtil();
	
	public UpdatePlaylistController() {
		
	}
	public UpdatePlaylistController(DBUtil dbutil) {
		this.dbutil=dbutil;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO,"---------------update playlist controller entered----------------");
		UpdatePlaylistService addPlaylistService = new UpdatePlaylistServiceImpl(dbutil);
		String updatePlaylist = request.getParameter("playlistname");
		String playlistName = request.getParameter("getplaylist");
		logger.log(Level.INFO,"updatePlaylist value {0}" , updatePlaylist);
		logger.log(Level.INFO,"playlistName value {0}" , playlistName);
		response.setContentType("text/html;charset=UTF-8");
		String status;
		try {
			status = addPlaylistService.updatePlaylist(updatePlaylist,playlistName);
			logger.log(Level.INFO,"Connection Status {0} ",status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO,"---------------update playlist controller exited----------------");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
}
