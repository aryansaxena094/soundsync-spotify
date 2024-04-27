package externalApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.app.spotify.controller.SearchController;
import com.app.spotify.service.impl.SearchSpotifyServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.michaelthelin.spotify.IHttpManager;
import se.michaelthelin.spotify.enums.AlbumType;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchControllerTest {
	
	@Mock
	IHttpManager httpManager;
    
    @Mock
    SearchSpotifyServiceImpl searchServiceMock;
    
    @InjectMocks
    SearchController searchController;
    
	
	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
	
	  private final Paging<AlbumSimplified> defaultPaging = ITest.SPOTIFY_API.searchAlbums(ITest.Q)
			    .setHttpManager(
			      TestUtil.MockedHttpManager.returningJson(
			        "SearchAlbumRequest.json"))
			    .limit(ITest.LIMIT)
			    .market(ITest.MARKET)
			    .offset(ITest.OFFSET)
			    .includeExternal("audio").build().execute();
	  

	  
	  public SearchControllerTest() throws Exception {
		    
	  }
	  
	  @Test
	  public void SearchControllerTesting() throws ServletException, IOException {
		  
		  HttpServletRequest request = mock(HttpServletRequest.class);
		  HttpServletResponse response = mock(HttpServletResponse.class);
		  List<AlbumSimplified> myalbums = mockListSimplified();
		  when(searchServiceMock.searchAlbum(anyString())).thenReturn(myalbums);
		  when(request.getParameter(anyString())).thenReturn(ITest.ID_ALBUM);
		  searchController.setService(searchServiceMock); 
		  request.setAttribute("items", myalbums);
		  response.setContentType("text/html");
		  RequestDispatcher rd = mock(RequestDispatcher.class);		   
		  when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		  searchController.doPost(request, response);
		  assertEquals("Absolution",myalbums.get(0).getName());
		  
	  }
	  
	  public List<AlbumSimplified> mockListSimplified(){
			AlbumSimplified[] items = defaultPaging.getItems();
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
		  
	  }

}
