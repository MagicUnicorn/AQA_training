
public class CalculatorZhdanovaAnna {

        public static void main(String[] args) {
        double y = 2;
        CalculatorZhdanovaAnna calculator = new CalculatorZhdanovaAnna();
        double addResult = calculator.addition(2, y);
        double subResult = calculator.subtraction(addResult, y);
        double mulResult = calculator.multiplication(subResult, y);
        calculator.division(mulResult, y);
    }

    public double addition(double x, double y){
        double addResult = x+y;
        System.out.println("Previous Result: null,"+" Current Result: "+ addResult);
        return addResult;
    }

    public double subtraction(double x, double y){
        double subResult = x-y;
        System.out.println("Previous Result: "+x+", Current Result: "+ subResult);
        return subResult;
    }

    public double multiplication(double x, double y){
        double mulResult = x*y;
        System.out.println("Previous Result: "+x+", Current Result: "+ mulResult);
        return mulResult;
    }

    public double division(double x, double y){
        double divResult = x/y;
        System.out.println("Previous Result: "+x+", Current Result: "+ divResult);
        return divResult;
    }
}
