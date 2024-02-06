package Problem4;

public class Problem4 {
    static int findMin(int[] a, int n){
        if (n == 1) {
            return a[0];
        }else{
            int minValues = findMin(a, n - 1);

            return Math.min(a[n-1], minValues);
        }
    }

    static int findMax(int[] a, int n){
        if (n == 1) {
            return a[0];
        }else{
            int maxValues = findMax(a, n - 1);

            return Math.max(a[n-1], maxValues);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,5,2,4},4));
        System.out.println(findMax(new int[]{3,4,5,2},4));
    }
}
