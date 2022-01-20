package recursion;

public class Task231_342_326 {

    public static void main(String[] args) {
        Task231_342_326 task231342326 = new Task231_342_326();
        System.out.println("1 - " + task231342326.isPowerOfThree(1));
        System.out.println("2 - " + task231342326.isPowerOfThree(2));
        System.out.println("3 - " + task231342326.isPowerOfThree(3));
        System.out.println("4 - " + task231342326.isPowerOfThree(4));
        System.out.println("8 - " + task231342326.isPowerOfThree(8));
        System.out.println("9 - " + task231342326.isPowerOfThree(9));
        System.out.println("13 - " + task231342326.isPowerOfThree(13));
        System.out.println("16 - " + task231342326.isPowerOfThree(16));
        System.out.println("18 - " + task231342326.isPowerOfThree(18));
        System.out.println("27 - " + task231342326.isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && divideByThree(n) == 1;
    }

    public int divideByThree(int n){
        if (n == 1)
            return 1;
        if (n % 3 == 0)
            return divideByThree(n/3);
        return -1;
    }
}
