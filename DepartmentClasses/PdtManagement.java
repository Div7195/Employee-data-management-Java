package DepartmentClasses;
import java.util.*;
import java.io.*;
import UtilityClasses.*;
public class PdtManagement extends Employee {
    String product;
    public PdtManagement(){
        super();
    }
    PdtManagement(String name, int age, String product,String empcode,int status) {
        super(name,age,empcode,status);
        this.product = product;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nProduct Managing-" + this.product + "\n");
    }
    public void getEmployeesData(ArrayList<PdtManagement> employeeList,String code){
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
    public void addNewEmployees(ArrayList<PdtManagement> employeeList ,String name,int age,String product){
        String empcode;                                               
        if(employeeList.size()<10){empcode="ep00"+String.valueOf(employeeList.size());}
        else{empcode="ep0" +String.valueOf(employeeList.size());}                                                   
        PdtManagement newDesignEmployee = new PdtManagement(name, age, product,empcode,status);
        employeeList.add(newDesignEmployee);
}   
public void modifyEmployeeData(ArrayList<PdtManagement> employeeList,int field,String intValue){
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
        String newproduct;
    System.out.println("\nEnter new field");
        newproduct = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).product = newproduct;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }
    

}

public void removeEmployeesData(ArrayList<PdtManagement> employeeList,String code){
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

public void getDataFromFiles(String filename,ArrayList<PdtManagement> employeeList){
    try{
        FileInputStream fis = new FileInputStream(filename);
            AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                 boolean co = true;
                 try {
                    while (co) {
                 PdtManagement obj = ((PdtManagement) input.readObject());
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
    public void sort1EmployeesData(ArrayList<PdtManagement> employeeList){        
        ArrayList<PdtManagement> al=new ArrayList<>();    
    for(int i=0;i<employeeList.size();i++){
        al.add(employeeList.get(i));
    }
        Collections.sort(al,new Comparator<PdtManagement>(){
        public int compare(PdtManagement e1,PdtManagement e2){
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