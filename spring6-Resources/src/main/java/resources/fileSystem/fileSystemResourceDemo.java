package resources.fileSystem;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedReader;
import java.io.FileReader;

public class fileSystemResourceDemo {
    public static void main(String[] args) {
        readFileSystemResource("D:\\IDEA_Java\\learning_spring6\\pom.xml");
    }
    
    public static void readFileSystemResource(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        try (BufferedReader reader=new BufferedReader(
                new FileReader(fileSystemResource.getFile())// getFile()方法返回File对象
        )){
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
