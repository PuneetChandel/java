/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK_QUEUE;

/**
 *
 * @author pune7087
 */
public class Test {
    
   public static void main(String args[])
   {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        
        System.out.println("s.pop "+ s.pop().data);
        System.out.println("s.pop "+ s.pop().data);
        
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        
        System.out.println("q.remove() "+ q.remove().data);
        System.out.println("q.remove() "+ q.remove().data);
        
        
        StackWithMin sm = new StackWithMin();
        sm.push(20);
        sm.push(10);
        sm.push(30);
        sm.push(35);
        
                System.out.println("sm.min() "+ sm.min());

        sm.push(7);
  System.out.println("sm.min() "+ sm.min());

   }
   
   
}
