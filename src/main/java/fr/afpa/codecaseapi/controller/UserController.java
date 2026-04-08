package fr.afpa.codecaseapi.controller;

import fr.afpa.codecaseapi.model.User;
import fr.afpa.codecaseapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * UserController
 * <i>de fr.afpa.codecaseapi.controller</i>
 * <hr>
 * <p>Controller REST pour les endpoints User</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/08
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        //return userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){

        Optional<User> temp = userService.getUser(id);

        if(temp.isPresent()){
            User current = temp.get();

           String pseudo = user.getPseudoUser();
           String pass = user.getPasswordUser();
           String email = user.getEmailUser();
           String avatar = user.getAvatarUser();
           String role = user.getRole();//
           LocalDate signUp = user.getSignupDateUser();
           LocalDate last = user.getLastSignInUser();

            current.setPseudoUser(pseudo != null ? pseudo : current.getPseudoUser());

            if (pass != null){
                current.setPasswordUser(pass);
            }

            if (email != null){
                current.setEmailUser(email);
            }

            if (avatar != null){
                current.setAvatarUser(avatar);
            }

            if (role != null){
                current.setRole(role);
            }

            if (signUp != null){
                current.setSignupDateUser(signUp);
            }

            if (last != null){
                current.setLastSignInUser(last);
            }
            userService.saveUser(current);
            return current;
        }else {
            return null;
        }
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

}
