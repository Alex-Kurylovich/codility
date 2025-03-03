package Nesting;

// you can also use imports, for example:
import java.util.Stack;

/*
A string S consisting of N characters is called properly nested if:
S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.
Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
For example, given S = "(()(())())", the function should return 1 and given S = "())",
the function should return 0, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.
 */
class Solution {
    public int solution(String S) {

        // special case 1: empty string
        if( S.length() ==0)
            return 1;
        // special case 2: odd length
        else if( S.length() % 2 == 1)
            return 0;

        // main idea: use "stack" to check
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<S.length(); i++){
            
            if( S.charAt(i)=='(' ){
                st.push(')'); // note: push its pair (be careful)
            }
            else if(S.charAt(i)==')'){
                
                // before pop: need to check if stack is empty (important)
                if(st.isEmpty() == true){
                    return 0;
                }
                else{
                    char temp = st.pop();
                    if( temp != ')'){
                        return 0;
                    }   
                }
            }
        }
        
        // be careful: if stack is "not empty" -> return 0
        if( !st.isEmpty() )
            return 0;
        else 
            return 1;   
    }
    
    public static void main(String[] args) {
 		int result = new Solution().solution("(()(())())");
		System.out.println("Result is = " + result);
		result = new Solution().solution("())");
		System.out.println("Result is = " + result);
 	}
}
