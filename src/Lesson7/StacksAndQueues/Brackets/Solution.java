package Lesson7.StacksAndQueues.Brackets;

// you can also use imports, for example:
import java.util.Stack;

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.
Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]",
the function should return 0, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..200,000];
string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 */
class Solution {
    public int solution(String S) {

        // main idea: use "Stack" (push and pop)
        
        //special case
        if(S.length() == 0)
            return 1;
        
        // new Stack<Character>()
        Stack<Character> stack = new Stack<>();
        
        // scan the string (just one pass)
        for(int i=0; i< S.length(); i++){    
        	System.out.println(stack.toString());

            // note: push "its pair"
            if( S.charAt(i) == '(' ){
                stack.push(')');
            }
            else if( S.charAt(i) == '[' ){
                stack.push(']');
            }
            else if( S.charAt(i) == '{' ){
                stack.push('}');
            }
            // pop and check
            else if( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){
                // important: check if the stack is empty or not (be careful)
                if(stack.isEmpty() == true){
                    return 0;
                }
                else{
                    char temp = stack.pop(); // check if the stack is empty before pop!!!
                    if(temp != S.charAt(i)){ // not a pair
                        return 0;
                    }
                }
            }
        }
        // note: check if the stack is empty or not (be careful)
        if( !stack.isEmpty() ){
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static void main(String[] args) {
 		int result = new Solution().solution("{[()()]}");
		System.out.println("Result is = " + result);
 		result = new Solution().solution("([)()]");
		System.out.println("Result is = " + result);
 	}
 }
