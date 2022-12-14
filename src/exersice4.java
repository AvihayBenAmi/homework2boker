public class exersice4 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int index;
        index = upAndDownArray(array);
        System.out.print(index);
    }

    public static int upAndDownArray(int newArray[]) {
        final int TOP=-1;
        int index = TOP;
        boolean check = true;
        for (int i = 0; i < newArray.length - 1; i++) {
            if (newArray[i] < newArray[i + 1]) {
                index = i + 1;//
            } else {
                break;
            }
        }
        if (index>-1) {
            for (int j = index; j < newArray.length - 1; j++) {
                if (newArray[j] > newArray[j + 1]) {
                    check = true;}
                else {
                    check = false;
                    break;
                }
            }
            if (check == false) {
                index = -1;}
        }
        else {
            index = -1;}
        return index;
    }
}