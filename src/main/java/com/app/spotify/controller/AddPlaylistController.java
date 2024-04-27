package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.service.AddPlaylistService;
import com.app.spotify.service.impl.AddPlaylistServiceImpl;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(AddPlaylistController.class.getName());

	DBUtil dbutil = new DBUtil();

	public AddPlaylistController() {

	}

	public AddPlaylistController(DBUtil dbutil) {
		this.dbutil = dbutil;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.INFO, "-------------play list add controller entered-------------");
		AddPlaylistService addPlaylistService = new AddPlaylistServiceImpl(dbutil);
		String submit = request.getParameter("playlistname");
		logger.log(Level.INFO, "submit value {0}", submit);
		response.setContentType("text/html;charset=UTF-8");
		String status;
		try {
			status = addPlaylistService.addPlaylist(submit);
			logger.log(Level.INFO, "Connection Status {0} ", status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO, "-------------play list add controller exited--------------");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
