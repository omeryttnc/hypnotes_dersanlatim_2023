package tasks.group1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task5 {
    @Test
    public void matches() {
        List<String> names = List.of("kesif", "plus", "selenium", "dersleri");

        // butun kelimeler s harfi iceriyor mu
        //Structural
        boolean flaq = true;
        for (String name : names) {
            if (!name.contains("s")) {
                flaq = false;
            }
        }
        Assert.assertTrue(flaq);

        //Functional
        boolean flaqLambda = names.stream().allMatch(t -> t.contains("s"));
        Assert.assertTrue(flaqLambda);



        // her hangi biri p iceriyor mu
        //Structural
        boolean flaq2 = false;
        for (String name : names) {
            if (name.contains("p")) {
                flaq2 = true;
            }
        }
        Assert.assertTrue(flaq2);

        //Functional
        boolean flaqLambda2 = names.stream().anyMatch(t -> t.contains("p"));
        Assert.assertTrue(flaqLambda2);



        // hic biri x icermiyor mu
        //Structural 1
        boolean flaq3 = false;
        for (String name : names) {
            if (name.contains("x")) {
                flaq3 = true;
            }
        }
        Assert.assertFalse(flaq3);

        //Structural 2
        boolean flaq4 = true;
        for (String name : names) {
            if (name.contains("x")) {
                flaq4 = false;
            }
        }
        Assert.assertTrue(flaq4);

        //Functional
        boolean flaqLAmbda3 = names.stream().noneMatch(t -> t.contains("x"));
        Assert.assertTrue(flaqLAmbda3);



        Map<String, Integer> map = new HashMap<>();
        map.put("elma", 24);
        map.put("armut", 12);
        map.put("ayva", 36);
        map.put("kiraz", 60);
        map.put("muz", 5);
        map.put("cilek", 2);

        // butun fiyatlar 0 dan buyuk mü
        //Structural
        boolean flaqMap = true;
        for (int value : map.values()) {
            if (value <= 0) {
                flaqMap = false;
            }
        }
        Assert.assertTrue(flaqMap);

        //Functional
        boolean flaqMapLambda = map.values().stream().allMatch(t -> t > 0);
        Assert.assertTrue(flaqMapLambda);



        // ama hicbiri 100 den buyuk degil
        //Structural
        boolean flaqMap2 = true;
        for (int value : map.values()) {
            if (value > 100) {
                flaqMap2 = false;
            }
        }
        Assert.assertTrue(flaqMap2);

        //Functional
        boolean flaqMAbLambda2 = map.values().stream().allMatch(t -> t <= 100);
        Assert.assertTrue(flaqMAbLambda2);



        // ve herhangi biri 30 dan buyuk mu
        //Structural
        boolean flaqMap3 = false;
        for (int value : map.values()) {
            if (value > 30) {
                flaqMap3 = true;
            }
        }
        Assert.assertTrue(flaqMap3);

        //Functional
        boolean flaqMapLambda3 = map.values().stream().anyMatch(t -> t > 30);
        Assert.assertTrue(flaqMapLambda3);
    }
}