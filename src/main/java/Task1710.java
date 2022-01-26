public class Task1710 {
    public static void main(String[] args) {
        System.out.println(new Task1710().maximumUnits(new int[][]{
                {1, 3},
                {2, 2},
                {3, 1}
        }, 4));
        System.out.println(new Task1710().maximumUnits(new int[][]{
                {5, 10},
                {2, 5},
                {4, 7},
                {3, 9}
        }, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < boxTypes.length-1; i++) {
                if (boxTypes[i][1] < boxTypes[i+1][1]){
                    int[] temp = boxTypes[i];
                    boxTypes[i] = boxTypes[i+1];
                    boxTypes[i+1] = temp;
                    sorted = false;
                }
            }
        }

        for (int[] box : boxTypes){
            res += Math.min(truckSize, box[0]) * box[1];
            truckSize -= Math.min(truckSize, box[0]);
        }

        return res;
    }
}
