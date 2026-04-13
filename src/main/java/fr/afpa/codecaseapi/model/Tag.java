package fr.afpa.codecaseapi.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import java.util.Set;
import lombok.Data;
/**
 * Tag
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p></p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/09
 */
@Data
@Entity
public class Tag {
  @Id
  private Integer id;
  @OneToMany(mappedBy = "idCat")
  private List<Post> posts;
}

