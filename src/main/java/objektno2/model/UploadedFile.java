package objektno2.model;

import jakarta.persistence.*;
import java.io.File;

@Entity
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uploaded_file_seq")
    private Long id;

    private String filename;

    @Transient
    private File file;

    public UploadedFile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }
}