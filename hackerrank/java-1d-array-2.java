import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return canWinRecursive(0, leap, game);
    }
    
    static boolean canWinRecursive(int index, int leap, int[] game) {
        if (index < 0 || game[index] != 0) {
            // Can't progress from here
            return false;
        }
        if (index == game.length - 1 || index + leap >= game.length) {
            // Can win from here
            return true;
        }
        
        // Mark where we've been then recurse 
        game[index] = 1;
        
        return canWinRecursive(index + 1, leap, game) || 
               canWinRecursive(index + leap, leap, game) ||
               canWinRecursive(index - 1, leap, game);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}