package DepartmentClasses;
import UtilityClasses.*;
import java.util.*;
import java.io.*;
public class Research extends Employee {
    String topic;
    public Research(){
        super();
    }
    Research(String name, int age, String topic,String empcode,int status) {
        super(name,age,empcode,status);
        this.topic = topic;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nTopic of Research" + this.topic + "\n");
    }
    public void getEmployeesData(ArrayList<Research> employeeList,String code){
        try{
                    String intValue=code.substring(2, 5);                                
                try{
                    Integer.valueOf(intValue);                                  
                    System.out.println(employeeList.get(Integer.valueOf(intValue)));
                } 
                catch(NumberFormatException e){
                    if(employeeList.get(Integer.valueOf(intValue)).status==1){
                        System.out.println(employeeList.get(Integer.valueOf(intValue)));
                        }
                        else{
                            System.out.println("\nThis employee does not work any more with us");
                             System.out.println(employeeList.get(Integer.valueOf(intValue)));
                        }
                }
                catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                catch (Exception g) {
                    System.out.println(g);
                }
            }catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
    }
    public void addNewEmployees(ArrayList<Research> employeeList ,String name,int age,String topic){
        String empcode;                                               
        if(employeeList.size()<10){empcode="er00"+String.valueOf(employeeList.size());}
        else{empcode="er0" +String.valueOf(employeeList.size());}                                                   
        Research newDesignEmployee = new Research(name, age, topic,empcode,status);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<Research> employeeList,int field,String intValue){
    Scanner sc=new Scanner(System.in);
    if (field == 1) {
            System.out.println("\nEnter new field");
            String newname;            
            newname = sc.nextLine();
            employeeList.get(Integer.valueOf(intValue)).name = newname;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        } else if (field == 2) {
            int newage;            
            newage = sc.nextInt();
            sc.nextLine();
            System.out.println("\nEnter new field");
            employeeList.get(Integer.valueOf(intValue)).age = newage;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        } else if (field == 3) {
            String newtopic;
            System.out.println("\nEnter new field");
            newtopic = sc.nextLine();
            employeeList.get(Integer.valueOf(intValue)).topic = newtopic;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        }

}
public void removeEmployeesData(ArrayList<Research> employeeList,String code){
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

public void getDataFromFiles(String filename,ArrayList<Research> employeeList){
    try{
        FileInputStream fis = new FileInputStream(filename);
            AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                 boolean co = true;
                 try {
                    while (co) {
                 Research obj = ((Research) input.readObject());
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

    public void sort1EmployeesData(ArrayList<Research> employeeList){        
        ArrayList<Research> al=new ArrayList<>();    
    for(int i=0;i<employeeList.size();i++){
        al.add(employeeList.get(i));
    }
        Collections.sort(al,new Comparator<Research>(){
        public int compare(Research e1,Research e2){
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