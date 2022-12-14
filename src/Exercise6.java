import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String quadraticEquation;
        int a,b,c;
        System.out.println("Enter your quadratic equation");
        quadraticEquation = scanner.nextLine();
        validate(quadraticEquation);
        a = aParameter(quadraticEquation);
        b = bParameter(quadraticEquation);
        c = cParameter(quadraticEquation);
        calculate(quadraticEquation, a, b, c);
    }

    public static boolean validate(String quad) {
        int xToThePower = quad.indexOf("x^2");
        String subs = quad.substring(xToThePower + 1, quad.length());
        int xValue = subs.indexOf("x");
        int index0 = quad.indexOf("=0");
        char sign1;
        char sign2;
        boolean check = true;
        sign1 = quad.charAt(xToThePower + 3);
        sign2 = subs.charAt(xValue + 1);
        if ((index0 == -1 || xToThePower == -1 || xValue == -1) && (sign2 != '+' || sign2 != '-')) {
            System.out.println("This is not a valid quadratic equation");
            check = false;
        }
        return check;
    }

    public static int aParameter(String quad) {
        int xToThePower = quad.indexOf("x^2");
        int parameterValue = 0;
        String a;
        if (xToThePower == 0) {
            parameterValue = 1;
        } else {
            a = quad.substring(0, xToThePower);
            if ((a.charAt(0) == '-') && (xToThePower == 1)) {
                parameterValue = -1;
            } else {
                parameterValue = Integer.parseInt(a);
            }
        }
        return parameterValue;
    }

    public static int bParameter(String quad) {
        int xToThePower = quad.indexOf("x^2");
        String subs = quad.substring(xToThePower + 3, quad.length());
        int xValue = subs.indexOf("x");
        int bp;
        String b;
        b = subs.substring(0, xValue);
        if ((b.charAt(0) == '-') && (xValue == 1)) {
            bp = -1;
        } else {
            bp = Integer.parseInt(b);
        }
        return bp;
    }

    public static int cParameter(String quad) {
        int xToThePower = quad.indexOf("x^2");
        String subs = quad.substring(xToThePower + 3, quad.length());
        int xValue = subs.indexOf("x");
        int index0 = subs.indexOf("=0");
        int cParameter;
        String c;
        c = subs.substring(xValue + 1, index0);
        if ((c.charAt(0) == '-') && (index0 == 1)) {
            cParameter = -1;
        } else {
            cParameter = Integer.parseInt(c);
        }
        return cParameter;
    }

    public static void calculate(String quad, int a, int b, int c) {
        double pow = Math.pow(b, 2);
        double sqrt = Math.sqrt(pow - 4 * a * c);
        if (sqrt < 0 || Double.isNaN(sqrt) ) {
            System.out.println("There are no solutions for this quadratic equation");
        } else {
            double solution1 = ((-b) + sqrt) / (2 * a);
            double solution2 = ((-b) - sqrt) / (2 * a);
            if (solution1 == solution2) {
                System.out.println("There is one solution for this quadratic equation, x1= " + solution1);
            } else {
                System.out.println("There are two solutions for this quadratic equation, x1= " + solution1 + ", x2 = " + solution2);
            }
        }

    }
}
