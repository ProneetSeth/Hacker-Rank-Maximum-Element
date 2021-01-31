import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

     static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here 
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        
        int st1heightsofar = 0;
        int st2heightsofar = 0;
        int st3heightsofar = 0;
        
        for(int i = h1.size() - 1; i >= 0; i--){
            st1heightsofar = st1heightsofar + h1.get(i);
            st1.push(st1heightsofar);
        }
        for(int i = h2.size() - 1; i >= 0; i--){
            st2heightsofar = st2heightsofar + h2.get(i);
            st2.push(st2heightsofar);
        }
        for(int i = h3.size() - 1; i >= 0; i--){
            st3heightsofar = st3heightsofar + h3.get(i);
            st3.push(st3heightsofar);
        }
        
        
        while(true){
            if (st1.isEmpty() || st2.isEmpty()|| st3.isEmpty()){
                return 0;
            }
            
            st1heightsofar = st1.peek();
            st2heightsofar = st2.peek();
            st3heightsofar = st3.peek();
            
            if(st1heightsofar == st2heightsofar && st2heightsofar == st3heightsofar){
                return st1heightsofar;
            }
            
            if(st1heightsofar >= st2heightsofar && st1heightsofar >= st3heightsofar){
                st1.pop();
            }else if(st2heightsofar >= st1heightsofar && st2heightsofar >= st3heightsofar){
                st2.pop();
            }else if(st3heightsofar >= st1heightsofar && st3heightsofar >= st2heightsofar){
                st3.pop();

            }

        }


    }

}

public class Equal_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
