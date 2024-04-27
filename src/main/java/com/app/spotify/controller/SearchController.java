package com.app.spotify.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.app.spotify.service.SearchSpotifyService;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(SearchController.class.getName());
	
	SearchSpotifyService spotifyService = new SearchSpotifyServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
	}

	public void setService(SearchSpotifyServiceImpl searchServiceMock) {
		spotifyService=searchServiceMock;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO,"---------------search controller entered----------------");
		String searchName = request.getParameter("search");
		response.setContentType("text/html;charset=UTF-8");
		List<AlbumSimplified> items = spotifyService.searchAlbum(searchName);
		request.setAttribute("items", items);
		System.out.println("search name "+searchName);
		logger.log(Level.INFO,"---------------search controller exited----------------");
		request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
