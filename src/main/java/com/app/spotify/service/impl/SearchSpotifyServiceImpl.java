package com.app.spotify.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.ParseException;

import com.app.spotify.service.SearchSpotifyService;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.AlbumType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

public class SearchSpotifyServiceImpl implements SearchSpotifyService {

	private static final String accessToken = "BQDl1YsN7VlHWGZjI3oyEL9rCGW4e24n8BTMIB3ZVWTGfj2hfnqJhpuBjg86u26I3MqVBHajpQrWNfnp-o75q3oemiEPXq9daGKIkHstBhK-INUSJj7fsDxUJtoEAVdxeYSmDViUXTBBr0WDlPfxM1zAQuQmLxsyQ5iSLsBCxIXaNCHJ5p_r-D5mBBxBJL4zsUnG6Q";

	private static SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();


	public void setSpotifyApi(SpotifyApi mockSpotify) {
		spotifyApi=mockSpotify;
	}
	
	@Override
	public List<AlbumSimplified> searchAlbum(String q) {

		try {
			SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(q).build();
			System.out.println("searchAlbumsRequest......."+searchAlbumsRequest.getJson());
			System.out.println("searchAlbumsRequest......."+searchAlbumsRequest.toString());
			final Paging<AlbumSimplified> albumSimplifiedPaging = searchAlbumsRequest.execute();
			System.out.println("albumSimplifiedPaging...."+albumSimplifiedPaging);
			System.out.println("Total: " + albumSimplifiedPaging.getTotal());
			AlbumSimplified[] items = albumSimplifiedPaging.getItems();
			List<AlbumSimplified> album = new ArrayList<>();
			int count = 0;
			for (int i = 0; i < items.length; i++) {
				if (items[i].getAlbumType() != null && items[i].getAlbumType() == AlbumType.ALBUM) {
					count++;
					album.add(items[i]);
					System.out.println(items[i]);
				}
				if(count==10)
					break;
			}
			return album;
		} catch (IOException | SpotifyWebApiException | ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	public Track[] searchTracks(String q) {

		try {
			SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(q).build();
			final Paging<Track> trackPaging = searchTracksRequest.execute();
			System.out.println("Total: " + trackPaging.getTotal());
			Track[] items = trackPaging.getItems();
			for (int i = 0; i <= 10; i++) {
				System.out.println(items[i]);
			}
			return items;
		} catch (IOException | SpotifyWebApiException | ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}


}
