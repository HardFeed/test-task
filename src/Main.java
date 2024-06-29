import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String path = "C:\\Users\\Win10\\IdeaProjects\\testtask\\10m.txt";
        list = readFile(path);
        System.out.println("Size of list: " + list.size());
        System.out.println("Max is " + maxNumber(list));
        System.out.println("Min is " + minNumber(list));
        System.out.println("Mediana is " + mediana(list));
        System.out.println("Average number is " + averageNum(list));
        increasingSequence(list);
        decreasingSequence(list);
    }

    public static List<Integer> readFile(String path){
        List<Integer> numberList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null){
                String[] numbersString = line.trim().split("\n");
                for (String numStr : numbersString){
                    try {
                        int number = Integer.parseInt(numStr);
                        numberList.add(number);
                    }catch (NumberFormatException n){
                        System.err.println("Non-integer value: " + numStr);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (reader != null){
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return numberList;
    }

    public static int maxNumber(List<Integer> list){
        int max = Integer.MIN_VALUE;

        for (int number: list){
            if (number > max){
                max = number;
            }
        }
        return max;
    }
    public static int minNumber(List<Integer> list){
        int min = Integer.MAX_VALUE;
        for (int number : list){
            if (number < min){
                min = number;
            }
        }
        return min;
    }
    public static double mediana(List<Integer> list){
        double med;
        Collections.sort(list);
        int n = list.size();

        if (n % 2 == 0){
            med = (double) (list.get(n/2-1) + list.get(n/2))/2;
        }else {
            med = list.get(n/2);
        }
        return med;
    }
    public static double averageNum(List<Integer> list){
        double average;
        int sum = 0;

        for (int num : list){
            sum += num;
        }
        average = (double) sum/list.size();
        return average;
    }
    public static void increasingSequence(List<Integer> list){
       List<Integer> result = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();
       for (int i = 0; i < list.size(); i++){
           temp.add(list.get(i));
           if (i+1 == list.size() || list.get(i) > list.get(i+1)){
               if (temp.size() >= result.size()){
                   result.clear();
                   result.addAll(temp);
               }
               temp.clear();
           }
       }
        System.out.println(result);
    }
    public static void decreasingSequence(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            temp.add(list.get(i));
            if (i+1 == list.size() || list.get(i) < list.get(i+1)){
                if (temp.size() >= result.size()){
                    result.clear();
                    result.addAll(temp);
                }
                temp.clear();
            }
        }
        System.out.println(result);
    }
}

