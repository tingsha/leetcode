package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task338 {

    public static void main(String[] args) {
        System.out.println(new Task338().countVowelStrings(2));
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < 6; j++) {
                dp[i][j] = dp[i][j-1] + (i > 1 ? dp[i-1][j] : 1);
            }
        }
        return dp[n][5];
    }

    private int res = 0;

    public void buildString(int n, String prev, char[] letters){
        if (n == 0) {
            res++;
            return;
        }
        for (char letter : letters) {
            if (prev.length() == 0 || letter >= prev.charAt(prev.length()-1))
                buildString(n - 1, prev + letter, letters);
        }
    }
}
