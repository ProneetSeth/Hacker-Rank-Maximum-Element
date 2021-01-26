// You have an empty sequence, and you will be given N queries. Each query is one of these three types:


// 1 x  -Push the element x into the stack.                     ||
// 2    -Delete the element present at the top of the stack.    || <=== Type of operation based on input 1, 2 and 3
// 3    -Print the maximum element in the stack.                ||


// Input Format

// The first line of input contains an integer, N. The next N lines each contain an above mentioned query.
//  (It is guaranteed that each query is valid.)


// Constraints
// 1 <= N <= 10^5
// 1 <= x <= 10^9
// 1 <= type <= 3

// Output Format

// For each type  query, print the maximum element in the stack on a new line.



// Sample Input
//_______________

// 10   <--------- number of operation 
// 1 97  <-------- here '1' means Push the element '97' into the stack.
// 2    <--------- here '2' means Delete the element present at the top of the stack
// 1 20
// 2
// 1 26
// 1 20
// 2
// 3    <--------- here '3' means Print the maximum element in the stack
// 1 91
// 3


// Sample Output

// 26
// 91

//Here the APPROACH WILL BE 
// 1. Creating two Stack
// 2. Initially put the first elemen in both the stack
// 3. while the 2nd element encounter, add that element to 1st stack but before adding to 2nd stack compare with top of the stack element, 
//     If it is greater then add on the top of the stk or else don't add
// 4. the 2nd top of the stack will represent the maximum element so far

import java.io.*;
import java.util.*;

public class Maximum_Element {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        Stack<Integer> mainStack = new Stack<>();  //1st stack for storing every element
        Stack<Integer> maxStack  = new Stack<>();   // 2nd stack for storing only max element on top of stack
        maxStack.push(Integer.MIN_VALUE);  //for comparing initially it is (-infinity) and u can compare
        
        for(int i = 0; i < N; i++){
            
            int op = scn.nextInt();
            
            if(op == 1){
                int item  = scn.nextInt();
                mainStack.push(item);
                
                int maxSofar = maxStack.peek();
                if(item > maxSofar){
                    maxStack.push(item);
                }else{
                    maxStack.push(maxSofar);
                }
            }else if(op == 2){
                mainStack.pop();
                maxStack.pop();
            }else if(op == 3){
                System.out.println(maxStack.peek());
            
            }  
        }
        
    }
}
 