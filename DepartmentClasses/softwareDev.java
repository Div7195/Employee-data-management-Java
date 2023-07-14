package DepartmentClasses;
import UtilityClasses.*;
import java.util.*;
import java.io.*;
public class softwareDev extends Employee {
    String SoftwareRole;
    public softwareDev(){
        super();
    }
    softwareDev(String name, int age, String SoftwareRole,String empcode,int status) {
        super(name,age,empcode,status);
        this.SoftwareRole = SoftwareRole;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nSoftware Role-" + this.SoftwareRole + "\n");
    }
    public void getEmployeesData(ArrayList<softwareDev> employeeList,String code){
        try{
                    String intValue=code.substring(2, 5);                                
                try{
                    Integer.valueOf(intValue);                                  
                    if(employeeList.get(Integer.valueOf(intValue)).status==1){
                        System.out.println(employeeList.get(Integer.valueOf(intValue)));
                        }
                        else{
                            System.out.println("\nThis employee does not work any more with us");
                             System.out.println(employeeList.get(Integer.valueOf(intValue)));
                        }
                } 
                catch(NumberFormatException e){
                    System.out.println("\n**The entered code is of invalid format");
                }
                catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                catch (Exception g) {
                    System.out.println(g);
                }
            }catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
    }
    public void addNewEmployees(ArrayList<softwareDev> employeeList ,String name,int age,String softwareRole){
        String empcode;                                               
        if(employeeList.size()<10){empcode="es00"+String.valueOf(employeeList.size());}
        else{empcode="es0" +String.valueOf(employeeList.size());}                                                   
        softwareDev newDesignEmployee = new softwareDev(name, age, softwareRole,empcode,status);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<softwareDev> employeeList,int field,String intValue){
    Scanner sc=new Scanner(System.in);
    if (field == 1) {
    String newname;
    System.out.println("\nEnter new field");
        
    newname = sc.nextLine();
    employeeList.get(Integer.valueOf(intValue)).name = newname;
    System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 2) {
    int newage;
    System.out.println("\nEnter new field");
    newage = sc.nextInt();
    sc.nextLine();
    employeeList.get(Integer.valueOf(intValue)).age = newage;
    System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 3) {
    String newSoftwarerole;
        
    newSoftwarerole = sc.nextLine();
    employeeList.get(Integer.valueOf(intValue)).SoftwareRole = newSoftwarerole;
    System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }

}
public void removeEmployeesData(ArrayList<softwareDev> employeeList,String code){
    try{
                String intValue=code.substring(2, 5);                                
            try{
                Integer.valueOf(intValue);                                  
                //System.out.println(employeeList.get(Integer.valueOf(intValue)));
                employeeList.get(Integer.valueOf(intValue)).status=0;
               
                 System.out.println("\nEmployee is removed successfully!");
            } 
            catch(NumberFormatException e){
                System.out.println("\n**The entered code is of invalid format");
            }
            catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
            catch (Exception g) {
                System.out.println(g);
            }
        }catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
}
public void getDataFromFiles(String filename,ArrayList<softwareDev> employeeList){
    try{
        FileInputStream fis = new FileInputStream(filename);
            AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                 boolean co = true;
                 try {
                    while (co) {
                 softwareDev obj = ((softwareDev) input.readObject());
                      if (obj != null) {
                         employeeList.add(obj);
                    } else {
                     co = false;
    
                  }
             }
            } catch (Exception g) {
                
            }
         input.close();
      }catch(Exception e){System.out.println(e);}
    
    }
    public void sort1EmployeesData(ArrayList<softwareDev> employeeList){        
        ArrayList<softwareDev> al=new ArrayList<>();    
    for(int i=0;i<employeeList.size();i++){
        al.add(employeeList.get(i));
    }
        Collections.sort(al,new Comparator<softwareDev>(){
        public int compare(softwareDev e1,softwareDev e2){
        return (e1.name).compareTo(e2.name);
        }
        });
        for(int i=0;i<al.size();i++){
        if(al.get(i).status==1){
        System.out.println(al.get(i));
        }
        else{System.out.println("\nThis employee does not work any more anymore with us");
        System.out.println(al.get(i));
        }
                           
        }
    }
}