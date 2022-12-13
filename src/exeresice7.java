import java.util.Random;
import java.util.Scanner;

public class exeresice7 {
    public static void main(String[] args) {
        int[] generatedCode=new int[4];
        int[] userGuessCode=new int[4];
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
        for(int i=1; i<=routeNumbers;i++){
            userGuessCode=(userGuessCode(generatedCode));
            ifDouble=ifDoubleinGuess(userGuessCode);
            if(ifDouble==true){
                System.out.println("you entered same digit twice! Fined on two occasions ");
                routeNumbers=routeNumbers-2;
            }
            for(int j=0; j< userGuessCode.length;j++) {
                if (userGuessCode[j] != generatedCode[j]) {
                    checkcode++;
                }
            }
                if (checkcode == 0) {
                    System.out.println("You WON!!! you guess the code " + generatedCode);
                    break;
                }
                if ((checkcode > 0) && (isSurprise != true) && (routeNumbers > 0)) {
                    System.out.println("You didnt guess the code, try again - " + (routeNumbers - i) + " route numbers are left");
                    checkcode = 0;
                }
                if ((checkcode > 0) && (isSurprise == true) && (routeNumbers > 0)) {
                    System.out.println("You didnt guess the code, try again");
                    routeNumbers = routeNumbers - i;
                    checkcode = 0;
                }
                if (routeNumbers < 0) {
                    System.out.println("The code is " + generatedCode);
                    System.out.println("You couldn't guess the code and you ran out of chances");
                }
        }
        }
    public static int[] lottery(){
        Random random=new Random();
        int[] code=new int[4];
        boolean check=true;
        do{
        for(int k=0; k< code.length;k++){
            code[k]= random.nextInt(1,6);
            //System.out.print(code[k]);
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
    public static int[] userGuessCode(int[] generatedCode) {
        Scanner scanner=new Scanner(System.in);
        final int SIZE_ARRAY=4;
        int[] userGuess = new int[SIZE_ARRAY];
        int accurateGuess=0;
        int partialGuess=0;
        int tempSelection = -1;
            for (int i = 0; i < userGuess.length; i++) {
                boolean check=false;
                do{
                    int temp=i+1;
                    System.out.println("Enter Number " + temp);
                    tempSelection = scanner.nextInt();
                    if (tempSelection >= 1 && tempSelection <= 6) {
                        check = true;
                        userGuess[i] = tempSelection;}
                    else{
                        System.out.println("You enter number are not between 1-6, please enter again");
                        check = false;}
                  }
                while(check==false);
            }
        for(int i=0; i< userGuess.length;i++){
                if(userGuess[i]==generatedCode[i]){
                    accurateGuess++;}
                }
        for(int i=0;i<userGuess.length;i++) {
            for (int j = i + 1; j < userGuess.length; j++) {
                if (userGuess[i]!=generatedCode[i]) {
                    if (userGuess[i] == generatedCode[j]) {
                        partialGuess++;}
                }
            }
        }
        System.out.println("You Have a "+accurateGuess+" accurate Guesses, and "+partialGuess+" partial Guesses");
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
            System.out.println("4. Surprising route - you dony know how many opportunities");
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


    }


