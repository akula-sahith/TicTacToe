package TicTacToe;
import java.util.*;
public class GameLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
        boolean gameover = false;
        char player = 'X';
        while(!gameover){
            printboard(board);
            System.out.println("Player" + "  "+ player + "enter row and column");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if(board[row][column]==' '){
                board[row][column] = player;
                gameover = IsWin(player, board);
                if(gameover){
                    System.out.println("Player"+" " + player + "is win");
                    printboard(board);
                }
                else{
                    player = player=='X' ? 'O' : 'X';
                }
            }
            else{
                System.out.println("Invalid move!Try again");
            }
            
        }
        
    }

   public static boolean IsWin(char player,char[][] board) {
    //row wise
     for (int i = 0; i < board.length; i++) {
        if(board[i][0]==player&&board[i][1]==player&&board[i][2]==player){
            return true;
        }
     }
     //column wise checking
     for (int j = 0; j < board.length; j++) {
        if(board[0][j]==player&&board[1][j]==player&&board[2][j]==player){
            return true;
        }
     }
      //Diagonal wise checking
      if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
         if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }

        return false;
    }

    public static void printboard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
