import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int wSize = 3;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.size()-wSize+1; i++) {
            for(int j = 0; j < arr.get(i).size()-wSize+1; j++) {
                int total = 0;
                for(int k = i, m = 0; k < i + wSize; k++) {
                    if((m++)%2==0) {
                        total += arr.get(k).get(j+0);
                        total += arr.get(k).get(j+1);
                        total += arr.get(k).get(j+2);
                    } else {
                        total += arr.get(k).get(j+1);                        
                    }
                }
                if(max < total) max = total;
            }
        }
        System.out.println(max);
        bufferedReader.close();
        
    }
}
