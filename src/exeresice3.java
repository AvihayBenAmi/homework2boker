import java.util.Scanner;

public class exeresice3 {
    public static void main (String[] args)
    {
        int arr[] = {1,1,4,5,5,7};
        removeDuplicateElement(arr);
}
        public static void removeDuplicateElement(int oldArray[])
        {
            int counter = 0;
            for (int l = 0; l < oldArray.length; l++) {
                for (int n = 0; n <+ l; n++) {
                    if(l!=n){
                        if (oldArray[n] == oldArray[l]) {
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
