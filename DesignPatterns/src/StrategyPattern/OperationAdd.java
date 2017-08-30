package StrategyPattern;

/**
 * Created by Martin on 09-07-2017.
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2)
    {
        return num1 + num2;
    }
}
