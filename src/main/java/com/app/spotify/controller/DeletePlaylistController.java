package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.service.DeletePlaylistService;
import com.app.spotify.service.impl.DeletePlaylistServiceImpl;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletePlaylistController extends HttpServlet {

	Logger logger = Logger.getLogger(DeletePlaylistController.class.getName());
	
	private static final long serialVersionUID = 1L;

	DBUtil dbutil = new DBUtil();
	
	public DeletePlaylistController() {
		
	}
	public DeletePlaylistController(DBUtil dbutil) {
		this.dbutil=dbutil;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO,"-------------play list delete controller entered-------------");
		DeletePlaylistService addPlaylistService = new DeletePlaylistServiceImpl(dbutil);
		String deletedplaylist = request.getParameter("getplaylist");
		logger.log(Level.INFO,"deletedplaylist value {0}" , deletedplaylist);
		response.setContentType("text/html;charset=UTF-8");
		String status;
		try {
			status = addPlaylistService.deletePlaylist(deletedplaylist);
			logger.log(Level.INFO,"Connection Status {0} ",status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO,"-------------play list delete controller entered-------------");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
