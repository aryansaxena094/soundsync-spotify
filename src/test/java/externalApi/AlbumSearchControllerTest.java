package externalApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.spotify.controller.AlbumSpotifyController;
import com.app.spotify.controller.SearchController;
import com.app.spotify.service.impl.AlbumSpotifyServiceImpl;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.michaelthelin.spotify.IHttpManager;
import se.michaelthelin.spotify.enums.AlbumType;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlbumSearchControllerTest {
	
	@Mock
	IHttpManager httpManager;
    
    @Mock
    AlbumSpotifyServiceImpl searchServiceMock;
    
    @InjectMocks
    AlbumSpotifyController albumController;
    
	
	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
	
	  private final Paging<TrackSimplified> defaultPaging = ITest.SPOTIFY_API.getAlbumsTracks(ITest.ID_ALBUM)
				.setHttpManager(
						  TestUtil.MockedHttpManager.returningJson(
						    "GetAlbumsTracksRequest.json"))
						.offset(ITest.OFFSET)
						.limit(ITest.LIMIT)
						.market(ITest.MARKET).build().execute();
	  

	  
	  public AlbumSearchControllerTest() throws Exception {
		    
	  }
	  
	  @Test
	  public void AlbumSearchTest() throws ServletException, IOException {
		  
		  HttpServletRequest request = mock(HttpServletRequest.class);
		  HttpServletResponse response = mock(HttpServletResponse.class);
		  TrackSimplified[] myalbums = mockListSimplified();
		  when(searchServiceMock.getAlbumTrack(anyString())).thenReturn(myalbums);
		  when(request.getQueryString()).thenReturn("id=1234566");
		  albumController.setService(searchServiceMock); 
		  request.setAttribute("items", myalbums);
		  response.setContentType("text/html");
		  RequestDispatcher rd = mock(RequestDispatcher.class);		   
		  when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		  albumController.doGet(request, response);
		  //assertEquals("Absolution",myalbums.get(0).getName());
		  
	  }
	  
	  public TrackSimplified[] mockListSimplified(){
		  TrackSimplified[] items = defaultPaging.getItems();
		  return items;
		  
	  }

}
