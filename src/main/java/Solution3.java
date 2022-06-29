import java.util.*;

public class Solution3 {
    class Solution {
        public int[] solution(int windowSize, int[] numbers) {
            List<Integer> sw = new ArrayList<>();
            int i = 0;
            int j = windowSize - 1;
            while (j < numbers.length) {
                int max = Integer.MIN_VALUE;
                for (int q = i; q <= j; q++) {
                    if (numbers[q] > max) {
                        max = numbers[q];
                    }
                }
                sw.add(max);
                i += 1;
                j += 1;
            }
            int[] result = sw.stream().sorted(Comparator.naturalOrder()).mapToInt(a -> a).toArray();
            return result;
        }
    }

    public static void main(String[] args) {
        Solution3.Solution s = new Solution3().new Solution();
        System.out.println(Arrays.toString(s.solution(2, new int[]{2, 1, 2, -1, 3})));
        System.out.println(Arrays.toString(s.solution(1, new int[]{2, 1, 2, -1, 3})));
        System.out.println(Arrays.toString(s.solution(3, new int[]{2, 1, 2, -1, 3})));
        System.out.println(Arrays.toString(s.solution(4, new int[]{2, 1, 2, -1, 3})));
        System.out.println(Arrays.toString(s.solution(5, new int[]{2, 1, 2, -1, 3})));
        System.out.println(Arrays.toString(s.solution(2, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE})));
    }
}
