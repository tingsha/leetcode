package greedy;

public class Task1221 {
    public static void main(String[] args) {
        System.out.println(new Task1221().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Task1221().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new Task1221().balancedStringSplit("LLLLRRRR"));
    }

    public int balancedStringSplit(String s) {
        int counter = 0;
        int res = 0;
        for (char ch : s.toCharArray()){
            if (ch == 'R')
                counter--;
            else
                counter++;
            if (counter == 0)
                res++;
        }
        return res;
    }
}
