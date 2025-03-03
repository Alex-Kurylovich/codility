package Lesson6.Sorting.Distinct;

// note: remember to import (for using "Arrays.sort(xxx[])")
import java.util.Arrays;

// System.out.println("this is a debug message");

/*
Write a function
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of distinct values in array A.
For example, given array A consisting of six elements such that:
 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
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
