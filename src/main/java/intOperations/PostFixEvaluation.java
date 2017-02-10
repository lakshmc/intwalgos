package intOperations;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lchan39
 */
public class PostFixEvaluation {

    public static void main(String[] args) {
        System.out.println(result("10.2*(8-6)/3+112.5"));
    }

    public static BigDecimal result(String input){

        Deque<Double> stack = new ArrayDeque<Double>();
        char[] expression = input.toCharArray();
        for(int i = 0; i != expression.length; ++i)
        {
            // Determine if current element is digit or not
            if(Character.isDigit(expression[i]))
            {
                stack.addLast(Double.parseDouble(""+expression[i]));
            }
            else
            {
                double tempResult = 0;
                double temp;

                switch(expression[i])
                {
                    case '+': temp = stack.removeLast();
                        tempResult = stack.removeLast() + temp;
                        break;

                    case '-': temp = stack.removeLast();
                        tempResult = stack.removeLast() - temp;
                        break;

                    case '*': temp = stack.removeLast();
                        tempResult = stack.removeLast() * temp;
                        break;

                    case '/': temp = stack.removeLast();
                        tempResult = stack.removeLast() / temp;
                        break;
                }
                stack.addLast(tempResult);
            }
        }
        return new BigDecimal(stack.removeLast()).setScale(3, BigDecimal.ROUND_HALF_UP);
    }
}
