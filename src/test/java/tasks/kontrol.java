package tasks;

import org.junit.Test;

import java.util.*;

public class kontrol {
    List<Integer> integerList = List.of(2, 3, 4, 5, 6, 7, 4, 5, 1, 0);

    @Test
    public void list() {
        //reduce   ->   add all digits

        //Structural
        int total=0;
        for (int number:integerList) {
            total+=number;
        }
        System.out.println("total = " + total);


        //Functional
        int totalLambda=integerList.stream().reduce(0,(subtotal,t)->subtotal+=t);
        System.out.println("totalLambda = " + totalLambda);
        int totalLambda2=integerList.stream().reduce(0,(subtotal,t)->subtotal+t);
        System.out.println("totalLambda2 = " + totalLambda2);
        int totalLambda3=integerList.stream().reduce(0, Integer::sum);
        System.out.println("totalLambda3 = " + totalLambda3);



        //distinct   ->   how many unique digits exist in the list

        //Structural
        int flag=integerList.size();
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = i+1; j < integerList.size(); j++) {
                if (Objects.equals(integerList.get(i), integerList.get(j))){
                    flag--;
                }
            }
        }
        System.out.println("flag = " + flag);


        //Functional
        long uniqs=integerList.stream().distinct().count();
        System.out.println("uniqs = " + uniqs);



        //sorted   ->    sort all numbers biggest to smallest

        //Structural
        List<Integer> mutableList = new ArrayList<>(integerList);
        Collections.sort(mutableList, Collections.reverseOrder());
        System.out.println("mutableList = " + mutableList);


        //Functional
        List<Integer> sortedList=integerList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sortedList = " + sortedList);



        //skip   ->    do not take first two smallest number

        //Structural
        List<Integer>mutualList2=new ArrayList<>(integerList);
        Collections.sort(mutualList2);
        List<Integer> skippedList=new ArrayList<>();
        for (int i = 2; i <mutualList2.size() ; i++) {
            skippedList.add(mutualList2.get(i));
        }
        System.out.println("skippedList = " + skippedList);


        //Functional
        List<Integer> skippedListLambda=integerList.stream().sorted().skip(2).toList();
        System.out.println("skippedListLambda = " + skippedListLambda);



        //limit   ->    take only two biggest number

        //Structural
        List<Integer> mutableList3 = new ArrayList<>(integerList);
        List<Integer> maxTwoNumber = new ArrayList<>();
        Collections.sort(mutableList3, Collections.reverseOrder());

        for (int i = 0; i < 2; i++) {
            maxTwoNumber.add(mutableList3.get(i));
        }
        System.out.println("maxTwoNumber = " + maxTwoNumber);


        //Functional
        List < Integer > maxTwoNumberLambda = integerList.stream().sorted(Comparator.reverseOrder()).limit(2).toList();
        System.out.println("maxTwoNumberLambda = " + maxTwoNumberLambda);
    }
}
