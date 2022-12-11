import java.util.Scanner;

public class exersice5 {
    public static void main(String[] args) {
        char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
        char player1 = 'X';
        char player2 = '0';
        char[] turns = {player1, player2, player1, player2, player1, player2, player1, player2, player1};
        int position = -1;
        boolean winner=false;
        char symbolOfWinner;
            for (int i = 0; i < turns.length; i++) {
                System.out.println(turns[i]);
                position = getPostionFromUser(board);
                winner = placeSymbolOnBoard(board, position, turns[i]);
                if (winner == true) {
                    symbolOfWinner = checkWinner(board);
                    System.out.print("we have a winner! " + symbolOfWinner);
                    break;
                }
            }
            if(!winner) {
                System.out.println("there is no winner");
            }
    }
    public static void printBoard(char board[]) {
        System.out.print(board[0] + " " + board[1] + " " + board[2]);
        System.out.println();
        System.out.print(board[3] + " " + board[4] + " " + board[5]);
        System.out.println();
        System.out.print(board[6] + " " + board[7] + " " + board[8]);
        System.out.println();
    }
    public static boolean isAvailavble(char board[], int position) {
        boolean answer = true;
        for (int i = 0; i < board.length; i++) {
            if ((board[position-1] == '0') || (board[position-1] == 'X')) {
                answer = false;
            } else {
                answer = true;
            }
        }
        return answer;
    }
    public static int getPostionFromUser(char board[]) {
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        boolean answer=false;
        do {
            System.out.println("Enter the place where you write your symbol");
            position = scanner.nextInt();
            if (position < 1 || position > 9) {
                System.out.println("Wrong value,please enter again");}
            else{
                answer = isAvailavble(board, position);
                if(answer == false){
                    System.out.println("not Availavble place, try again");}
                 }
            }
            while (answer==false);
        System.out.println("its Availavble place!");
        return position;
    }
    public static char checkWinner(char[] board){
        if(((board[0]=='X')&&(board[4]=='X')&&(board[8]=='X'))||((board[0]=='0')&&(board[4]=='0')&&(board[8]=='0'))){
            return board[0];}
        if(((board[2]=='X')&&(board[4]=='X')&&(board[6]=='X'))||((board[2]=='0')&&(board[4]=='0')&&(board[6]=='0'))){
            return board[2];}
        if(((board[0]=='X')&&(board[1]=='X')&&(board[2]=='X'))||((board[0]=='0')&&(board[1]=='0')&&(board[2]=='0'))){
            return board[0];}
        if(((board[3]=='X')&&(board[4]=='X')&&(board[5]=='X'))||((board[3]=='0')&&(board[4]=='0')&&(board[5]=='0'))){
            return board[3];}
        if(((board[6]=='X')&&(board[7]=='X')&&(board[8]=='X'))||((board[6]=='0')&&(board[7]=='0')&&(board[8]=='0'))){
            return board[6];}
        if(((board[0]=='X')&&(board[3]=='X')&&(board[6]=='X'))||((board[0]=='0')&&(board[3]=='0')&&(board[6]=='0'))){
            return board[0];}
        if(((board[1]=='X')&&(board[4]=='X')&&(board[7]=='X'))||((board[1]=='0')&&(board[4]=='0')&&(board[7]=='0'))){
            return board[1];}
        if(((board[2]=='X')&&(board[5]=='X')&&(board[8]=='X'))||((board[2]=='0')&&(board[5]=='0')&&(board[8]=='0'))){
            return board[2];}
        return '-';
    }
    public static boolean placeSymbolOnBoard(char[] board, int position, char symbol){
        char winner;
        board[position-1]=symbol;
        printBoard(board);
        winner=checkWinner(board);
        if(winner=='X'||winner=='0'){
            return true;}
        else{
            return false;}
    }
}
