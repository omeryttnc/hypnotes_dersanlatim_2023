package tasks.group2;

import org.junit.Test;

import java.util.*;

public class Task6 {
    @Test
    public  void  week6(){
        List<Integer> integerList = List.of(2, 3, 4, 5, 6, 7, 4, 5, 1,0);

        //reduce  ->   add all digits

        //Structural
        int total=0;
        int total1=0;
        for (int number:integerList) {
            total=total+number;
            total1+=number;
        }
        System.out.println("total = " + total);
        System.out.println("total1 = " + total1);

        //Functional
        int totalLambda=integerList.stream().reduce(0,(subtotal,t)->subtotal=subtotal+t);
        System.out.println("totalLambda = " + totalLambda);
        int totalLambda1=integerList.stream().reduce(0,(subtotal,t)->subtotal+=t);
        System.out.println("totalLambda1 = " + totalLambda1);
        int totalLambda3=integerList.stream().reduce(0,Integer::sum);
        System.out.println("totalLambda3 = " + totalLambda3);
        int totalLambda4=integerList.stream().reduce(0,Integer::max);
        System.out.println("totalLambda4 = " + totalLambda4);

        Optional<Integer> selectedElement = integerList.stream()
                .skip(new Random().nextInt(integerList.size()))
                .findFirst();

        System.out.println("selectedElement = " + selectedElement);

        int multiplyLambda=integerList.stream().reduce(1,Math::multiplyExact);
        System.out.println("multiplyLambda = " + multiplyLambda);

        int totalLambda5=integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("totalLambda5 = " + totalLambda5);



        //distinct   ->    how many unique digits exist in the list

        //Structural 1    set
        Set<Integer> uniqSet=new HashSet<>(integerList);
        System.out.println("uniqSet = " + uniqSet);

        int uniqNumberSet= uniqSet.size();
        System.out.println("uniqNumberSet = " + uniqNumberSet);

        //Structural 2    for each
        List<Integer> uniqueForEach=new ArrayList<>();
        for (int i:integerList) {
            if (!uniqueForEach.contains(i)){
                uniqueForEach.add(i);
            }
        }
        System.out.println("uniqueForEach = " + uniqueForEach);
        int uniqForEachNumber=uniqueForEach.size();
        System.out.println("uniqForEachNumber = " + uniqForEachNumber);

        //Structural 3    for loop
        int numberOfUnique=integerList.size();
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = i+1; j < integerList.size(); j++) {
                if (integerList.get(i).equals(integerList.get(j))){
                    numberOfUnique--;
                }
            }
        }
        System.out.println("numberOfUnique = " + numberOfUnique);

        //Functional
        long numberOfUniqueLambda=integerList.stream().distinct().count();
        System.out.println("numberOfUniqueLambda = " + numberOfUniqueLambda);

        List<Integer> listOfUniqueLambda=integerList.stream().distinct().toList();
        System.out.println("listOfUniqueLambda = " + listOfUniqueLambda);



        //sorted   ->    sort all numbers biggest to smallest

        //Structural
        List<Integer> sortedList=new ArrayList<>(integerList);
        Collections.sort(sortedList);
        System.out.println("sortedList = " + sortedList);

        List<Integer> sortedList1=new ArrayList<>(integerList);
        Collections.sort(sortedList1.reversed());
        System.out.println("sortedList1 = " + sortedList1);

        //Functional
        List<Integer> sortedListLambda=integerList.stream().sorted().toList();
        System.out.println("sortedListLambda = " + sortedListLambda);

        List<Integer> sortedReverseListLambda=integerList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sortedReverseListLambda = " + sortedReverseListLambda);



        //skip    ->    do not take first two smallest number

        //Structural
        List<Integer>sortedListForSkip=new ArrayList<>(integerList);
        Collections.sort(sortedListForSkip);
        List<Integer>skippedList=new ArrayList<>();
        for (int i = 2; i <sortedListForSkip.size() ; i++) {
            skippedList.add(sortedListForSkip.get(i));
        }

        System.out.println("skippedList = " + skippedList);

        //Functional
       List<Integer>skippedListLambda=integerList.stream().sorted().skip(2).toList();
        System.out.println("skippedListLambda = " + skippedListLambda);

        //skipped highest two number
        List<Integer>skippedListLambda2=integerList.stream().sorted(Comparator.reverseOrder()).skip(2).toList();
        System.out.println("skippedListLambda2 = " + skippedListLambda2);



        //limit    ->     take only two biggest number

        //Structural
        List<Integer>listForLimit=new ArrayList<>(integerList);
        Collections.sort(listForLimit.reversed());
        List<Integer>maxTwoNumber=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            maxTwoNumber.add(listForLimit.get(i));
        }
        System.out.println("maxTwoNumber = " + maxTwoNumber);

        //Functional
        List<Integer> maxTwoNumberLambda=integerList.stream().sorted(Comparator.reverseOrder()).limit(5).toList();
        System.out.println("maxTwoNumberLambda = " + maxTwoNumberLambda);
    }
}
