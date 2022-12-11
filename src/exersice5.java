import java.util.Scanner;

public class exersice5 {
    public static void main(String[] args) {
        char[] board = {'-','-','-','-','-','X','-','-','-'};
        int position = 5;
        boolean isAv = true;
        printBoard(board);
        isAv = isAvailavble(board, position);
        System.out.println(isAv);
        getPostionFromUser(board);

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
            if ((board[position] == '0') || (board[position] == 'X')) {
                answer = true;
            } else {
                answer = false;
            }
        }
        return answer;
    }

    public static void getPostionFromUser(char board[]) {
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        boolean answer=true;
        do {
            System.out.println("Enter the place when you write your symbol");
            position = scanner.nextInt();
            if (position < 1 || position > 9) {
                System.out.println("Wrong value,please enter again");}
            }
            while (position < 1 || position > 9);{}
        do{

        }
        if (answer == false) {
            answer = isAvailavble(board, position);
            System.out.println("not Availavble place, try again");}
    }
}
