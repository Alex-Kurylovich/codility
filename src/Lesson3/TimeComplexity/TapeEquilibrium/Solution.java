package Lesson3.TimeComplexity.TapeEquilibrium;

/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
The difference between the two parts is the value of:
|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
For example, consider array A such that:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:
P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
For example, given:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
*/
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of Sum
        // and, (sum of the 2nd part) = Sum - (sum of the 1st part)
        // importantly, difference = |(sum of the 2nd part) - (sum of the 1st part)|
        
        // First, compute the sum (will be used for several times)
        int sum =0; // initial
        for(int i=0; i< A.length; i++){
            sum = sum + A[i];
        }
        
        // then, find the minimum difference
        int min_diff = Integer.MAX_VALUE;  // initial setting: Integer.MAX_VALUE
        
        int sum_part_one =0;
        int sum_part_two =0;
        int diff =0;
        
        // try to compute the above values in "one pass"!
        // for the possible partition-point P
        for(int p =1; p< A.length; p++){
            /* no need to use the second for loop (important)
            for(int j=0; j< p; j++){ // to compute the sum of the 1st part
                sum_part_one = sum_part_one + A[j];
            }
            */
            sum_part_one = sum_part_one + A[p-1];   // the sum of part one
            sum_part_two = sum - sum_part_one;      // the sum of part two
            diff = sum_part_one - sum_part_two;     // the difference
            if(diff <0)                             // absolute value
                diff = -diff;                       // all the values can be computed (one pass)
            
            min_diff = Math.min(min_diff, diff);    // min difference
        }
        return min_diff; // return the min difference   
    }


    public static void main(String[] args) {
		int result = new Solution().solution(new int[] {3, 1, 2, 4, 3});
		System.out.println("Result is = " + result);
	}
}
