package tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kontrol {
    @Test
    public void task5() {

        List<String> names = List.of("kesif", "plus", "selenium", "dersleri");

        // butun harfler s harfi iceriyor mu
        //Structural
        boolean flaq1 = true;
        for (String name : names) {
            if (!name.contains("s")) {
                flaq1 = false;
            }
        }
        Assert.assertTrue(flaq1);

        //Functional
        boolean flaqLambda1=names.stream().allMatch(t->t.contains("s"));
        Assert.assertTrue(flaqLambda1);



        // her hangi biri p iceriyor mu
        //Structural
        boolean flaq2=false;
        for (String name:names) {
            if (name.contains("p")){
                flaq2=true;
            }
        }
        Assert.assertTrue(flaq2);

        //Functional
        boolean flaqLambda2=names.stream().anyMatch(t->t.contains("p"));
        Assert.assertTrue(flaqLambda2);



        // hic biri x icermiyor mu
        //Structural
        boolean flaq3=true;
        for (String name:names) {
            if (name.contains("x")){
                flaq3=false;
            }
        }
        Assert.assertTrue(flaq3);

        //Functional
        boolean flaqLambda3=names.stream().noneMatch(t->t.contains("x"));
        Assert.assertTrue(flaqLambda3);



        Map<String, Integer> map = new HashMap<>();

        map.put("elma", 24);
        map.put("armut", 12);
        map.put("ayva", 36);
        map.put("kiraz", 60);
        map.put("muz", 5);
        map.put("cilek", 2);

        // butun fiyatlar 0 dan buyuk
        //Structural
        boolean flaqMap1=true;
        for (int value:map.values()) {
            if (value<=0){
                flaqMap1=false;
            }
        }
        Assert.assertTrue(flaqMap1);

        //Functional
       boolean flaqMapLambda1= map.values().stream().allMatch(t->t>0);
       Assert.assertTrue(flaqMapLambda1);

        // ama hicbiri 100 den buyuk degil
        // Structural
        boolean flaqMap2=true;
        for (int value: map.values()) {
            if (value>100){
                flaqMap2=false;
            }
        }
        Assert.assertTrue(flaqMap2);

        //Functional
        boolean flaqMapLambda2=map.values().stream().noneMatch(t->t>100);
        Assert.assertTrue(flaqMapLambda2);



        // ve herhangi biri 30 dan buyuk mu
        //Structural
        boolean flaqMap3=false;
        for (int value: map.values()) {
            if (value>30){
                flaqMap3=true;
            }
        }
        Assert.assertTrue(flaqMap3);

        //Functional
        boolean flaqMapLambda3=map.values().stream().anyMatch(t->t>30);
        Assert.assertTrue(flaqMapLambda3);
    }

}
