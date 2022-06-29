public class Solution1 {
    class Solution {
        public int solution(int width, int height) {
            return width * height;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution1().new Solution();
        System.out.println(s.solution(2, 3));
        System.out.println(s.solution(0, 0));
        System.out.println(s.solution(1024, 1024));
    }
}
