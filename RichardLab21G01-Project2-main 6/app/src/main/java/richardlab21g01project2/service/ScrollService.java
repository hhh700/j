package richardlab21g01project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import richardlab21g01project2.utils.repositories.ScrollRepository;
import richardlab21g01project2.utils.entities.*;
import java.io.IOException;

@Service
public class ScrollService {
    @Autowired
    private ScrollRepository scrollRepository;

    public void saveScroll(String name, MultipartFile file) throws IOException {
        Scroll scroll = new Scroll();
        scroll.setName(name);
        scroll.setBinaryFileName(file.getOriginalFilename());
        scroll.setBinaryFileData(file.getBytes());
        // scrollRepository.save(scroll);
    }
}
