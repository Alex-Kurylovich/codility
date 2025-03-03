package CountNonDivisible;

import java.util.Arrays;
import java.util.HashMap;

/*
You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N,
we want to count the number of elements of the array that are not the divisors of A[i].
We say that these elements are non-divisors.
For example, consider integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:
A[0] = 3, the non-divisors are: 2, 6,
A[1] = 1, the non-divisors are: 3, 2, 3, 6,
A[2] = 2, the non-divisors are: 3, 3, 6,
A[3] = 3, the non-divisors are: 2, 6,
A[4] = 6, there aren't any non-divisors.
Write a function:
class Solution { public int[] solution(int[] A); }
that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
Result array should be returned as an array of integers.
For example, given:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..2 * N].
 */
class Solution {
    public int[] solution(int[] A) {

        // main idea:
        // using "HashMap" to count 
        
        // map1(key, value)
        HashMap<Integer, Integer> map1 = new HashMap<>();
        // key: the elements, value, count of elements
        for(int i=0; i< A.length; i++){
            if(map1.containsKey(A[i]) == false){
                map1.put(A[i], 1); // add new element
            }
            else{
                 map1.put(A[i], map1.get(A[i])+1 ); // count++
            }
        }
        
        // map2(key, value)
        HashMap<Integer, Integer> map2 = new HashMap<>();
        // key: the elements, value, count of "number of non-divisors" of elements
        for( int n : map1.keySet() ){            
            int numDivisors =0;
            // find divisors from 1 to sqrt(n)
            int sqrtN = (int)Math.sqrt(n);  
            for(int i=1; i<=sqrtN; i++ ){
                if( n % i == 0){ // means: i could be a divisor
                    int anotherDivisor = n/i; 
    
                    if(map1.containsKey(i) == true ){
                        numDivisors = numDivisors + map1.get(i);
                    }
                    if(anotherDivisor != i){ // avoid double count (be careful)
                        if(map1.containsKey(anotherDivisor) == true){
                            numDivisors = numDivisors + map1.get(anotherDivisor);
                        }
                    }
                }
            }
            
            int numNonDivisors = A.length - numDivisors;
            map2.put(n, numNonDivisors); 
        }
        
        // results: number of non-divisors
        int[] results = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            results[i] = map2.get(A[i]);
        }

        return results;
    }

    
    public static void main(String[] args) {
		int[] result = new Solution().solution(new int[] {3, 1, 2, 3, 6});
		System.out.println("Result is = " + Arrays.toString(result));
	}
}
