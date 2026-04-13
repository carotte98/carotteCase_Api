package fr.afpa.codecaseapi.controller;

import fr.afpa.codecaseapi.exception.ExceptionManager;
import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.model.Tag;
import fr.afpa.codecaseapi.service.PostService;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PostController
 * <i>de fr.afpa.codecaseapi.controller</i>
 * <hr>
 * <p>Controller REST pour les endpoints Post</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/10
 */

@RestController
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping("/post")
  public ResponseEntity<Post> createPost(@RequestBody Post post){
    try{
      return ResponseEntity.ok(postService.savePost(post));
    } catch (Exception e) {
      return ExceptionManager.handleException(e);
    }

  }

  @GetMapping("/posts")
  public ResponseEntity<Iterable<Post>> getPosts(){
    try{
      return ResponseEntity.ok(postService.getPosts());
    } catch (Exception e) {
      return ExceptionManager.handleException(e);
    }
  }

  @GetMapping("/post/{id}")
  public ResponseEntity<Post> getPost(@PathVariable("id") int id){
    try{
      Optional<Post> post = postService.getPost(id);
      if (post.isPresent()){
        return ResponseEntity.ok(post.get());
      } else{
        return new ResponseEntity("Post non présent",
            HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return ExceptionManager.handleException(e);
    }
  }

  @PutMapping("/post/{id}")
  public ResponseEntity<Post> updatePost(@PathVariable("id") int id,
      @RequestBody Post post){

    try{
      Optional<Post> temp = postService.getPost(id);

      if(temp.isPresent()){
        Post current = temp.get();

        String titre = post.getTitre();
        String description = post.getDescription();
        String contenu = post.getContenu();
        Tag language = post.getLanguage();
        // À voir pour le tagCustom comment il est géré dans la base de donnée
        // (Est-ce qu'il peut être modifié par l'utilisateur ?) → Si oui,
        // ajouter un if() avec set.
//        Set tagCustom = post.getTagCustom();

        current.setTitre(titre != null ? titre : current.getTitre());

        if (description != null){
          current.setDescription(description);
        }

        if (contenu != null){
          current.setContenu(contenu);
        }

        if (language != null){
          current.setLanguage(language);
        }

        postService.savePost(current);
        return ResponseEntity.ok(current);
      } else {
        return new ResponseEntity("Post non présent",
            HttpStatus.NOT_FOUND);
      }
    } catch (Exception e){
      return ExceptionManager.handleException(e);
    }
  }

  @DeleteMapping("post/{id}")
  public ResponseEntity<String> deletePost(@PathVariable("id") int id){
    try{
      postService.deletePost(id);
      return ResponseEntity.ok("Post supprimé");
    } catch (Exception e){
      return ExceptionManager.handleException(e);
    }
  }

}
