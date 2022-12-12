import java.util.Scanner;

public class exersice1 {
    public static void main(String []args)
    {
        theBigNumbersThanAvg();
    }
    public static void theBigNumbersThanAvg(){
        Scanner scanner=new Scanner(System.in);
        final int SIZE_ARRAY=10;
        int[] array=new int[SIZE_ARRAY];
        int sum=0;
        int avg=0;
        System.out.println("Enter 10 numbers"); //scan 10 numbers
        for(int i=0; i< array.length; i++){
            array[i]=scanner.nextInt();
            sum=sum+array[i]; //summery for all numbers
        }
        avg=sum/10; //calculate average
        System.out.println("the avg is "+avg);
        for(int i=0;i< array.length;i++){
            if(array[i]>avg){
                System.out.println(array[i]);} //print the numbers than bigger from avg
        }
    }
}
