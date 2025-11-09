public class Knapsack01 {

    public static int KnapsackRecursion(int val[], int wt[], int W, int n) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {// valid
            // included
            int ans1 = val[n - 1] + KnapsackRecursion(val, wt, W - wt[n - 1], n - 1);

            // excluded
            int ans2 = KnapsackRecursion(val, wt, W, n - 1);

            return Math.max(ans1, ans2);

        } else {
            return KnapsackRecursion(val, wt, W, n - 1);

        }
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int KnapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {// valid
            // included
            int ans1 = val[n - 1] + KnapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);

            // excluded
            int ans2 = KnapsackMemo(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];

        } else {
            return KnapsackMemo(val, wt, W, n - 1, dp);

        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        // System.out.println(KnapsackRecursion(val,wt,W,val.length));

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(KnapsackMemo(val, wt, W, val.length, dp));
        printDP(dp);

    }
}
