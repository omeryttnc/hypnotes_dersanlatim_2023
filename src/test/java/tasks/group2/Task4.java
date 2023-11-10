package tasks.group2;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
    Map<String,Integer>map=new HashMap<>();
    @Test
    public void map_count_collect() {
        map.put("elma", 24);
        map.put("armut", 12);
        map.put("ayva", 36);
        map.put("kiraz", 60);
        map.put("muz", 5);
        map.put("cilek", 2);

        //Lambdada en sonda bulunan ve arkasına metot eklenemeyen, elemanları işleyip bir sonuç üreten metotlara TERMİNAL OPERASYON metotları denir.
        //foreach(), collect(),reduce(), vb


        // ---------------------------- map ---------------------------------
        List<WebElement> webElementList = new ArrayList<>();
        // webelementlerin ici bos ama dolu oldugunu varsayin her webelementin value attribute nu alin
        //Structural
        for (WebElement element:webElementList) {
            element.getAttribute("");
            System.out.println("element.getCssValue(\"\") = " + element.getCssValue(""));
        }

        //Functional
        webElementList.forEach(t->t.getAttribute(""));
        webElementList.stream().forEach(t-> System.out.println("t.getCssValue(\"\") = " + t.getCssValue("")));



        // urunlerin fiyatlarini 5 ile carpin
        //Structural
        for (Map.Entry<String,Integer>pairs: map.entrySet()) {
            int carpim=pairs.getValue()*5;
            System.out.println("carpim = " + carpim);
        }

        //Structural
        for (int value: map.values()) {
            System.out.println("value*5 = " + value * 5);
        }
        for (String key:map.keySet()) {
            System.out.println("key = " + key);
        }

        //Functional
        map.values().forEach(t-> System.out.println("t*5 = " + t*5));
        map.values().stream().map(t->t*5).forEach(System.out::println);



        //----------------------------- count -------------------------------

        List<String> names = List.of("kesif","plus","selenium","dersleri");
        // name listesinin icinde kac tane String "le" iceriyor
        //Structural
        int total = 0;
        for (String name:names) {
            if (name.contains("le")){
                total++;
            }
        }
        System.out.println("total = " + total);

        //Functional
        long totalLambda=names.stream().filter(t->t.contains("le")).count();
        System.out.println("totalLambda = " + totalLambda);

        // map icerisinde kac tane urun 30 dan daha pahali
        //Structural
        int count=0;
        for (int value:map.values()) {
            if (value>30){
                count++;
            }
        }
        System.out.println("count = " + count);

        //Functional
        long countLambda=map.values().stream().filter(t->t>30).count();
        System.out.println("countLambda = " + countLambda);


        // --------------------------- collect -------------------------------
        // names listesin de "l" bulunduran kelimeleri yeni bir listeye ekleyin
        //Structural
        List<String>lName=new ArrayList<>();
        for (String name:names) {
            if (name.contains("l")){
                lName.add(name);
            }
        }
        System.out.println("lName = " + lName);

        //Functional
        List<String> lNameLambdda=names.stream().filter(t->t.contains("l")).collect(Collectors.toList());
        List<String> lNameLambdda2=names.stream().filter(t->t.contains("l")).toList();
        System.out.println("lNameLambdda = " + lNameLambdda);



        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir listeye ekleyin
        //Structural
        List<String> pahaliUrunler=new ArrayList<>();
        for (Map.Entry<String,Integer> pairs: map.entrySet()) {
            if(pairs.getValue()>30){
                pahaliUrunler.add(pairs.getKey());
            }
        }
        System.out.println("pahaliUrunler = " + pahaliUrunler);

        //Functional
        List<String> pahaliUrunlerLambda=map.entrySet().stream().filter(t->t.getValue()>30).map(t->t.getKey()).collect(Collectors.toList());
        List<String> pahaliUrunlerLambda2=map.entrySet().stream().filter(t->t.getValue()>30).map(Map.Entry::getKey).toList();
        System.out.println("pahaliUrunlerLambda = " + pahaliUrunlerLambda);



        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir Map e ekleyin
        //Structural
        Map<String,Integer> pahaliUrunlerMap=new HashMap<>();
        for (Map.Entry<String,Integer>pairs: map.entrySet()) {
            if (pairs.getValue()>30){
               pahaliUrunlerMap.put(pairs.getKey(),pairs.getValue());
            }
        }
        System.out.println("pahaliUrunlerMap = " + pahaliUrunlerMap);

        //Functional
        Map<String,Integer> pahaliUrunlerMapLambda=map.entrySet().stream().filter(t->t.getValue()>30).collect(Collectors.toMap(t->t.getKey(),t->t.getValue()));
        Map<String,Integer> pahaliUrunlerMapLambda2=map.entrySet().stream().filter(t->t.getValue()>30).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("pahaliUrunlerMapLambda = " + pahaliUrunlerMapLambda);
    }
}
