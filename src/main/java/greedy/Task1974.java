package greedy;

public class Task1974 {
    public static void main(String[] args) {
        System.out.println(new Task1974().minTimeToType("abc"));
        System.out.println(new Task1974().minTimeToType("zjpc"));
        System.out.println(new Task1974().minTimeToType("pdy"));
        System.out.println(new Task1974().minTimeToType("bza"));
    }

    public int minTimeToType(String word) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int res = 0;
        int pointer = 0;
        for (char letter : word.toCharArray()){
            int clockwiseCounter = 0;
            for (int i = pointer; ; i++) {
                if (i == letters.length)
                    i = 0;
                if (letters[i] == letter)
                    break;
                clockwiseCounter++;
            }

            int counterclockwiseCounter = 0;
            for (int i = pointer; ; i--) {
                if (i == -1)
                    i = letters.length-1;
                if (letters[i] == letter)
                    break;
                counterclockwiseCounter++;
            }
            if (clockwiseCounter < counterclockwiseCounter){
                pointer = (pointer + clockwiseCounter) % letters.length;
            } else{
                pointer = pointer - counterclockwiseCounter >= 0
                        ? pointer - counterclockwiseCounter
                        : letters.length - Math.abs(pointer - counterclockwiseCounter);
            }
            res += 1 + Math.min(clockwiseCounter, counterclockwiseCounter);
        }
        return res;
    }
}
