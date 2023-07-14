package DepartmentClasses;
import java.util.*;
import java.io.*;

public class Employee implements Serializable {
    public String empcode;
    public String name;
    public int age;
    public int status=1;
    public Employee(){};
    public Employee(String name, int age,String empcode,int status) {
        this.name = name;
        this.age = age;
        this.empcode=empcode;
        this.status=status;
        
    }
}