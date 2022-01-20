import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int candies = a / b;
        if (n > k-1){
            candies += candies / (k-1);
        } else{
            candies += candies / n;
        }
        System.out.println(candies);
    }
}