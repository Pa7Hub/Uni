package Q3.programming.hue5.src;

import java.util.ArrayList;
import java.util.List;

public class Sum implements IArithmeticExpression {

    private List<IArithmeticExpression> listOfSums;

    public Sum(IArithmeticExpression sumA, IArithmeticExpression sumB) {
        this.listOfSums = new ArrayList<IArithmeticExpression>();
        this.listOfSums.add(sumA);
        this.listOfSums.add(sumB);
    }

    public Sum(int natNum1, int natNum2) {
        this.listOfSums = new ArrayList<IArithmeticExpression>();
        this.listOfSums.add(new NatNumber(natNum1));
        this.listOfSums.add(new NatNumber(natNum2));
    }

    public Sum(List<IArithmeticExpression>listOfSums) {
        // FIXME: possible NPE
        this.listOfSums = listOfSums;
    }


    @Override
    public int evaluate() {
        int valueOfSum = 0;

        for (IArithmeticExpression expr : listOfSums) {
            valueOfSum += expr.evaluate();
        }

        return valueOfSum;
    }

    @Override
    public String toString() {
        List<IArithmeticExpression> slicedList = listOfSums.subList(1, listOfSums.size() - 1);
        String sumString = "" + listOfSums.get(0);

        for (IArithmeticExpression expr : slicedList) {
            sumString += "+" + expr.toString();
        }

        return sumString;
    }

}
