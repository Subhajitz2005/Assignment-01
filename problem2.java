import java.util.*;

class Solution {
    public static int minOperations(int[] arr, int k) {
        int n = arr.length;

        // Check if possible
        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[0]) % k != 0) {
                return -1;
            }
        }

        // Convert to steps
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = arr[i] / k;
        }

        Arrays.sort(steps);

        int median = steps[n / 2];
        int operations = 0;

        for (int s : steps) {
            operations += Math.abs(s - median);
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
    }
}
