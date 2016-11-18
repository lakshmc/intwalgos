package IntArray;

import java.util.Arrays;

/**
 * Created by lchan39 on 8/19/15.
 */
public class CoinChangeProblem {
    public static void main(String[] args) {

        int[] coins = {1,2,4}; //-> 1,1,1,1 / 1,1,2 / 1,3 / 2,2
        int target = 7;
        //System.out.println(findCombinationsCount(target, coins));

        System.out.println(coinChange(coins,target));
    }

    static int findCombinationsCount(int amount, int coins[]) {
        return findCombinationsCount(amount, coins, 0);
    }

    static int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || coins.length == checkFromIndex)
            return 0;
        else {
            int withFirstCoin = findCombinationsCount(amount-coins[checkFromIndex], coins, checkFromIndex);
            int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex+1);
            return withFirstCoin + withoutFirstCoin;
        }
    }

    // dynamic programming
    // O(s*n) where s is number of coins and n is amount. Two loops for s and n.
    // Space complexity O(n): array of size n is used for storing values
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max]; // storing results for each iteration (0-amount => amount+1 size)
        Arrays.fill(dp, max); // fill array with max value
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
