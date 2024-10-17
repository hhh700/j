package richardlab21g01project2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContentController {
    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        return "viewScrolls";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "index";
    }

    @GetMapping("/Editprofile")
    public String editProfile(Model model) {
        return "Editprofile";
    }
    
    @GetMapping("/profile")
    public String profile(Model model) {
        return "Profile";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";  // Make sure dashboard.html or dashboard.jsp exists
    }

    @GetMapping("/profile/scrolls") 
    public String profile_scrolls(Model model) {
        return "Myscrolls";  
    }

    
    @GetMapping("/profile/scrolls/add") 
    public String add_scrolls(Model model) {
        return "addscroll";  
    }

    @GetMapping("/profile/scrolls/edit") 
    public String edit_scrolls(Model model) {
        return "Editscroll";  
    }

    
    @GetMapping("/profile/scrolls/delete") 
    public String delete_scrolls(Model model) {
        return "Deletescroll";  
    }

    @GetMapping({"/admin", "/admin/home"}) 
    public String admin_panel(Model model) {
        return "Admin_panel";  
    }
}