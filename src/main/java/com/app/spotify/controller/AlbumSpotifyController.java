package com.app.spotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.app.spotify.model.Playlist;
import com.app.spotify.service.AlbumSpotifyService;
import com.app.spotify.service.GetPlaylistService;
import com.app.spotify.service.impl.AlbumSpotifyServiceImpl;
import com.app.spotify.service.impl.GetPlaylistServiceImpl;

import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

public class AlbumSpotifyController extends HttpServlet {

	Logger logger = Logger.getLogger(AlbumSpotifyController.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AlbumSpotifyService spotifyService = new AlbumSpotifyServiceImpl();

	public void setService(AlbumSpotifyServiceImpl spotifyService) {
		this.spotifyService = spotifyService;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.INFO, "-------------album spotify controller entered-------------");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getQueryString().split("=")[1];

		TrackSimplified[] items = spotifyService.getAlbumTrack(id);
		logger.log(Level.INFO, "tracks are as follow {0}", items);
		GetPlaylistService dao = new GetPlaylistServiceImpl();
		List<Playlist> playlistList;
		try {
			playlistList = dao.getPlaylist();
			logger.log(Level.INFO, "playlist {0}",playlistList);
			request.setAttribute("playlistList", playlistList);
			request.setAttribute("items", items);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.log(Level.INFO, "-------------album spotify controller exited-------------");
		request.getRequestDispatcher("/trackResult.jsp").forward(request, response);

	}

}
