import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    
    public static int hourglassSum(List<List<Integer>> arr, int col, int row) {      
        List<Integer> topRow = arr.get(row);
        List<Integer> midRow = arr.get(row + 1);
        List<Integer> botRow = arr.get(row + 2);
        return topRow.get(col) + topRow.get(col + 1) + topRow.get(col + 2) +
                                 midRow.get(col + 1) +
               botRow.get(col) + botRow.get(col + 1) + botRow.get(col + 2);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        int maxHourglass = Integer.MIN_VALUE;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                maxHourglass = Math.max(maxHourglass, hourglassSum(arr, i, j));
            }
        }
        
        System.out.println(maxHourglass);

        bufferedReader.close();
    }
}
