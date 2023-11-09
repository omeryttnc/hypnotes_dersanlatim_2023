package tasks;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class kontrol {
    Map<String, Integer> map = new HashMap<>();

    @Test
    public void map_count_collect() {
        map.put("elma", 24);
        map.put("armut", 12);
        map.put("ayva", 36);
        map.put("kiraz", 60);
        map.put("muz", 5);
        map.put("cilek", 2);
        // ---------------------------- map ---------------------------------
        List<WebElement> webElementList = new ArrayList<>();
        // webelementlerin ici bos ama dolu oldugunu varsayin her webelementin value attribute nu alin
        //Structural
        for (int i = 0; i < webElementList.size(); i++) {
            System.out.println("attribute " + i + " = " + webElementList.get(i).getAttribute(""));
            System.out.println("value " + i + " = " + webElementList.get(i).getCssValue(""));
        }

//        Functional
        webElementList.forEach(t -> System.out.println("t.getAttribute = " + t.getAttribute("")));
        webElementList.forEach(t -> System.out.println("t.getCssValue = " + t.getCssValue("")));


        // urunlerin fiyatlarini 5 ile carpin
        //Structural
        for (int value : map.values()) {
            System.out.println("value*5 = " + value * 5);
        }

        //Functional
        map.values().forEach(t -> System.out.println("t*5 = " + t * 5));


        //----------------------------- count -------------------------------
        List<String> names = List.of("kesif", "plus", "selenium", "dersleri");
        // name listesinin icinde kac tane String "le" iceriyor
        //Structural
        int i = 0;
        for (String name : names) {
            if (name.contains("le")) i++;
        }
        System.out.println("i = " + i);

//        Functunal
        long count = names.stream().filter(t -> t.contains("le")).count();
        System.out.println("count = " + count);


        // map icerisinde kac tane urun 30 dan daha pahali
//        Structural
        int j = 0;
        for (int value : map.values()) {
            if (value > 30) {
                j++;
            }
        }
        System.out.println("j = " + j);

//        Functional
        long bigValue = map.values().stream().filter(t -> t > 30).count();
        System.out.println("bigValue = " + bigValue);



        // --------------------------- collect -------------------------------
        // names listesin de "l" bulunduran kelimeleri yeni bir listeye ekleyin
//        Structural
        List<String>lKeys=new ArrayList<>();
        for (String name:names) {
            if (name.contains("l")){
                lKeys.add(name);
            }
        }
        System.out.println("lKeys = " + lKeys);

//        Funcional
        List<String>lKeysLambda=names.stream().filter(t->t.contains("l")).collect( Collectors.toList());
        System.out.println("lKeysLambda = " + lKeysLambda);



        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir listeye ekleyin
//        Structural
        List<String> pahaliUrunler=new ArrayList<>();
        for (Map.Entry<String,Integer>pairs: map.entrySet()) {
            if (pairs.getValue()>30){
                pahaliUrunler.add(pairs.getKey());
            }
        }
        System.out.println("pahaliUrunler = " + pahaliUrunler);

//        Functional
        List<String>pahaliUrunlerLambda=map.entrySet().stream().filter(t->t.getValue()>30).map(t->t.getKey()).collect(Collectors.toList());
        System.out.println("pahaliUrunlerLambda = " + pahaliUrunlerLambda);



        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir Map e ekleyin
//        Structural
        Map<String,Integer> yeniMap=new HashMap<>();
        for (Map.Entry<String, Integer>pairs:map.entrySet()) {
            if (pairs.getValue()>30){
                yeniMap.put(pairs.getKey(),pairs.getValue());
            }
        }
        System.out.println("yeniMap = " + yeniMap);

//        Functional
        Map<String,Integer>yeniMapLambda=map.entrySet().stream().filter(t->t.getValue()>30).collect(Collectors.toMap(t->t.getKey(),t->t.getValue()));
        System.out.println("yeniMapLambda = " + yeniMapLambda);
    }
}
