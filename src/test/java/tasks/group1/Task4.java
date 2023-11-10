package tasks.group1;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
    Map<String,Integer> map=new HashMap<>();
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
        webElementList.forEach(t-> System.out.println("t = " + t.getCssValue("")));
        webElementList.stream().map(t->t.getCssValue("")).forEach(System.out::println);
        List<String> cssValues= webElementList.stream().map(t->t.getCssValue("")).collect(Collectors.toList());
        List<String> cssValues2= webElementList.stream().map(t->t.getCssValue("")).toList();



        // urunlerin fiyatlarini 5 ile carpin
        //Structrul-1
        for (Map.Entry<String,Integer>pairs:map.entrySet()) {
            int value= pairs.getValue()*5;
        }
        //Structural-2
            for (int value: map.values()) {
            int price= value*5;
            System.out.println("price = " + price);
        }
        for (String key: map.keySet()) {
            System.out.println("key = " + key);
        }

        //Functional
        map.values().forEach(t-> System.out.println("t = " + t*5));
        map.values().stream().map(t->t*5).forEach(System.out::println);



        //----------------------------- count -------------------------------
        List<String> names = List.of("kesif","plus","selenium","dersleri");
        // name listesinin icinde kac tane String "le" iceriyor
        //Structural
        int total=0;
        for (String name:names) {
            if (name.contains("le")){
               total++;
            }
        }
        System.out.println("total = " + total);

        //Functional
        long totalLambda= names.stream().filter(t->t.contains("le")).count();
        System.out.println("totalLambda = " + totalLambda);


        // map icerisinde kac tane urun 30 dan daha pahali
        //Structural
        int pahaliUrun = 0;
        for (int value: map.values()) {
            if (value>30){
                System.out.println("value = " + value);
                pahaliUrun++;
            }
        }
        System.out.println("pahaliUrun = " + pahaliUrun);

        //Functinal
        long pahaliUrunLambda=map.values().stream().filter(t->t>30).count();
        System.out.println("pahaliUrunLambda = " + pahaliUrunLambda);


        // --------------------------- collect -------------------------------
        // names listesin de "l" bulunduran kelimeleri yeni bir listeye ekleyin
        //Structural
        List<String>lnames=new ArrayList<>();
        for (String name:names) {
            if (name.contains("l")){
                lnames.add(name);
            }
        }
        System.out.println("lnames = " + lnames);

        //Functional
        List<String>lNamesLambda=names.stream().filter(t->t.contains("l")).collect(Collectors.toList());
        List<String>lNamesLambda2=names.stream().filter(t->t.contains("l")).toList();
        System.out.println("lNamesLambda = " + lNamesLambda);
        System.out.println("lNamesLambda2 = " + lNamesLambda2);

        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir listeye ekleyin
        //Structural
        List<String> urunler=new ArrayList<>();
        for (Map.Entry<String,Integer> pairs: map.entrySet()) {
            if (pairs.getValue()>30){
                urunler.add(pairs.getKey());
            }
        }
        System.out.println("urunler = " + urunler);

        //Functional
        List<String> urunlerLambda=map.entrySet().stream().filter(t->t.getValue()>30).map(t->t.getKey()).collect(Collectors.toList());
        List<String> urunlerLambda2= map.entrySet().stream().filter(t->t.getValue()>30).map(Map.Entry::getKey).toList();
        System.out.println("urunlerLambda = " + urunlerLambda);
        System.out.println("urunlerLambda2 = " + urunlerLambda2);

        // fiyati 30 dan fazla olan urunlerin isimlerini farkli bir Map e ekleyin
        //Structrual
        Map<String,Integer> urunlerMap=new HashMap<>();
        for (Map.Entry<String,Integer> pairs: map.entrySet()) {
            if (pairs.getValue()>30){
                urunlerMap.put(pairs.getKey(), pairs.getValue());
            }
        }
        System.out.println("urunlerMap = " + urunlerMap);

        //Functional
       Map<String,Integer> urunlerMapLambda= map.entrySet().stream().filter(t->t.getValue()>30).collect(Collectors.toMap(t->t.getKey(),t->t.getValue()));
       Map<String,Integer> urunlerMapLambda2= map.entrySet().stream().filter(t->t.getValue()>30).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("urunlerMapLambda = " + urunlerMapLambda);
        System.out.println("urunlerMapLambda2 = " + urunlerMapLambda2);
    }
}
