package fr.afpa.codecaseapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

/**
 * Post
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p>Modèle Post, lié à JPA</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/09
 */

@Data
@Entity
@Table(name = "post")
public class Post {
  /**
   * Variable id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idPost")
  private Integer idPost;

  /**
   * Variable titre.
   */
  @Size(min = 3, max = 100)
  @Column(name = "titrePost")
  private String titrePost;

  /**
   * Variable description.
   */
  @Size(max = 250)
  @Column(name = "descriptionPost")
  private String descriptionPost;

  /**
   * Variable contenu.
   */
  @NotEmpty()
  @Column(name = "contenuPost")
  private String contenuPost;

  /**
   * Variable userId.
   */
  @Column(name = "idUser")
  private Integer idUser;

  /**
   * Variable language de type Tag.
   */
  @OneToMany(mappedBy = "post")
  @Column(name = "idCat")
  private Set<Tag> idCat;

  /**
   * Variable tagCustom, dans une Arraylist de type Tag.
   */
  @ManyToMany(mappedBy = "post")
  Set<Tag> tagCustom;

  /**
   * Variable creationPost.
   */
  @Column(name = "dateCreation")
  private LocalDate dateCreation;

}
