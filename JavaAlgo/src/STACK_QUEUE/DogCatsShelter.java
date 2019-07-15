/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK_QUEUE;
import java.util.Date;
import java.util.LinkedList;
/**
 *
 * @author pune7087
 */
public class DogCatsShelter {
 
    LinkedList<Animal> dogs= new LinkedList<Animal>();
    LinkedList<Animal> cats= new LinkedList<Animal>();
    
    public void addAnimal(String type)
    {
        if(type=="dog")
            dogs.add(new Animal("dog",new Date()));
        else
            dogs.add(new Animal("cat",new Date()));
    }
    
    
    
    public Animal getAny()
    {
        if(dogs.peek().date.compareTo(cats.peek().date) > 1)
            return cats.poll();
        else
            return dogs.poll();
    }
    
            
    public Animal getDog()
    {
        return dogs.poll();
    }
    
    public Animal getCat()
    {
        return cats.poll();
    }
    
    
}

class Animal
{
    String type;
    Date date;
    
    Animal(String type, Date date)
    {
        this.type=type;
        this.date=date;
    }
}