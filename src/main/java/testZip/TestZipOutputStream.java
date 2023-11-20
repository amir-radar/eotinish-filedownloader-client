package testZip;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestZipOutputStream {
    public static void main(String[] args) {
//        String pathToDoc = "C:\\Users\\Amirzhan\\Desktop\\test.xml";
//        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output.zip"));
//             FileInputStream fileInputStream = new FileInputStream(pathToDoc)){
//            ZipEntry entry = new ZipEntry("test1.xml");
//            zipOutputStream.putNextEntry(entry);
//            byte[] bytes = new byte[fileInputStream.available()];
//            fileInputStream.read(bytes);
//            zipOutputStream.write(bytes);
//            zipOutputStream.closeEntry();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        String pathToZip = "output.zip";
        String docName = "document.xml";
        String newDoc = "newDoc.xml";
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathToZip))){
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry.getName().equals(docName)){
                System.out.println(entry.getName());
                entry = zipInputStream.getNextEntry();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(newDoc);
            //fileOutputStream.write(zipInputStream.read(entry));
            fileOutputStream.flush();
            zipInputStream.closeEntry();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}