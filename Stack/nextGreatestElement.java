//  Given an array, print next greatest element for each element. If it does not exist print -1.
//  I/P : [2, 4, 2, 15]
//  O/P : 4 15 15 -1
//  I/P : [5, 4, 3, 10, 9 ]
//  O/P : 10 10 10 -1 -1


package Stack;
import java.util.*;

public class nextGreatestElement {

    static void printNextGreatestElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i : arr) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else
            if(stack.peek() >= i) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty()) {
                    System.out.print(i + " ");
                    stack.pop();
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(-1 + " ");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 10, 9};
        printNextGreatestElements(arr);
    }
}