package springIoCxml;

public class User {
    
    private String name;
    private Integer age;
    
    public User() {
        System.out.println("User non-arg-constructor...");
    }
    
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("User arg-constructor...");
    }
    
    public  void run() {
        System.out.println("run...");
    }
    
    public void show() {
        System.out.println("name: " + name + ", age: " + age);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
