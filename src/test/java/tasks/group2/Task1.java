package tasks.group2;

import org.junit.Test;

import java.util.List;

public class Task1 {

    /*
    List<String> names = List.of("Kesif","Plus","Selenium","Dersleri");
print list into your console as STRUCTURAL PROGRAMING AND
FUNCTIONAL PROGRAMING
     */
    List<String> names = List.of("Kesif","Plus","Selenium","Dersleri");

    @Test
   public void structural1(){
        for (int i = 1; i < names.size()+1; i++) {
            System.out.println("name "+i+" "+names.get(i-1));
        }
   }

   @Test
   public void structural2(){
       for (String name:names) {
           System.out.println(name);
       }
   }



   //(x*y)=x+y+52
    // (parameter)  -> functıon



   @Test
   public void functional(){
        names.forEach(t-> System.out.println(t));
   }
}
