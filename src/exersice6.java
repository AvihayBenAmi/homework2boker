import java.util.Scanner;

public class exersice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String quad = new String();
        int a;
        int b;
        int c;
        boolean checkIfValid = true;
        System.out.println("Enter your quadratic equation");
        quad = scanner.nextLine();
        //if (quad.length() >= 8) {
            checkIfValid = validate(quad);
            if (!checkIfValid) {
                System.out.println("this is not valid quadratic equation");
            } else {
                a = aParameter(quad);
                b = bParameter(quad);
                c = cParameter(quad);
                calculate(quad, a, b, c);
            }
        }
        //else{
            //System.out.println("this is not valid quadratic equation");
        //}
    //}
    public static boolean validate(String quad) {
        int indexx2 = quad.indexOf("x^2");
        String subs = quad.substring(indexx2 + 1, quad.length());
        int indexx = subs.indexOf("x");
        int index0 = quad.indexOf("=0");
        char sign1;
        char sign2;
        boolean check = true;
        if (quad.length() >= 8) {
            sign1 = quad.charAt(indexx2 + 3);
            sign2 = subs.charAt(indexx + 1);
            if ((index0 == -1 || indexx2 == -1 || indexx == -1) && ((sign1 != '+') || (sign1 != '-')) && ((sign2 != '+') || (sign2 != '-'))) {
                System.out.println("This is not Valid quardric equation");
                check = false;
            }
        }
        else{
            check=false;}
        return check;
    }
    public static int aParameter(String quad) {
        int indexx2 = quad.indexOf("x^2");
        int ap = 0;
        String a;
        if (indexx2 == 0) {
            ap = 1;
        } else {
            a = quad.substring(0, indexx2);
            if ((a.charAt(0) == '-') && (indexx2 == 1)) {
                ap = -1;
            } else {
                ap = Integer.parseInt(a);
            }
        }
        return ap;
    }
    public static int bParameter(String quad){
        int indexx2=quad.indexOf("x^2");
        String subs=quad.substring(indexx2+3,quad.length());
        int indexx=subs.indexOf("x");
        int bp=0;
        String b;
        b=subs.substring(0,indexx);
        if((b.charAt(0)=='-')&&(indexx==1)){
            bp=-1;}
        else{
            bp=Integer.parseInt(b);}
        return bp;
    }
    public static int cParameter(String quad){
        int indexx2=quad.indexOf("x^2");
        String subs=quad.substring(indexx2+3,quad.length());
        int indexx=subs.indexOf("x");
        int index0=subs.indexOf("=0");
        int cp=0;
        String c;
        c=subs.substring(indexx+1,index0);
        if((c.charAt(0)=='-')&&(index0==1)){
            cp=-1;}
        else{
            cp=Integer.parseInt(c);}
        return cp;
    }
    public static void calculate(String quad, int a, int b, int c){
        double pow=Math.pow(b,2);
        double sqrt = Math.sqrt(pow-(4*a*c));
        if((sqrt<0)||Double.isNaN(sqrt)){
            System.out.println("There is no solutions for this quardric equation");
        }
        else{
            double solution1=((-b)+sqrt)/(2*a);
            double solution2=((-b)-sqrt)/(2*a);
            if(solution1==solution2){
                System.out.println("There is one solution for this quardric equation, x1= "+solution1);}
            else{
                System.out.println("There is tow solutions for this quardric equation, x1= "+solution1+", x2 = "+solution2);}
            }
        }
    }
