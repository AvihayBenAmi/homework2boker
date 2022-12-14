import java.util.Scanner;

public class exersice2 {
    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        String phoneNumber;
        System.out.println("Enter Your Phone Number");
        phoneNumber = scanner.nextLine(); //scan phone number
        System.out.println(normalPhoneNubmer(phoneNumber)); //print the calculate from function
    }
    public static String normalPhoneNubmer(String phoneNumber){
        String newPhoneNumber = new String();
        char[] temp = {'9','7','2','5'}; //intro chares
        int check=0;
        if(phoneNumber.length()<10) {
            if (phoneNumber.length() == 10) { //if the phone number without '-'
                newPhoneNumber = phoneNumber.substring(0, 3) + '-' + phoneNumber.substring(3, 10);
            }
            if (phoneNumber.length() == 11) { // if the phone number is currect
                if (phoneNumber.charAt(3) == '-') {
                    newPhoneNumber = phoneNumber;
                }
            }
            if (phoneNumber.length() == 12) { //if the phone number is with international intro
                for (int i = 0; i < 4; i++) {
                    if (temp[i] == phoneNumber.charAt(i)) {
                        check++;
                    }
                }
                if (check == 4) {
                    newPhoneNumber = '0' + phoneNumber.substring(3, 12);
                }
                newPhoneNumber = newPhoneNumber.substring(0, 3) + '-' + newPhoneNumber.substring(3, 10);
            }
        }
        else{
            System.out.println("invalid number,please enter again");
        }
        return newPhoneNumber;
    }
}
