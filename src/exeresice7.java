import java.util.Random;
import java.util.Scanner;

public class exeresice7 {
    public static void main(String[] args) {
        int[] generatedCode=new int[4];
        int[] userGuessCode=new int[4];
        int routeNumbers=0;
        boolean ifDouble=false;
        routeNumbers=routeSelection();
        generatedCode=lottery();
        userGuessCode(generatedCode);
        System.out.println(ifDouble=ifDoubleinGuess(userGuessCode));

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
        int[] userGuess = new int[4];
        int accurateGuess=0;
        int partialGuess=0;
            for (int i = 0; i < userGuess.length; i++) {
                int tempSelection = -1;
                boolean check=false;
                do{
                    int temp = i + 1;
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
            routeNumbers= random.nextInt(5,25);}
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


