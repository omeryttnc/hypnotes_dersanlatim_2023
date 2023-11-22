package tasks.group2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task5 {
    @Test
    public void Lambda(){
        List<String> names = List.of("kesif","plus","selenium","dersleri");
        // butun kelimeler s harfi iceriyor mu
        //Structural
        boolean flag=true;
        for (String name:names) {
            if (!name.contains("s")){
                flag=false;
            }
        }
        Assert.assertTrue(flag);

        //Functional
        boolean flagLambda=names.stream().allMatch(t->t.contains("s"));
        Assert.assertTrue(flagLambda);



        // her hangi biri p iceriyor mu
        //Structural
        boolean flag2=false;
        for (String name:names) {
            if (name.contains("p")){
                flag2=true;
            }
        }
        Assert.assertTrue(flag2);

        //Functional
        boolean flagLambda2=names.stream().anyMatch(t->t.contains("p"));
        Assert.assertTrue(flagLambda2);



        // hic biri x icermiyor mu
        //Structural
        boolean flag3=true;
        for (String name:names) {
            if (name.contains("x")){
                flag3=false;
                break;
            }
        }
        Assert.assertTrue(flag3);

        //Functional
        boolean flagLambda3=names.stream().noneMatch(t->t.contains("x"));
        Assert.assertTrue(flagLambda3);



        Map<String, Integer> fruit = new HashMap<>();
        fruit.put("elma", 24);
        fruit.put("armut", 12);
        fruit.put("ayva", 36);
        fruit.put("kiraz", 60);
        fruit.put("muz", 5);
        fruit.put("cilek", 2);

        // butun fiyatlar 0 dan buyuk
        //Structural
        boolean flagMap1=true;
        for (int value:fruit.values()) {
            if (value<=0){
                flagMap1=false;
            }
        }
        Assert.assertTrue(flagMap1);

        //Functional
        boolean flaqMapLambda1=fruit.values().stream().allMatch(t->t>0);
        Assert.assertTrue(flaqMapLambda1);



        // ama hicbiri 100 den buyuk degil
        //Structural
        boolean flagMap2=true;
        for (int value:fruit.values()) {
            if (value>100){
                flagMap2=false;
            }
        }
        Assert.assertTrue(flagMap2);

        //Functional
        boolean flagMapLambda2=fruit.values().stream().noneMatch(t->t>100);
        Assert.assertTrue(flagMapLambda2);



        // ve herhangi biri 30 dan buyuk mu
        //Structural
        boolean flagMap3=false;
        for (int value:fruit.values()) {
            if (value>30){
                flagMap3=true;
            }
        }
        Assert.assertTrue(flagMap3);

        //Functional
        boolean flagMapLAmbda3=fruit.values().stream().anyMatch(t->t>30);
        Assert.assertTrue(flagMapLAmbda3);
    }

}
