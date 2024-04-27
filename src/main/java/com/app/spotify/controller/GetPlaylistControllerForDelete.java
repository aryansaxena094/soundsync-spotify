package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.spotify.model.Playlist;
import com.app.spotify.service.GetPlaylistService;
import com.app.spotify.service.impl.GetPlaylistServiceImpl;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetPlaylistControllerForDelete extends HttpServlet{
	
	Logger logger = Logger.getLogger(GetPlaylistControllerForDelete.class.getName());

	private static final long serialVersionUID = 1L;

	DBUtil dbutil = new DBUtil();
	
	public GetPlaylistControllerForDelete() {
		
	}
	public GetPlaylistControllerForDelete(DBUtil dbutil) {
		this.dbutil=dbutil;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO,"-------------play list get for delete controller entered-------------");
		GetPlaylistService dao = new GetPlaylistServiceImpl(dbutil);
		List<Playlist> playlistList;
		try {
			playlistList = dao.getPlaylist();
			logger.log(Level.INFO,"playlist {0}",playlistList);
			request.setAttribute("playlistList", playlistList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO,"-------------play list get for delete controller entered-------------");
		request.getRequestDispatcher("/deleteplaylist.jsp").forward(request, response);
	}
}
