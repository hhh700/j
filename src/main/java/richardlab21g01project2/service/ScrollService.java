package richardlab21g01project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import richardlab21g01project2.utils.repositories.ScrollRepository;
import richardlab21g01project2.utils.entities.Scroll;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
@Service
public class ScrollService {
    private static final Logger logger = LoggerFactory.getLogger(ScrollService.class);
    @Autowired
    private ScrollRepository scrollRepository;
    public List<Scroll> getAllScrolls() {
        return scrollRepository.findAllScrolls();
    }
    public void saveScroll(String name, MultipartFile file) throws IOException {
        Scroll scroll = new Scroll();
        scroll.setName(name);
        scroll.setScrollId(UUID.randomUUID());
        scroll.setBinaryFileName(file.getOriginalFilename());
        scroll.setBinaryFileData(file.getBytes());
        scrollRepository.save(scroll);
        logger.info("Scroll saved: " + scroll.getName());
    }
}

