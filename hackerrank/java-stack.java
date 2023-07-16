import java.util.*;
class Solution{
	
    public static boolean isBalanced(String brackets) {
        HashMap<String, String> openBrackets = new HashMap<>();
        openBrackets.put("(", ")");
        openBrackets.put("[", "]");
        openBrackets.put("{", "}");
        
        HashMap<String, String> closeBrackets = new HashMap<>();
        closeBrackets.put(")", "(");
        closeBrackets.put("]", "[");
        closeBrackets.put("}", "{");
        
        Stack<String> bStack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            String b = String.valueOf(brackets.charAt(i));
            
            if (openBrackets.containsKey(b)) {
                bStack.push(openBrackets.get(b));
            } else if (closeBrackets.containsKey(b)) {
                if (bStack.size() == 0) {
                    return false;
                }
                String bracket = bStack.pop();
                if (!b.equals(bracket)) {
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }
    
	public static void main(String []argh) {
		Scanner sc = new Scanner(System.in);
        
		while (sc.hasNext()) {
			String input = sc.nextLine();
            System.out.println(isBalanced(input));
		}
	}
}