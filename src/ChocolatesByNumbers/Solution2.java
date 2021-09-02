package ChocolatesByNumbers;

class Solution2 {
    public int solution(int N, int M) {

        // main idea: 
        // using "gcd(M, N)"
        // the number of eaten chocolates = N / gcd(M,N)
        return N/(gcd(N,M));
    }

    // using "Euclidean Algorithm" (important)
    public static int gcd(int a,int b){
        if(a % b == 0)
            return b;            // case 1
        else
            return gcd(b,a % b); // case 2 (key point)
    }

    
	public static void main(String[] args) {
		int result = new Solution2().solution(10, 4);
		System.out.println("Result is = " + result);
	}
}
