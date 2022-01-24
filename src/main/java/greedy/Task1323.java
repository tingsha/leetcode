package greedy;

public class Task1323 {
    public static void main(String[] args) {
        System.out.println(new Task1323().maximum69Number(9669));
        System.out.println(new Task1323().maximum69Number(9996));
        System.out.println(new Task1323().maximum69Number(9999));
    }

    public int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
