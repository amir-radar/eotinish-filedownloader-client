package workWithZipFile;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CleanZipFile {
    public static final String PATH_FOR_ARCHIVE = "C:\\Users\\w2\\documents\\java_education_tasks\\clean_docx\\123.zip";
    public static final String PATH_FILE_FROM_ARCHIVE = "C:\\Users\\w2\\documents\\java_education_tasks\\clean_docx\\new_document.xml";
    public static final String PATH_FOR_CLEAN_XML = "C:\\Users\\w2\\documents\\java_education_tasks\\clean_docx\\clean_document.xml";


    public boolean modifyTextFileInZip() throws IOException {
        String dirty = readFile(PATH_FILE_FROM_ARCHIVE);
        String clean = cleanXmlFromZip(dirty);

        return copyCleanXmlToArchive(clean);
    }


    private boolean copyCleanXmlToArchive(String clean) throws IOException {
        Path path = Paths.get(PATH_FOR_ARCHIVE);
        try (FileSystem fs = FileSystems.newFileSystem(path, null)) {
            Path fileIntoZip = fs.getPath("/word/document.xml");
            try (Writer writer = Files.newBufferedWriter(fileIntoZip, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                writer.write(clean);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public String cleanXmlFromZip(String xml) {
        return xml.replaceAll("(</w:t>)([.\\S\\s:]{87,133})(<w:t>)", "");
    }


    private String readFile(String path) throws IOException {
        FileReader input = new FileReader(path);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(input)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        return builder.toString();
    }


    private void deleteFileFromArchive(String archivePath) throws IOException {
        try (FileSystem fs = FileSystems.newFileSystem(Paths.get(archivePath), null)) {
            Path source = fs.getPath("/word/document.xml");
            Files.delete(source);
            System.out.println(source.toAbsolutePath());
        }
    }
}
