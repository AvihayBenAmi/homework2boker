import java.util.Scanner;

public class exersice1 {
    public static void main(String []args){
        theBigNumbersThanAvg();
    }
    public static void theBigNumbersThanAvg(){
        Scanner scanner=new Scanner(System.in);
        int[] array=new int[10];
        int sum=0;
        int avg=0;
        System.out.println("Enter 10 numbers");
        for(int i=0; i< array.length; i++){
            array[i]=scanner.nextInt();
            sum=sum+array[i];
        }
        avg=sum/10;
        System.out.println("the avg is "+avg);
        for(int i=0;i< array.length;i++){
            if(array[i]>avg){
                System.out.println(array[i]);}
        }
    }
}
