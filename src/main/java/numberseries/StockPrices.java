package numberseries;

/**
 * Created on 5/1/14.
 */

/**
 * Given a list of periodic stock prices find the best buy and sell price for which profit is maximum
 * How it works:
 * (diff) tracks the current gain and maxDiff tracks the highest gain.
 * To get the max profit, you need to buy lowest and sell highest. This algo keeps track of the gain (diff) for every new stock
 * price and the highest gain (maxDiff) thus far. Whenever the gain hits new high, that price is marked for sell price.
 *
 * When stock price hits new low, we buy the stock at that price, meaning (diff) current gain will be zero. As the loop
 * progresses this will track the gain since buying the stock if the gain goes past the highest gain (maxDiff) then mark it.
 *
 */
public class StockPrices {
    public static void main(String[] args){
        double[] values = new double[]{ 300, 55.39, 109.23, 48.28, 48.29,105.53, 12.24, 1.10, 50.0};

        // stock price when profit was highest
        double max = Double.MIN_VALUE;
        // lowest stock price encountered
        double bottom = values[0];
        // highest profit encountered
        double maxDiff = Double.MIN_VALUE;
        // current profit/loss based on max and bottom
        double diff = 0;


        for (int i = 1; i < values.length; i++){
            System.out.println("Before ==> diff="+diff+" max diff="+maxDiff+" max= "+max+" bottom="+bottom);
            System.out.println("dealing with "+values[i]+" and "+values[i-1]+" difference is "+(values[i] - values[i - 1]));

            diff += values[i] - values[i - 1]; // current net gain/loss

            // if current net gain/loss exceeds previous best gain, then set that as current best,
            // and store the current stock price for sell
            if (diff >= maxDiff){
                maxDiff = diff;
                max = values[i];
            }
            // for new low in stock price, gain would be negative so set it to zero since we will buy the stock at this price.
            if (values[i] < bottom){
                bottom = values[i];
                diff = 0;
            }
            // same logic done differently

           /* if (diff<0){
                diff = 0;
            }*/
            System.out.println("After ==> diff="+diff+" max diff="+maxDiff+" max= "+max+" bottom="+bottom+"\n");
        }
        // end of the loop, you will have the the stock price for which profit was maximum, that is the sell price. Buy
        // price is simply sell price minus the max profit.
        System.out.println("Buy at "+(max - maxDiff)+" Sell at "+ max);
    }
}
