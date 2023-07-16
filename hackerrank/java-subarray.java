import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            numbers[i] = a;
        }
        
        int numNegativeSubArrays = 0;
        int currentSum;
        
        for (int i = 0; i < n; i++) {
            currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += numbers[j];
                
                if (currentSum < 0) {
                    numNegativeSubArrays += 1;
                }
            }
        }
        
        System.out.println(numNegativeSubArrays);
        
        scanner.close();
    }
}