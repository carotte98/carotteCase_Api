package fr.afpa.codecaseapi.service;

import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.model.User;
import fr.afpa.codecaseapi.repository.PostRepository;
import fr.afpa.codecaseapi.repository.UserRepository;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PostService
 * <i>de fr.afpa.codecaseapi.service</i>
 * <hr>
 * <p>Service pour appliquer les traitements métier de Post</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/09
 */

@Data
@Service
public class PostService {
  // Le Repository de Post.
  @Autowired
  private PostRepository postRepository;

  /**
   * Méthode getUsers.
   *
   *<i>de UserService</i>
   *<hr>
   *<p>Va chercher tous les Users dans la table</p>
   * @return Un Iterable composé de Users
   */
  public Iterable<Post> getPosts(){
    return postRepository.findAll();
  }

  /**
   * Méthode getUser.
   *
   *<i>de UserService</i>
   *<hr>
   *<p>Prends une id et renvoie le User en question s'il existe</p>
   * @param id l'id du User cherché
   * @return Un optional de Users
   */
  public Optional<Post> getPost(int id){
    return  postRepository.findById(id);
  }

  /**
   * Méthode saveUser.
   *
   *<i>de UserService</i>
   *<hr>
   *<p>Prends un Objet User et le sauvegarde ou le mets à jour dans la BDD</p>
   * @param user le User à créer ou modifier
   * @return Le User créé ou modifié
   */
  public User savePost(Post post){
    return postRepository.save(post);
  }

  /**
   * Méthode deleteUser.
   *
   *<i>de UserService</i>
   *<hr>
   *<p>Prends l'id d'un User et le supprime</p>
   * @param id L'id du User à delete
   */
  public void deletePost(int id){
    postRepository.deleteById(id);
  }
}
