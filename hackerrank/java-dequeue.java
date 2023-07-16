import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> runningMap = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();

        int runningMax = 0;
        int currentUnique = 0;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add num to deque
            deque.addLast(num);
            // Increase map size of num by 1
            runningMap.putIfAbsent(num, 0);
            runningMap.put(num, runningMap.get(num) + 1);
            
            // Remove head from deque (if exceeding m)
            if (deque.size() > m) {
                int removedValue = deque.removeFirst();
                
                // Decrease map size of removedValue by 1
                int mapSizeRemoved = runningMap.get(removedValue) - 1;
                if (mapSizeRemoved <= 0) {
                    runningMap.remove(removedValue);
                } else {
                    runningMap.put(removedValue, mapSizeRemoved);
                }
            }
            
            runningMax = Math.max(runningMax, runningMap.keySet().size());
            
            
            // Deque only
            // if (deque.size() >= m) {
            //     int removedValue = deque.removeFirst();
            //     if (!deque.contains(removedValue)) {
            //         currentUnique -= 1;
            //     }
            // }

            // if (!deque.contains(num)) {
            //     currentUnique += 1;
            // }
            
            // if (currentUnique > runningMax) {
            //     runningMax = currentUnique;
            // }
            
            // // Always add the current value
            // deque.addLast(num);
        }
        
        System.out.println(runningMax);
    }
}