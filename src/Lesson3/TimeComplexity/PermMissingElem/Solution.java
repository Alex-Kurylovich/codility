package Lesson3.TimeComplexity.PermMissingElem;

/*
An array A consisting of N different integers is given.
The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
Your goal is to find that missing element.
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A, returns the value of the missing element.
For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of "Sum = (ceiling + floor) * height /2"
        // So---> Sum = (1 + N+1) * N /2
        // the missing element can be found by minus other elements
        
        // note: need to use "long" to avoid potential bugs (large numbers)
        long ceiling = A.length +1;
        long floor = 1;
        long height = A.length + 1; // note: need to plus extra "1" 
                                    // because there is one element "missing"! 
                                    // be careful about this (important)
        long sum = (ceiling +floor) * height /2; // main idea
        /*        
        int high = A.length +1; 
        int low = 1;
        int height = A.length + 1; 
        int sum = (high +low) * height /2; // main idea
        */
        long missing_number = sum; // initial setting (sum)
        
        for(int i=0; i<A.length; i++){
            missing_number = missing_number - A[i]; // minus other elements
        }
        
        return (int)missing_number; // return the missing element (long->int)
    }

    public static void main(String[] args) {
		int result = new Solution().solution(new int[] {2, 3, 1, 5});
		System.out.println("Result is = " + result);
	}
}
