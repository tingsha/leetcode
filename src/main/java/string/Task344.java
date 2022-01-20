package string;

public class Task344 {
    public static void main(String[] args) {
        Task344 task344 = new Task344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        task344.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
            new StringBuilder(new String(s)).reverse().getChars(0, s.length, s, 0);
    }
}
