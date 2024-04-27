package databaseTest;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.app.spotify.controller.AddPlaylistController;
import com.app.spotify.controller.DeletePlaylistController;
import com.app.spotify.controller.GetPlaylistControllerForDelete;
import com.app.spotify.controller.GetPlaylistControllerForUpdate;
import com.app.spotify.controller.PlaylistController;
import com.app.spotify.controller.UpdatePlaylistController;
import com.app.spotify.model.Playlist;
import com.app.spotify.util.DBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RunWith(MockitoJUnitRunner.class)
public class DbUtilTest {

	
	@Mock
	private Connection mockConnection;
	
    @Mock
    private PreparedStatement stmt;

    
    @Mock
    private ResultSet rs;
    
    @InjectMocks
    private AddPlaylistController addPlaylistController;
    
    @InjectMocks
    private DeletePlaylistController deletePlaylistController;
    
    @InjectMocks
    private GetPlaylistControllerForDelete getPlaylistControllerForDelete;
    
    @InjectMocks
    private GetPlaylistControllerForUpdate getPlaylistControllerForUpdate;
    
    @InjectMocks
    private PlaylistController playlistController;
    
    @InjectMocks
    private UpdatePlaylistController updatePlaylistController;
    
    DBUtil dbutil = new DBUtil();
	@Before
	public void testMockDBConnection() throws Exception {
		mockConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify_test", "root",
				"Kavithas$9$9");
		dbutil = Mockito.mock(DBUtil.class);
		when(dbutil.getConnection()).thenReturn(mockConnection);
	}
	
	@Test
	public void addPlaylistTestController() throws ServletException, IOException, SQLException {
		
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("playlistname")).thenReturn("english");
	    
	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    
	    AddPlaylistController addPlaylistController = new AddPlaylistController(dbutil);
	    addPlaylistController.doPost(request, response);
	}
	
	@Test
	public void getPlaylistTestControllerForDelete() throws ServletException, IOException, SQLException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    Playlist playlist = new Playlist();
	    playlist.setId(1);
	    playlist.setName("favorite");
	    List<Playlist> playlistList = new ArrayList<>();
	    playlistList.add(playlist);
	    request.setAttribute("playlistList", playlistList);
	    when(stmt.executeUpdate()).thenReturn(1);

	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    GetPlaylistControllerForDelete getPlaylistControllerForDelete = new GetPlaylistControllerForDelete(dbutil);
	    getPlaylistControllerForDelete.doGet(request, response);
	}

	@Test
	public void getPlaylistTestControllerForUpdate() throws ServletException, IOException, SQLException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    Playlist playlist = new Playlist();
	    playlist.setId(1);
	    playlist.setName("favorite");
	    List<Playlist> playlistList = new ArrayList<>();
	    playlistList.add(playlist);
	    request.setAttribute("playlistList", playlistList);
	    when(stmt.executeUpdate()).thenReturn(1);

	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    GetPlaylistControllerForUpdate getPlaylistControllerForUpdate = new GetPlaylistControllerForUpdate(dbutil);
	    getPlaylistControllerForUpdate.doGet(request, response);
	}
	
	@Test
	public void playlistTestControllerSuccess() throws ServletException, IOException, SQLException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    String[] records = new String[1];
	    records[0]="Let it go";
	    when(request.getParameterValues("select")).thenReturn(records);
	    
	    String playlist = "1";
	    when(request.getParameter("getplaylist")).thenReturn(playlist);
	    when(stmt.executeUpdate()).thenReturn(1);
	    PlaylistController playlistController = new PlaylistController(dbutil);
	    playlistController.doGet(request, response);
	}
	
	@Test
	public void updatePlaylistTestController() throws ServletException, IOException, SQLException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    String playlistname = "english";
	    when(request.getParameter("playlistname")).thenReturn(playlistname);
	    
	    String playlist = String.valueOf(1);
	    when(request.getParameter("getplaylist")).thenReturn(playlist);
	    when(stmt.executeUpdate()).thenReturn(1);
	    UpdatePlaylistController updatePlaylistController = new UpdatePlaylistController(dbutil);
	    
	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    updatePlaylistController.doGet(request, response);
	}
	@Test
	public void deletePlaylistTestControllerFailed() throws ServletException, IOException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("getplaylist")).thenReturn("20");
	    DeletePlaylistController deletePlaylistController = new DeletePlaylistController(dbutil);
	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    deletePlaylistController.doGet(request, response);
	}
	
	@Test
	public void deletePlaylistTestControllerSuccess() throws ServletException, IOException, SQLException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("getplaylist")).thenReturn("20");
	    when(stmt.executeUpdate()).thenReturn(1);
	    DeletePlaylistController deletePlaylistController = new DeletePlaylistController(dbutil);
	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(anyString())).thenReturn(rd);
	    deletePlaylistController.doGet(request, response);
	}
	
}
