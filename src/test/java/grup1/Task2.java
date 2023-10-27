package grup1;

import org.junit.Test;

import java.util.List;

public class Task2 {
    /*
    List<String> names = List.of("Kesif","Plus","Selenium","Dersleri");
print words only if they have equal or less than 5 letters
     */

    List<String> names = List.of("Kesif","Plus","Selenium","Dersleri");
    @Test
    public void structural1(){
        for (int i = 1; i < names.size()+1; i++) {
            if (names.get(i-1).length()<=5){
                System.out.println("name "+i+" "+names.get(i-1));
            }
        }
    }

    @Test
    public void structural2(){
        for (String name:names) {
            if (name.length()<=5){
                System.out.println(name);
            }
        }
    }

    @Test
    public void functional1(){
        names.stream().filter(t->t.length()<=5).forEach(t-> System.out.println(t));
    }

    @Test
    public void functional2(){
        names.stream().filter(t->t.length()<=5).forEach(System.out::println);
    }


}
