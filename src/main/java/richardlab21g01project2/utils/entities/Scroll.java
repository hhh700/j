package richardlab21g01project2.utils.entities;

import jakarta.persistence.*;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Scroll {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String scrollId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String binaryFileName;

    @Lob
    @Column(nullable = false)
    private byte[] binaryFileData;

    // Getters and Setters
    public String getScrollId() {
        return scrollId;
    }

    public void setScrollId(UUID scrollId) {
        this.scrollId = scrollId.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBinaryFileName() {
        return binaryFileName;
    }

    public void setBinaryFileName(String binaryFileName) {
        this.binaryFileName = binaryFileName;
    }

    public byte[] getBinaryFileData() {
        return binaryFileData;
    }

    public void setBinaryFileData(byte[] binaryFileData) {
        this.binaryFileData = binaryFileData;
    }
}
