import java.util.Random;
import java.util.Scanner;

public class exeresice7 {
    public static void main(String[] args) {
        final int SIZE_ARRAY=4;
        int[] generatedCode=new int[SIZE_ARRAY];
        int[] userGuessCode=new int[SIZE_ARRAY];
        int routeNumbers=0;
        int checkcode=0;
        boolean ifDouble=false;
        boolean isSurprise=false;
        routeNumbers=routeSelection();
        if(routeNumbers<0){
            routeNumbers=(-routeNumbers);
            isSurprise=true;
        }
        generatedCode=lottery();
        do{
            userGuessCode=(userGuessCode(generatedCode));
            ifDouble=ifDoubleinGuess(userGuessCode);
            if(ifDouble){
                System.out.println("you entered same digit twice! Fined on two occasions ");
                routeNumbers=routeNumbers-2;
            }
            for(int j=0; j< userGuessCode.length;j++) {
                if (userGuessCode[j] != generatedCode[j]) {
                    checkcode++;
                }
            }
            if (checkcode == 0) {
                System.out.print("You WON!!! you guess the code ");
                for(int i=0;i< generatedCode.length;i++){
                    System.out.print(generatedCode[i]);
                }
                break;
            }
            if ((checkcode > 0) && (!isSurprise) && (routeNumbers > 0)) {
                routeNumbers=routeNumbers-1;
                if(routeNumbers != 0){
                    System.out.println("You didnt guess the code, try again - " + (routeNumbers) + " route numbers are left");
                }
            }
            if ((checkcode > 0) && (isSurprise) && (routeNumbers > 0)) {
                System.out.println("You didnt guess the code, try again");
                routeNumbers=routeNumbers-1;
            }
            checkcode=0;

        }
        while(routeNumbers>0);
        if (routeNumbers <= 0) {
            System.out.print("The code is ");
            for(int i=0;i< generatedCode.length;i++) {
                System.out.print(generatedCode[i]);
            }
            System.out.println();
            System.out.println("You couldn't guess the code and you ran out of chances");
        }
    }
    public static int[] lottery(){
        Random random=new Random();
        final int SIZE_ARRAY=4;
        int[] code=new int[SIZE_ARRAY];
        boolean check=true;
        do{
            for(int k=0; k< code.length;k++){
                code[k]= random.nextInt(1,6);
                check=true;
            }
            for(int i=0; i< code.length;i++){
                if(check==false){
                    break;}
                else{
                    check=true;
                }
                    for(int j=i+1; j< code.length;j++){
                        if(code[i]!=code[j]){
                            check=true;}
                        else{
                            check=false;
                            break;
                        }
                    }
            }
        }
        while(check==false);
        return code;
    }
    public static boolean ifDoubleinGuess(int[] userGuess){
        boolean ifDoubleanswer=false;
        for(int i=0;i<userGuess.length;i++) {
            for (int j = i + 1; j < userGuess.length; j++) {
                if (userGuess[i] == userGuess[j]) {
                    ifDoubleanswer=true;}
            }
        }
        return ifDoubleanswer;
    }
    public static int[] userGuessCode(int[] generatedCode) {
        Scanner scanner = new Scanner(System.in);
        final int SIZE_ARRAY = 4;
        int[] userGuess = new int[SIZE_ARRAY];
        int accurateGuess = 0;
        int partialGuess = 0;
        int tempSelection = -1;
        int[] tempArray = new int[SIZE_ARRAY];
        boolean checkVal1 = false;
        do {
            System.out.println("Enter 4 digits guess code, each digit is between 1-6");
            tempSelection = scanner.nextInt();
            if ((tempSelection >= 1111) && (tempSelection <= 6666)) {
                for (int s = tempArray.length - 1; s >= 0; s--) {
                    tempArray[s] = tempSelection % 10;
                    tempSelection = tempSelection / 10;
                    if (tempArray[s] >= 1 && tempArray[s] <= 6) {
                        checkVal1 = true;
                        userGuess[s] = tempArray[s];
                    } else {
                        checkVal1 = false;
                        System.out.println("You enter number is not valid please enter again");
                        break;
                    }
                }
            } else {
                System.out.println("You enter number is not valid please enter again");
                checkVal1 = false;
            }
        }
        while (!checkVal1);
        boolean answer = ifDoubleinGuess(userGuess);
        if (!answer) {
            for (int i = 0; i < userGuess.length; i++) {
                if (userGuess[i] == generatedCode[i]) {
                    accurateGuess++;
                }
            }
            for (int i = 0; i < userGuess.length; i++) {
                for (int j = i + 1; j < userGuess.length; j++) {
                    if (userGuess[i] != generatedCode[i]) {
                        if (userGuess[i] == generatedCode[j]) {
                            partialGuess++;
                        }
                    }
                }
            }
            System.out.println("You Have a " + accurateGuess + " accurate Guesses, and " + partialGuess + " partial Guesses");
        }
        return userGuess;
    }
    public static int routeSelection(){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int userChoice=0;
        int routeNumbers=0;
        do {
            System.out.println("Welcome to Guess Game! you need to guess the four digits number");
            System.out.println("Please choose your route");
            System.out.println("1. Easy route - 20 opportunities");
            System.out.println("2. Medium route - 15 opportunities");
            System.out.println("3. hard route - 10 opportunities");
            System.out.println("4. Surprising route - you dont know how many opportunities");
            userChoice = scanner.nextInt();
            if(userChoice<1||userChoice>4){
                System.out.println("Wrong selection,please enter again");}
        }
        while(userChoice<1||userChoice>4);
        if(userChoice==1){
            routeNumbers=20;}
        if(userChoice==2){
            routeNumbers=15;}
        if(userChoice==3){
            routeNumbers=10;}
        if(userChoice==4){
            routeNumbers= random.nextInt(5,25);
            routeNumbers=(-routeNumbers);}
        return routeNumbers;
    }
}


