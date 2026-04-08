package fr.afpa.codecaseapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * User.
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p>Model User, liée à JPA pour la modélisation de la BDD</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/07
 */
@Data
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "pseudoUser")
    private String pseudoUser;

    @Column(name = "passwordUser")
    private String passwordUser;

    @Column(name = "signupDateUser")
    private LocalDate signupDateUser;

    @Column(name = "lastSignInUser")
    private LocalDate lastSignInUser;

    @Column(name = "emailUser")
    private String emailUser;

    @Column(name = "avatarUser")
    private String avatarUser;

    @Column(name = "Role")
    private String role;
}
