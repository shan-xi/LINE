import java.util.*;

public class Solution2 {
    class Solution {
        public String[] solution(int capacity, String[] commands) {
            List<String> result = new ArrayList<>();
            Queue<String> q = new LinkedList<>();
            for (int i = 0; i < commands.length; i++) {
                String[] co = commands[i].split(" ");
                if (co.length == 2) {
                    if (co[0].equals("OFFER")) {
                        if (q.size() == capacity) {
                            result.add("false");
                        } else {
                            result.add(String.valueOf(q.add(co[1])));
                        }
                    }
                } else if (co.length == 1) {
                    if (co[0].equals("SIZE")) {
                        result.add(String.valueOf(q.size()));
                    } else if (co[0].equals("TAKE")) {
                        if (q.size() != 0) {
                            result.add(String.valueOf(q.poll()));
                        }
                    }
                }
            }
            return result.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution2().new Solution();
//        System.out.println(Arrays.toString(s.solution(2, new String[]{
//                "OFFER hello", "OFFER world", "OFFER !", "TAKE", "SIZE"
//        })));
        System.out.println(Arrays.toString(s.solution(3, new String[]{
                "OFFER hello", "OFFER world", "OFFER !","OFFER !", "TAKE", "SIZE"
        })));
//        System.out.println(Arrays.toString(s.solution(1, new String[]{
//                "TAKE", "OFFER hello", "SIZE"
//        })));
    }
}
