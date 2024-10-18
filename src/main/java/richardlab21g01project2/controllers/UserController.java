package richardlab21g01project2.controllers;


import richardlab21g01project2.utils.repositories.UserRepository;
import richardlab21g01project2.utils.entities.MyUser;
import richardlab21g01project2.utils.entities.RegistrationForm;

import java.time.format.DateTimeFormatter;


import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



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
    public ModelAndView createUser(RegistrationForm form) {
        // We need to check first if username and email exists
        if (form.getPassword().length() < 8) {
            System.out.println("Password too short");
            return new ModelAndView("redirect:/register");
        }

        if (new String(form.getPassword()).equals(form.getPasswordConfirmation()) == false) {
            System.out.println("Password do not match");
            System.out.println(form.getPassword() + " " + form.getPasswordConfirmation());
            return new ModelAndView("redirect:/register");
        }

        MyUser user = new MyUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setCreationDate(
            ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        );
        
        // Code here to set the default pfp 

        myUserRepository.save(user);
        return new ModelAndView("redirect:/login");
    }
}