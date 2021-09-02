package Distinct;

// note: remember to import (for using "Arrays.sort(xxx[])")
import java.util.Arrays;

// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

      // special case
        if(A.length ==0)
            return 0;
      
      // initial setting: one distinct number
        int result =1;
        
      // Using "Arrays.sort(A)" (important)
        Arrays.sort(A);
        
      // for counting the distinct numbers
        for(int i=1; i < A.length; i++){
            if(A[i] != A[i-1]){ // distinct
                result++; 
            }
        }
        
        return result; // return the number of distinct values
    }
    
    public static void main(String[] args) {
 		int result = new Solution().solution(new int[] {2, 1, 1, 2, 3, 1});
		System.out.println("Result is = " + result);
 	}
}
