// Problem:
// https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Optimized Approach: TC: O((logM) * (N)), SC: O(1)
// Binary Search - start with search space 1 to M.
// mid^N is in epsilon range from M: return mid
// else if mid^N < m: l=mid+1, as all numbers < mid would also give < m for ^N
// else (mid^N > m): r=mid-1, as all numbers > mid would also give > m for ^N 

// Logic:
// M = 27, N = 3, ans = 3
// M = 64, N = 3, ans = 4
// M = (no matter what), N = 1, ans = M // EDGE CASE: highest possible answer
// M = 1, N = (no matter what), ans = 1 // EDGE CASE: lowest possible answer
// So, for each N and M given, we can find the Nth root of M within range:
// 1 2 3 ..... M -> Monotonic Function -> Binary Search 

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    public double multiply(double num, int raisedTo) {
        double ans = 1.0; // To maintain precision while calculating power.
        for (int i = 1; i <= raisedTo; i++) {
            ans *= num;
        }

        return ans;
    }

    public int NthRoot(int n, int m) {
        // code here
        long low = 1;
        long high = m;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            double midPow = multiply(mid, n);

            // Use a small epsilon to account for floating-point precision issues
            double epsilon = 0.0001;

            if (Math.abs(midPow - m) < epsilon) {
                return (int) mid;
            } else if (midPow < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}