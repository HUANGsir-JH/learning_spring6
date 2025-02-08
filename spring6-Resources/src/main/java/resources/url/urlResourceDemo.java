package resources.url;

import org.springframework.core.io.UrlResource;

public class urlResourceDemo {
    public static void main(String[] args) {
        // 前缀http://
        readUrlResource("http://www.baidu.com");
        System.out.println("===================================");
        // 前缀file:
        readUrlResource("file:pom.xml");
    }
    
    public static void readUrlResource(String path) {
        try {
            UrlResource resource = new UrlResource(path);
            System.out.println(resource.getFilename());
            System.out.println(resource.contentLength());// 获取资源长度
            System.out.println(resource.getURL()); // 获取资源URL
            System.out.println(resource.isOpen());
            System.out.println(resource.isReadable());
            System.out.println(resource.getDescription()); // 获取资源描述
            System.out.println(resource.getInputStream().read()); // 读取资源内容
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
