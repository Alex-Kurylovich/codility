package CountTriangles;

import java.util.Arrays;

/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular
if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R].
In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
There are four triangular triplets that can be constructed from elements of this array,
namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of triangular triplets in this array.
For example, given array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..1,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */
class Solution {
    public int solution(int[] A) {
        
        int  numTriangle = 0;
        
        // important: sort the edges 
        // so that we just need to check if
        // "1st edge + 2nd edge > 3rd edge"
        Arrays.sort(A);
        
        // Using "Caterpillar method"
        // so we can have O(n^2), not O(n^3)  
        for(int i=0; i < A.length-2; i++){
            
            // the leftEnd and rightEnd of the "Caterpillar"
            int leftEnd = i+1;
            int rightEnd = i+2;
            
            while(leftEnd < A.length-1){
                
                // key point of "Caterpillar method"
                if(rightEnd < A.length && A[i] + A[leftEnd] > A[rightEnd]){
                    rightEnd++; // increase the Caterpillar
                }
                else{
                    // note: need to minus "1" 
                    // because the rightEnd is not included
                    numTriangle = numTriangle + (rightEnd - leftEnd - 1);
                    leftEnd++; // decrease the Caterpillar
                }
            }
        }
        
        return numTriangle;
    }
    
 	public static void main(String[] args) {
		int result = new Solution().solution(new int[] {10, 2, 5, 1, 8, 12});
		System.out.println("Result is = " + result);
	}
}   

