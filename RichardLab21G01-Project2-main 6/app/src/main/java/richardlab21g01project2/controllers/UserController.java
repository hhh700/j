package richardlab21g01project2.controllers;

import richardlab21g01project2.utils.repositories.UserRepository;
import richardlab21g01project2.utils.entities.MyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpEntity;

@RestController
public class UserController {

    @Autowired
    private UserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(
        path = "/api/register", 
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
        produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, 
            MediaType.APPLICATION_JSON_VALUE
        }
    )
    public String createUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        System.out.println("user" + user.getUsername() + user.getPassword() + user.getRole() + user.getId()); 
        myUserRepository.save(user);
        return "index";
    }

    // @RequestMapping(
    //     path = "/api/login", 
    //     method = RequestMethod.POST,
    //     consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    //     produces = {
    //         MediaType.APPLICATION_ATOM_XML_VALUE, 
    //         MediaType.APPLICATION_JSON_VALUE
    //     }
    // )
    // public String login(MyUser user) {
    //     System.out.println("Logging in user " + user.getUsername() + " with password " + user.getPassword());
    //     return "index";
    // }
}