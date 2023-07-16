import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int lineNumber = 0;
        while(scanner.hasNext()) {
            lineNumber += 1;
            String currentLine = scanner.nextLine();
            System.out.println(String.format("%d %s", lineNumber, currentLine));
        }
        
        scanner.close();
    }
}