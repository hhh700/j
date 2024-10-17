package richardlab21g01project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import richardlab21g01project2.service.ScrollService;

import java.io.IOException;

@Controller
public class ScrollController {
    @Autowired
    private ScrollService scrollService;

    @PostMapping("/upload")
    public String uploadScroll(@RequestParam("scrollName") String scrollName,
                               @RequestParam("file") MultipartFile file,
                               RedirectAttributes redirectAttributes) {
        try {
            scrollService.saveScroll(scrollName, file);
            redirectAttributes.addFlashAttribute("message", "Scroll uploaded successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload scroll: " + e.getMessage());
        }
        return "redirect:/upload";
    }
}

