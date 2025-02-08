package resources.classpath;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

public class classPathResourceDemo {
    
    public static void main(String[] args) {
        readClassPathResource("test.txt");
    }
    
    public static void readClassPathResource(String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);
        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.exists());
        System.out.println(classPathResource.getDescription());
        try(InputStream in = classPathResource.getInputStream()){
            byte[] bytes=new byte[1024];
            int len;
            while((len=in.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("===================================");
        try(BufferedReader reader=new BufferedReader(
                new FileReader(classPathResource.getFile())// getFile()方法返回File对象
        )){
            System.out.println(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
