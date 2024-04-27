package com.app.spotify.service;

import java.util.List;

import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Track;

public interface SearchSpotifyService {

	List<AlbumSimplified> searchAlbum(String string);
	Track[] searchTracks(String q);

}
