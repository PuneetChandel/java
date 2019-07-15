package PRGCREEK;

import java.util.Arrays;

/**
 *
 * @author pune7087
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {
 
    public static void main(String args[])
    {
        ArrayList<Employee> ar = new ArrayList();
        ar.add(new Employee("Puneet", 70));
        ar.add(new Employee("sam",100));
        ar.add(new Employee("kam",30));
        ar.add(new Employee("xyz",50));
        ar.add(new Employee("abc",110));
        
        
        //EmpComp comp= new EmpComp();
        Collections.sort(ar,new Comparator<Employee>(){
             public int compare(Employee e1, Employee e2)
                {
                    return e1.salary - e2.salary;
                }
        });
        
        for(Employee x : ar)
        {
            System.out.print(" " + x.name + " " + x.salary + " : ");
        }
    }
    
}

class Employee
{
    String name;
    int salary;
    
    Employee(String name,int salary )
    {
        this.name=name;
        this.salary=salary;
    }
}

class EmpComp implements Comparator<Employee>
{
    public int compare(Employee e1, Employee e2)
    {
        return e1.salary - e2.salary;
    }
}