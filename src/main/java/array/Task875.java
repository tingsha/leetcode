package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Task875 {
    public static void main(String[] args) {
        System.out.println(new Task875().minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(new Task875().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(new Task875().minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(new Task875().minEatingSpeed(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184}, 823855818));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = IntStream.of(piles).max().orElse(1);
        while (low < high){
            int mid = (low + high) / 2;
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil(pile * 1.0 / mid);
                if (time > h) {
                    break;
                }
            }
            if (time > h)
                low = mid+1;
            else
                high = mid;
        }
        return high;
//        for (int speed = 1; ; speed++){
//            int time = 0;
//            for (int pile : piles) {
//                time += Math.ceil(pile * 1.0 / speed);
//                if (time > h)
//                    break;
//            }
//            if (time <= h)
//                return speed;
//        }
    }
}
