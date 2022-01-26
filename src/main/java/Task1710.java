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
        quickSort(boxTypes);

        for (int[] box : boxTypes){
            res += Math.min(truckSize, box[0]) * box[1];
            truckSize -= Math.min(truckSize, box[0]);
        }

        return res;
    }

    public void quickSort(int[][] array){
        quickSort(array, 0, array.length-1);
    }

    public void quickSort(int[][] array, int start, int end){
        if (start == end)
            return;

        int pointer = start;

        for (int i = start; i < end; i++) {
            if (array[i][1] > array[end][1]){
                swap(array, i, pointer);
                pointer++;
            }
        }
        swap(array, pointer, end);
        if (pointer < end) quickSort(array, pointer+1, end);
        if (pointer > start) quickSort(array, start, pointer-1);
    }

    public void swap(int[][] array, int i, int j){
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
