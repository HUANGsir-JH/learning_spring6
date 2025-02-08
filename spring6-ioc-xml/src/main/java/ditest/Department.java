package ditest;

import java.util.ArrayList;

public class Department {
    
    private String dname;
    private ArrayList<Emp> emps = new ArrayList<>();
    
    public Department() {
    }
    
    public void setDname(String dname) {
        this.dname = dname;
    }
    
    public String getDname() {
        return dname;
    }
    
    public ArrayList<Emp> getEmps() {
        return emps;
    }
    
    public void setEmps(ArrayList<Emp> emps) {
        this.emps = emps;
    }
    
    public  void show() {
        System.out.println("dname: " + dname + ", emps: " + emps);
    }
}
