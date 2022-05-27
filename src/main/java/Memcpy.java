import java.util.Arrays;

public class Memcpy {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        String[] t = new String[s.length];
//        System.arraycopy(s, 0, t, 0, s.length);
        t = Arrays.copyOf(s, s.length);
        System.out.println(Arrays.toString(t));
    }
}
