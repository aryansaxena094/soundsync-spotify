package com.app.spotify.authorization;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import org.apache.hc.core5.http.ParseException;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

public class Authorization {

	private Authorization() {
		
	}
	
	static final String CLIENTID = "ae4f51721e954b42864ae4a77a429162";
	static final String CLIENTSECRET = "654049e2f5994a4587e3ed14a2e182b5";
	static final String REDIRECTURL = "https://github.com/ananyavarsha";
	
	private static String code;
	
	private static final URI redirectUri = SpotifyHttpManager.makeUri(REDIRECTURL);
	
	
	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENTID)
			.setClientSecret(CLIENTSECRET).setRedirectUri(redirectUri).build();

	private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
			.build();

	public static void authorizationCodeUriSync() {
		URI uri;
		try {
			uri = authorizationCodeUriRequest.execute();
			System.out.println("URI: " + uri.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void authorizationCodeSync() throws ParseException {
		AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code).build();
		try {
			final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

			// Set access and refresh token for further "spotifyApi" object usage
			spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
			spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

			System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
		} catch (IOException | SpotifyWebApiException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws ParseException {
	authorizationCodeUriSync();
	Scanner sc = new Scanner(System.in);
	System.out.println("please enter the code");
	code = sc.nextLine();
	System.out.println("code"+code);
	authorizationCodeSync();
	}
}
