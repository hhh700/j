package richardlab21g01project2.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {
    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        return "viewScrolls";
    }

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            // String currentUserName = authentication.getName();
            boolean hasAdminRole = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

            return hasAdminRole ? new ModelAndView("redirect:/admin/") : new ModelAndView("redirect:/user/");
        }
        else {
            return new ModelAndView("index");
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    
    @GetMapping({"/user/", "/user/home"})
    public ModelAndView dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("username", authentication.getName());
        modelAndView.addObject("role", 
            authentication.getAuthorities().stream().anyMatch(r -> {
                System.out.println(r.getAuthority());
                return r.getAuthority().equals("ROLE_USER");
            })
                ? "USER" 
                : "ADMIN"
        );
        return modelAndView;
    }

    
    @GetMapping("/user/profile")
    public String profile(Model model) {
        return "profile";
    }

    @GetMapping("/user/profile/edit")
    public String editProfile(Model model) {
        return "editProfile";
    }
    
    @GetMapping("/user/scrolls") 
    public String profileScrolls(Model model) {
        return "myScrolls";  
    }

    @GetMapping("/user/scrolls/add") 
    public String addScrolls(Model model) {
        return "addScroll";  
    }

    @GetMapping("/user/scrolls/edit") 
    public String editScrolls(Model model) {
        return "editScroll";  
    }

    @GetMapping("/user/scrolls/delete") 
    public String deleteScrolls(Model model) {
        return "deleteScroll";  
    }

    @GetMapping("/user/scrolls/available") 
    public String availableScroll(Model model) {
        return "availableScroll";  
    }

    @GetMapping({"/admin", "/admin/home"}) 
    public String adminPanel(Model model) {
        return "adminPanel";  
    }
}