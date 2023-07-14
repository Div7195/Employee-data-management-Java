package DepartmentClasses;
import java.util.*;
import UtilityClasses.*;
import java.io.*;
public class service implements Serializable{
    String customerID;
    public String Enterprise;
    String softwaresPurchased;
    int billAmount;
    public service(){};
    public service(String customerID,String Enterprise,String softwarsPurchased,int billAmount){
        this.Enterprise=Enterprise;this.customerID=customerID;this.billAmount=billAmount;this.softwaresPurchased=softwarsPurchased;
    }
    public String toString(){
        return("\nCustomer ID-"+this.customerID+"\nEnterprise name-"+this.Enterprise+"\nSoftwares Purchased-"+this.softwaresPurchased+"\nBill Amount-"+this.billAmount);
    }
    public void getBillData(ArrayList<service> serviceList,String code){
        try{
                    String intValue=code.substring(1, 4);                                
                try{
                    Integer.valueOf(intValue);                                  
                    System.out.println(serviceList.get(Integer.valueOf(intValue)));
                } 
                catch(NumberFormatException e){
                    System.out.println("\n**The entered id is of invalid format");
                }
                catch(IndexOutOfBoundsException h){System.out.println("\n**The entered id does not exist");}
                catch (Exception g) {
                    System.out.println(g);
                }
            }catch(Exception e){System.out.println("\n**The entered id is of invalid format");}
    }

    public void addNewBill(ArrayList<service> serviceList ,String Enterprise,String softwarsPurchased,int billAmount){
        String cid;                                               
        if(serviceList.size()<10){cid="c00"+String.valueOf(serviceList.size());}
        else{cid="c0" +String.valueOf(serviceList.size());}                                                   
        service newSericeBill = new service(cid, Enterprise, softwarsPurchased, billAmount);
        serviceList.add(newSericeBill);
}
public void getDataFromFiles(String filename,ArrayList<service> employeeList){
    try{
        FileInputStream fis = new FileInputStream(filename);
            AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                 boolean co = true;
                 try {
                    while (co) {
                 service obj = ((service) input.readObject());
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
}