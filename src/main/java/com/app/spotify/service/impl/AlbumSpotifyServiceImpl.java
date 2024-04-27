package com.app.spotify.service.impl;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;

import com.app.spotify.service.AlbumSpotifyService;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;

public class AlbumSpotifyServiceImpl implements AlbumSpotifyService {

	private static final String accessToken = "BQDl1YsN7VlHWGZjI3oyEL9rCGW4e24n8BTMIB3ZVWTGfj2hfnqJhpuBjg86u26I3MqVBHajpQrWNfnp-o75q3oemiEPXq9daGKIkHstBhK-INUSJj7fsDxUJtoEAVdxeYSmDViUXTBBr0WDlPfxM1zAQuQmLxsyQ5iSLsBCxIXaNCHJ5p_r-D5mBBxBJL4zsUnG6Q";
	private static SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();

	public void setSpotifyApi(SpotifyApi mockSpotify) {
		spotifyApi=mockSpotify;
	}
	
	@Override
	public TrackSimplified[] getAlbumTrack(String id) {
		try {
				System.out.println("id=" + id);
			  GetAlbumsTracksRequest getAlbumsTracksRequest = spotifyApi.getAlbumsTracks(id).build();
		      final Paging<TrackSimplified> trackSimplifiedPaging = getAlbumsTracksRequest.execute();
		      TrackSimplified[] items = trackSimplifiedPaging.getItems();
		      System.out.println("items in service" + id);
		      for(int i=0;i<items.length;i++) {
		    	  System.out.println(items[i]);
		      }
		      System.out.println("Total: " + trackSimplifiedPaging.getTotal());
		      return items;
		    } catch (IOException | SpotifyWebApiException | ParseException e) {
		      System.out.println("Error: " + e.getMessage());
		    }
		return null;
	}

	
}
