import java.io.*;
import java.util.*;


public class Balanced_brackets {

    
    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.size() == 0) {
                    //closing Brackets > Opening Brackets
                    return "False";
                } else if (ch == ')' && st.peek() != '(') {
                    //brackets not-proper
                    return "False";
                } else if (ch == '}' && st.peek() != '{') {
                    //bracket not-proper
                    return "False";
                } else if (ch == ']' && st.peek() != '[') {
                    //brackets not-proper
                    return "False";
                } else {
                    //proper opening and closing Brackets
                    st.pop();
                }
            }
            
        }
        
        if (st.size() == 0) {
            //balanced
            return "true";
        } else {
            //opening brackets > closing brackets
            return "False";
        }   
    }


    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        for(int i = 1; i <= N; i++){
            String str = scn.next();
            String bstr = isBalanced(str);
            if(bstr == "true"){
                System.out.println("YES");
            }else if(bstr == "False"){
                System.out.println("NO");
            }
        }
    }
}
