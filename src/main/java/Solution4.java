import java.util.*;

public class Solution4 {
    class Solution {

        public int[] solution(int[] numbers, int target) {
            List<Integer> r = new ArrayList<>();
            Arrays.sort(numbers);
            Set<Integer> s = new HashSet<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                int temp = target - numbers[i];
                if (s.contains(temp)) {
                    if (temp < min) {
                        r.clear();
                        min = numbers[i];
                        r.add(numbers[i]);
                        r.add(temp);
                    }
                }
                s.add(numbers[i]);
            }

            int[] result = r.stream().sorted(Comparator.naturalOrder()).mapToInt(a -> a).toArray();
            return result;
        }
    }

    public static void main(String[] args) {
        Solution4.Solution s = new Solution4().new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4, 5}, 6)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4}, 7)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4}, 8)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(s.solution(new int[]{5, 6, 4, 5}, 10)));

    }
}
