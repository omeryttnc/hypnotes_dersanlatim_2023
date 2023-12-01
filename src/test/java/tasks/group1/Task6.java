package tasks.group1;

import org.junit.Test;

import java.util.*;

public class Task6 {

    @Test
    public void week6() {
        List<Integer> integerList = List.of(2, 3, 4, 5, 6, 7, 4, 5, 1, 0);

        //reduce   ->   add all digits

        //Structural
        int total=0;
        int total1=0;
        for (int value:integerList) {
            total=total+value;
            total1+=value;
        }
        System.out.println("total = " + total);
        System.out.println("total1 = " + total1);

        //Functional
        int totalLambda=integerList.stream().reduce(0,(subtotal,t)->subtotal=subtotal+t);
        System.out.println("totalLambda = " + totalLambda);
        int totalLambda2=integerList.stream().reduce(0,(subtotal,t)->subtotal+=t);
        System.out.println("totalLambda2 = " + totalLambda2);
        int totalLambda3=integerList.stream().reduce(0,Integer::sum);
        System.out.println("totalLambda3 = " + totalLambda3);
        Optional<Integer> max=integerList.stream().reduce(Integer::max);
        System.out.println("max = " + max);
        int max2=integerList.stream().reduce(0,Integer::max);
        System.out.println("max2 = " + max2);
        int mapto=integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("mapto = " + mapto);
        int multiply=integerList.stream().reduce(1,Math::multiplyExact);
        System.out.println("multiply = " + multiply);



        //distinct   ->    how many unique digits exist in the list

        //Structural1
        int i = integerList.size();

        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {
                if (integerList.get(j).equals(integerList.get(k))) {
                    i--;
                }
            }
        }
        System.out.println("i = " + i);

        //Structural 2
        List<Integer> uniqList = new ArrayList<>();
        for (int s : integerList) {
            if (!uniqList.contains(s)) {
                uniqList.add(s);
            }
        }
        System.out.println("uniqList = " + uniqList);
        int uniqListSize = uniqList.size();
        System.out.println("uniqListSize = " + uniqListSize);

        //Structural 3
        Set<Integer> uniqueSet=new HashSet<>(integerList);
        System.out.println("uniqueSet = " + uniqueSet);

        int setSize=uniqueSet.size();
        System.out.println("setSize = " + setSize);

        //Functional
        long uniqueLambda = integerList.stream().distinct().count();
        List<Integer> uniqueLambda2 = integerList.stream().distinct().toList();
        System.out.println("uniqueLambda = " + uniqueLambda);
        System.out.println("uniqueLambda2 = " + uniqueLambda2);



        //sorted   ->    sort all numbers biggest to smallest
        //Structural1 (smallest to biggest)
        List<Integer> sortedList=new ArrayList<>(integerList);
        Collections.sort(sortedList);
        System.out.println("sortedList = " + sortedList);

        //Structural2 (biggest to smallest)
        List<Integer> sortedList1=new ArrayList<>(integerList);
        Collections.sort(sortedList1.reversed());
        System.out.println("sortedList1 = " + sortedList1);

        //Functional
        List<Integer> sortedLambda=integerList.stream().sorted(Comparator.naturalOrder()).toList();
        System.out.println("sortedLambda = " + sortedLambda);

        List<Integer> sortedLambda2=integerList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sortedLambda2 = " + sortedLambda2);



        //skip   ->    do not take first two smallest number

        //Structural
        List<Integer> List=new ArrayList<>(integerList);
        List<Integer> skippedList=new ArrayList<>();
        Collections.sort(List);
        for (int b = 2; b <List.size() ; b++) {
            skippedList.add(List.get(b));
        }
        System.out.println("skippedList = " + skippedList);

        //Functional
        List<Integer> skippedLambda=integerList.stream().sorted().skip(2).toList();
        System.out.println("skippedLambda = " + skippedLambda);

        //skipped highest two number
        List<Integer> skippedLambdaReverse=integerList.stream().sorted(Comparator.reverseOrder()).skip(2).toList();
        System.out.println("skippedLambdaReverse = " + skippedLambdaReverse);


        //limit   ->    take only two biggest number

        //Structural
        List<Integer> limittedList=new ArrayList<>(integerList);
        List<Integer> maxTwoNumber=new ArrayList<>();

        Collections.sort(limittedList,Comparator.reverseOrder());

        limittedList.sort(Comparator.reverseOrder());

        for (int c = 0; c <2 ; c++) {
            maxTwoNumber.add(limittedList.get(c));
        }
        System.out.println("maxTwoNumber = " + maxTwoNumber);

        //Functional
        List<Integer>limittedListLambda=integerList.stream().sorted(Comparator.reverseOrder()).limit(2).toList();
        System.out.println("limittedListLambda = " + limittedListLambda);
    }
}
