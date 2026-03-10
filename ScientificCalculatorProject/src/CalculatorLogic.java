public class CalculatorLogic {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double square(double a) {
        return a * a;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public double sin(double a) {
        return Math.sin(Math.toRadians(a));
    }

    public double cos(double a) {
        return Math.cos(Math.toRadians(a));
    }

    public double tan(double a) {
        return Math.tan(Math.toRadians(a));
    }

    public double log(double a) {
        return Math.log10(a);
    }
}