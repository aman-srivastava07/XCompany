package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Company
{
    private String companyName;
    private Employee founder;
    private Map<String,Employee> employeeBook;

       
    

    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String,Employee>();
        employeeBook.put(founder.getName(), founder);

    }

    public Company()
    {

    }

   

    public static Company create(String companyName, Employee founder){
        return new Company(companyName,founder);
    } 


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.

    //Self implementation: Method-01
    public void registerEmployee(String employeeName, Gender gender)
    {
        if(!employeeBook.containsKey(employeeName))
        {
            employeeBook.put(employeeName,new Employee(employeeName, gender));
        }
        //employeeBook.putIfAbsent(employee.getName(), employee);
    }
    
    //Self implementation: Method-02
    public Employee getEmployee(String employeeName)
    {
        return employeeBook.get(employeeName);
    }
    
    //Self implementation: Method-03
    public void deleteEmployee(String employeeName)
    {
        Employee employee = employeeBook.remove(employeeName);

        if(employee != null && employee.getManagerName() != null)
        {
            Employee manager = employeeBook.get(employee.getManagerName());
            if(manager != null)
            {
                manager.removeReportee(employeeName);
            }
        }

    //     List<Employee> allDirectReportees = getDirectReports(employeeName);

    //     String mangerName = e.ge


    //     // employeeBook.remove(employeeName);
    //     // return;

    //     //All direct reportess to Vijay
    //     Employee e = employeeBook.get(employeeName);
    //     List<Employee> lst = e.getAllDirectReportees(employeeName);
    //     String managerName = e.getManager(employeeName);
    //     assignManager(employeeName, managerName);
    //     Map<String, List<Employee>> map_ = e.getMap();
    //     map_.remove(employeeName);

        
        
        
        
    // //     List<Employee> lst = getDirectReports(employeeName);
    // //     if(lst != null || !(lst.isEmpty()))
    // //     {

    // //     //Manager of Vijay
    // //     Employee emp = new Employee();
    // //     Map<String, List<Employee>> map = emp.getMap();
    // //     String managerName = "";
    // //     Optional<Map.Entry<String, List<Employee>>> entryOptional = map.entrySet().stream().filter(entry -> entry.getValue().contains(employeeName)).findFirst();
    // //     if(entryOptional.isPresent())
    // //     {
    // //         Map.Entry<String, List<Employee>> entry = entryOptional.get(); 
    // //         managerName = entry.getKey();
    // //     }

    // //     //Assign Manager: as Manager Name for all reportees of Vijay
    // //     for(Employee e: lst)
    // //     {
    // //         assignManager(e.getName(), managerName);
    // //     }

    // //     //delete vijay finally now
    // //     employeeBook.remove(employeeName);
    // // }
    // //     return;

    }

    //Self implementation: 04 (b)
    public void assignManager(String employeeName, String managerName)
    {
        Employee employee = employeeBook.get(employeeName);
        Employee manager = employeeBook.get(managerName);

        if(employee != null && manager != null)
        {
            if(employee.getManagerName() != null)
            {
                Employee oldManager = employeeBook.get(employee.getManagerName());
                if(oldManager != null)
                {
                    oldManager.removeReportee(employeeName);
                }
            }

            employee.setManagerName(managerName);
            manager.addReportee(employeeName);
        }
        else 
        {
            System.out.println("Invalid employee or manager ID.");
        }

        // //Employee emp = new Employee(employeeName, null);
        // Employee e = employeeBook.get(employeeName);
        // // Map<String, List<Employee>> reporteesMap = new HashMap<String, List<Employee>>();
        // // List<Employee> reportees = new ArrayList<>();
        // // reportees.add(new Employee(employeeName, e.getGender()));
        // e.setEmployee(managerName, e);
        // // reporteesMap.put(managerName, reportees);
        // // e.setMap(reporteesMap);
    }

    //Self implementation: 05 (b)
    public List<Employee> getDirectReports(String managerName)
    {
        Employee manager = employeeBook.get(managerName);
        List<Employee> reporteesList = new ArrayList<>();
        if (manager != null) 
        {
            for (String reporteeName : manager.getReportees()) 
            {
                reporteesList.add(employeeBook.get(reporteeName));
            }
        }

        return reporteesList;
        // //Employee emp = new Employee(managerName, null);
        // //Employee emp = new Employee();
        // Employee e = employeeBook.get(managerName);
        // Map<String, List<Employee>> map =  e.getMap();
        // if(map.containsKey(managerName))
        //     return e.getAllDirectReportees(e.getName());
            
        // return null;
    }
    
    //Self implementation: 06 (b)
    public List<Employee> getTeamMates(String employeeName)
    {
        Employee employee = employeeBook.get(employeeName);
        List<Employee> teammates = new ArrayList<>();
        //teammates.add(employee);
        if(employee != null && employee.getManagerName()!=null)
        {
            Employee manager = employeeBook.get(employee.getManagerName());
            teammates.add(manager);
            for(String reporteeName: manager.getReportees())
            {
                if(!(reporteeName.equals(employeeName)))
                {
                    teammates.add(employeeBook.get(reporteeName));
                }

            }
        }
        
        teammates.add(employee);
        return teammates;
        // Employee employee = employeeBook.get(employeeName);

        // String managerName = employee.getManager(employeeName);
        // Employee e = employeeBook.get(managerName);
        
        // List<Employee> lst = employee.getAllDirectReportees(managerName);

        // lst.add(e);
        // return lst;
    }   
    // public List<Employee> getTeamMates2(String employeeName)
    // {
    //     Employee emp = new Employee();
       
    //     Map<String, List<Employee>> map = emp.getMap();
    //     String managerName = "";
    //     Employee firstReq = null;
    //     Optional<Map.Entry<String, List<Employee>>> entryOptional = map.entrySet().stream().filter(entry -> entry.getValue().contains(employeeName)).findFirst();
    //     if(entryOptional.isPresent())
    //     {
    //         Map.Entry<String, List<Employee>> entry = entryOptional.get(); 
    //         managerName = entry.getKey();
    //     }
    //     Employee e = getEmployee(managerName);
    //     //Employee getEmpDetails = new Employee(managerName, e.getGender());
    //     // List<Employee> reqOne = new ArrayList<>();
    //     // reqOne.add(getEmpDetails);
    //     List<Employee> reqTwo = getDirectReports(managerName);

    //     reqTwo.add(e);

    //     return reqTwo;
    // }

    //Self implementation: 07
    // private void findAllReporteesRecursive(String manager, List<List<Employee>> result, int level) 
    // {
    //     //Employee emp = new Employee();
    //     Employee emp = employeeBook.get(manager);
    //     Map<String, List<Employee>> managerToReporteesMap = emp.getMap();
        
    //     if (!managerToReporteesMap.containsKey(manager)) 
    //         return;

    //     List<Employee> directReportees = managerToReporteesMap.get(manager);
    //     if (directReportees.isEmpty()) 
    //         return;
    //     if (result.size() <= level) {
    //         result.add(new ArrayList<>());
    //     }
    //     result.get(level).addAll(directReportees);
    //     for (Employee reportee : directReportees) {
    //         findAllReporteesRecursive(reportee.getName(), result, level + 1);
    //     }
    // }

    public List<List<Employee>> getEmployeeHierarchy(String managerName)
    {
        //List<Employee> lst = getDirectReports(managerName);
        //List<Employee> lst = new ArrayList<>();

        List<List<Employee>> hierarchy = new ArrayList<>();

        for (Employee employee : employeeBook.values())
        {
            if(employee.getName().equals(managerName))
            {
                buildHierarchy(employee, 0, hierarchy);
                break;
            }
        }

        return hierarchy;
        //findAllReporteesRecursive(managerName, result, 0);
        //return result;
    }// 

    private void buildHierarchy(Employee employee, int level, List<List<Employee>> hierarchy) 
    {
        if (hierarchy.size() == level) 
        {
            hierarchy.add(new ArrayList<>());
        }

        hierarchy.get(level).add(employee);

        for (String reporteeName : employee.getReportees()) 
        {
            buildHierarchy(employeeBook.get(reporteeName), level + 1, hierarchy);
        }
    }
    
  


}
