package ditest;

import java.util.ArrayList;

public class Emp {
    private String ename;
    private Integer age;
    private Department department=new Department();
    
    public Emp() {
    }
    
    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", department=" + department.getDname() +
                '}';
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getEname() {
        return ename;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public Department getDepartment() {
        return department;
    }
}
