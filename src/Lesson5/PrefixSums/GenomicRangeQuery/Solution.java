package Lesson5.PrefixSums.GenomicRangeQuery;

import java.util.Arrays;

/*
A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
which correspond to the types of successive nucleotides in the sequence.
Each nucleotide has an impact factor, which is an integer.
Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
You are going to answer several queries of the form:
What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
For example, consider string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:
The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice),
whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T,
whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides,
in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:
class Solution { public int[] solution(String S, int[] P, int[] Q); }
that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
returns an array consisting of M integers specifying the consecutive answers to all queries.
Result array should be returned as an array of integers.
For example, given the string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P and Q is an integer within the range [0..N - 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
 */
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        
        // result: the minimal impact of each query
        int[] result = new int[P.length];

        // to count "A"�?"C"�?"G"�?"T"
        // A[i] means: num of 'a' from 0 to i-1
        int A[] = new int[S.length()+1];
        int C[] = new int[S.length()+1];
        int G[] = new int[S.length()+1];
        int T[] = new int[S.length()+1];
        // note: we use "S.length()+1" 
        // which will let A[0]=0, C[0]=0, G[0]=0, T[0]=0
        // becasue we will compute number of 'a' by "A[Q+1] - A[P]"
        // we actually shift to right by one, and assume the biginning is a dummy '0' 

        // counting ( note: A[0]=0, C[0]=0, G[0]=0, T[0]=0 )
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'A')
            {
                A[i+1] = A[i]+1;
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'C')
            {
                A[i+1] = A[i];
                C[i+1] = C[i]+1;
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'G')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i]+1;
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'T')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i]+1;
            }
        }

        // to handle the queries
        int num_of_query = P.length; // or Q.length
        for (int i = 0; i < num_of_query; i++) {
            int a = A[ Q[i] + 1] - A[ P[i] ]; // num of 'a' between P and Q
            int c = C[ Q[i] + 1] - C[ P[i] ]; // num of 'c' between P and Q
            int g = G[ Q[i] + 1] - G[ P[i] ]; // num of 'g' between P and Q
            
            if(a > 0){ // there is 'a'
                result[i] = 1;
            }
            else if(c > 0){ // there is 'c'
                result[i] = 2;
            }
            else if(g > 0){ // there is 'g'
                result[i] =3;
            }
            else{ // there is only 'T'
                result[i] =4;
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) {
 		int[] result = new Solution().solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6});
		System.out.println("Result is = " + Arrays.toString(result));
 	}
}
