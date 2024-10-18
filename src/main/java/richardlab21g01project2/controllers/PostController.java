package richardlab21g01project2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import richardlab21g01project2.utils.entities.MyUser;

@Controller
public class PostController {
    // @RequestMapping(
    //     path = "/api/register", 
    //     method = RequestMethod.POST,
    //     consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    //     produces = {
    //         MediaType.APPLICATION_ATOM_XML_VALUE, 
    //         MediaType.APPLICATION_JSON_VALUE
    //     }
    // )
    // public String createUser(MyUser user) {
    //     System.out.println("Creating user... " + user.getUsername());
    //     return "index";
    // }

    // @PostMapping("/api/login")
    // public String login(@RequestBody HttpEntity<String> httpEntity) {
    //     return httpEntity.getBody();
    // }
}
