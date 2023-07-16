//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        
		int n = Integer.parseInt(in.nextLine());
        
        HashMap<String, Integer> phoneBook = new HashMap<>();
		for (int i=0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
            
            phoneBook.put(name, phone);
            
			in.nextLine();
		}
        
		while (in.hasNext()) {
			String s = in.nextLine();
            Integer number = phoneBook.get(s);
            if (number == null) {
                System.out.println("Not found");
            } else {
                System.out.println(String.format("%s=%d", s, number));
            }
		}
	}
}