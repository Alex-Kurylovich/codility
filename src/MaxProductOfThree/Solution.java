package MaxProductOfThree;

// note: need to import (for using "Arrays.sort(int[])")
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
A non-empty array A consisting of N integers is given.
The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
For example, array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:
(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A, returns the value of the maximal product of any triplet.
For example, given array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */
class Solution {
    public int solution(int[] A) {

        // main idea: 
        // max_1 = positive * positive * positive
        // max_2 = negative * negative * positive
        // max = Math.max(max_1, max_1)
        // just need to sort the integer array
        
        // sort the array
        Arrays.sort(A);

        // max_1 = 1st biggest * 2nd biggest * 3rd biggest 
        int max_1 = A[A.length-1] * A[A.length-2] * A[A.length-3];
        
        // max_2 = 1st smallest * 2nd smallest * 1st biggest
        int max_2 = A[0] * A[1] * A[A.length-1];

        // take the maximum        
        int max = Math.max(max_1, max_2);
        
        return max;
    }
    
    public static void main(String[] args) {
 		int result = new Solution().solution(new int[] {-3, 1, 2, -2, 5, 6});
		System.out.println("Result is = " + result);
 	}
}
