import java.util.Scanner;

public class exeresice3 {
    public static void main (String[] args)
    {
        int arr[] = {1,4,7,1,8,9,2,1,3,8,0}; //insert array
        removeDuplicateElement(arr);
}
        public static void removeDuplicateElement(int oldArray[]) {
            int counter = 0;
            for (int i = 0; i < oldArray.length; i++) {
                for (int j = 0; j <+ i; j++) {
                    if(i!=j){
                        if (oldArray[j] == oldArray[i]) {
                            counter++;
                            break;
                        }
                    }
                }
            }
            //System.out.print(oldArray.length - counter);
            int[] newArray = new int[oldArray.length - counter];
            newArray[0] = oldArray[0];
            //System.out.print(newArray[0]);
            int seen = 0;
            int k = 1;
            for (int i=1; i<oldArray.length; i++){
                for(int j=0; j<=k; j++){
                    if (oldArray[i] == newArray[j])
                        seen++;
                }
                //System.out.print(seen);
                if(seen == 0){
                    newArray[k] = oldArray[i];
                    k++;
                }
                seen = 0;
            }
            for (int i=0; i<newArray.length; i++)
                System.out.print(newArray[i]+" ");
        }
    }
