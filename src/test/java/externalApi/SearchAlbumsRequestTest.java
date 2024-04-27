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
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class SearchAlbumsRequestTest {
	
	@Mock
	IHttpManager httpManager;
    
    @InjectMocks
    SearchSpotifyServiceImpl searchServiceMock;
    
	
	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

  private final SearchAlbumsRequest.Builder defaultRequestbuilder = ITest.SPOTIFY_API.searchAlbums(ITest.Q)
		    .setHttpManager(
		      TestUtil.MockedHttpManager.returningJson(
		        "SearchAlbumRequest.json"))
		    .limit(ITest.LIMIT)
		    .market(ITest.MARKET)
		    .offset(ITest.OFFSET)
		    .includeExternal("audio");
  
  

  public SearchAlbumsRequestTest() throws Exception {
  }
  
  @Test
  public void SearchAlbumTest() throws ParseException, SpotifyWebApiException, IOException {
	
	  SpotifyApi mockSpotify = mock(SpotifyApi.class);
	  searchServiceMock.setSpotifyApi(mockSpotify);
	  
	  when(mockSpotify.searchAlbums(anyString())).thenReturn(defaultRequestbuilder);
	  
	  List<AlbumSimplified> albumspecifies = searchServiceMock.searchAlbum(ITest.Q);
	  System.out.println("Albums:" + albumspecifies);
	 	  
  }
  

}