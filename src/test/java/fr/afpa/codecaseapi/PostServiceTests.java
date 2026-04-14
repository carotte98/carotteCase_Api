package fr.afpa.codecaseapi;

import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.repository.PostRepository;
import fr.afpa.codecaseapi.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * PostServiceTests
 * <i>de fr.afpa.codecaseapi</i>
 * <hr>
 * <p>Classe de tests pour la classe PostService</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/14
 */

@SpringBootTest
@AutoConfigureMockMvc
public class PostServiceTests {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private PostRepository postRepository;

  @InjectMocks
  private PostService postService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetPostById(){

    Post fakePost = new Post();
  }
}
