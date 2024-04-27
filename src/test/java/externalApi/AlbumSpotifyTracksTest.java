package externalApi;

import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import se.michaelthelin.spotify.IHttpManager;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.spotify.service.impl.AlbumSpotifyServiceImpl;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import se.michaelthelin.spotify.IHttpManager;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;



public class AlbumSpotifyTracksTest {
	
	@Mock
	IHttpManager httpManager;
	
    
    @InjectMocks
    AlbumSpotifyServiceImpl albumTracksServiceMock;
    
	
	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
	
	private final GetAlbumsTracksRequest.Builder defaultTracks = ITest.SPOTIFY_API.getAlbumsTracks(ITest.ID_ALBUM)
			.setHttpManager(
			  TestUtil.MockedHttpManager.returningJson(
			    "GetAlbumsTracksRequest.json"))
			.offset(ITest.OFFSET)
			.limit(ITest.LIMIT)
			.market(ITest.MARKET);
			
	public AlbumSpotifyTracksTest() throws Exception {
		
	  }

	  @Test
	  public void SearchAlbumTracksTest() throws ParseException, SpotifyWebApiException, IOException {
		
		  SpotifyApi mockSpotify = mock(SpotifyApi.class);
		  albumTracksServiceMock.setSpotifyApi(mockSpotify);
		  
		  when(mockSpotify.getAlbumsTracks(anyString())).thenReturn(defaultTracks);
		  
		  TrackSimplified[] albumspecifies = albumTracksServiceMock.getAlbumTrack(ITest.Q);
		  System.out.println("Tracks:" + albumspecifies);
		 	  
	  }
}
