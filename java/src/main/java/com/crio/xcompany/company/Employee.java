package com.crio.xcompany.company;

import java.util.ArrayList;  //Self-explanation
import java.util.Collection;
import java.util.HashMap;  //Self-explanation
import java.util.List;  //Self-explanation
import java.util.Map;  //Self-explanation
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    
    private String name;
    private Gender gender;

    private String managerName;
    private List<String> reportees;
    
    //private Map<String, List<Employee>> managerMap;   //ManagerName directReportees
    

    public Employee(String name, Gender gender) 
    {
        //Self implementation
        this.name = name;
        this.gender = gender;

        this.managerName = null;
        this.reportees = new ArrayList<>();
        //this.managerMap = new HashMap<String, List<Employee>>();
    }

    // public Employee() 
    // {
       
    // }

  

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) 
    {
        this.managerName = managerName;
    }

    public List<String> getReportees() 
    {
        return reportees;
    }

    public void addReportee(String employeeName) 
    {
        this.reportees.add(employeeName);
    }

    public void removeReportee(String employeeName) 
    {
        this.reportees.remove(employeeName);
    }
    
    //over over
    // public Map<String, List<Employee>> getMap() 
    // {
    //     return managerMap;
    // }

    // public void setMap(Map<String, List<Employee>> map)
    // {
    //     this.managerMap = map;
    // }

    // public List<Employee> getAllDirectReportees(String managerName)
    // {
    //     return managerMap.get(managerName);
    // }

    // public String getManager(String employeeName)
    // {
    //     for (Map.Entry<String, List<Employee>> entry : managerMap.entrySet()){
    //         String managerName = entry.getKey();
    //         List<Employee> employees = entry.getValue();
    //         for (Employee e : employees) 
    //         {
    //             if (e.getName().equals(employeeName))
    //             {
    //                 return managerName;
    //             }
    //         }
    //     }

    //     return null;
    // }

    // public void setEmployee(String managerName, Employee e)
    // {
    //     List<Employee> lst = new ArrayList<>();
    //     lst.add(e);
    //     managerMap.put(managerName, lst);
    // }




    // // TODO: CRIO_TASK_MODULE_XCOMPANY
    // // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // // This will ensure that the project can be compiled successfully.
    
    // //Self implementation method: 4(a)
    // public void assignManager(Employee employee)
    // {
    //     List<Employee> reportees = new ArrayList<>();
    //     reportees.add(employee);
    //     managerMap.put(employee.getName(), reportees);
    // }

    // //Self implementation: 5 (a)
    // List<Employee> getDirectReports()
    // {
    //     return managerMap.get(name);
    // }

    // //Self implementation: 6 (a)
    // List<Employee> getTeamMates()
    // {
        
    //     // String managerName = getManager(name);

    //     // List<Employee> lst = getAllDirectReportees(managerName);

    //     return null;
        
    // }
    
    // // List<Employee> getTeamMates()
    // // {
    // //     //Employee reportee = new Employee(name, gender);
    // //     //Employee reportee = new Employee();
    // //     //find manager of above reportee
    // //     String managerName = "";
    // //     Employee firstReq = null;
    // //     Optional<Map.Entry<String, List<Employee>>> entryOptional = getMap().entrySet().stream().filter(entry -> entry.getValue().contains(reportee)).findFirst();
    // //     if(entryOptional.isPresent())
    // //     {
    // //         Map.Entry<String, List<Employee>> entry = entryOptional.get(); 
    // //         managerName = entry.getKey();

    // //         Company c = new Company();
    // //         Employee e = c.getEmployee(managerName);
    // //         firstReq = new Employee(managerName, e.getGender());
    // //     }
            
    // //     List<Employee> secondReq = getDirectReports();
    // //     secondReq.add(firstReq);

    // //     return secondReq;
    // // }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}

