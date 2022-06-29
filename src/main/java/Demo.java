import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Demo {
    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            if (A[A.length - 1] < 1) {
                return 1;
            }
            for (int j = 1; j < A.length; j++) {
                if (A[j] < 1) {
                } else {
                    if (A[j] - A[j - 1] > 1) {
                        if (A[j - 1] < 1) {
                            return 1;
                        } else {
                            return A[j - 1] + 1;
                        }
                    }
                }
            }
            return A[A.length - 1] + 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Demo().new Solution();
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(s.solution(A));
        int[] A1 = {-1, -3};
        System.out.println(s.solution(A1));
        int[] A2 = {-1000000, 1000000};
        System.out.println(s.solution(A2));
        int[] A3 = {1, 1000000};
        System.out.println(s.solution(A3));
        int[] A4 = {1, 2, 3};
        System.out.println(s.solution(A4));
        int[] A5 = {1};
        System.out.println(s.solution(A5));
        int[] A6 = {-1};
        System.out.println(s.solution(A6));
        int[] A7 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(s.solution(A7));
    }
}
