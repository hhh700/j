package richardlab21g01project2.controllers;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import richardlab21g01project2.service.ScrollService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import richardlab21g01project2.utils.entities.*;
@Controller
public class ScrollController {
    @Autowired
    private ScrollService scrollService;
    private static final Logger logger = LoggerFactory.getLogger(ScrollService.class);
    @PostMapping("/upload")
    public String uploadScroll(@RequestParam("scrollName") String scrollName,
                            @RequestParam("file") MultipartFile file,
                            Model model) {
        logger.info("Received upload request for scroll: " + scrollName);
        try {
            scrollService.saveScroll(scrollName, file);
            model.addAttribute("message", "Scroll uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "Failed to upload scroll: " + e.getMessage());
        }
        return "uploadResult"; // Return a view name to display the result
    }
    @GetMapping("/scrolls")
    @ResponseBody
    public List<Scroll> getScrolls() {
        return scrollService.getAllScrolls();
    }


}


