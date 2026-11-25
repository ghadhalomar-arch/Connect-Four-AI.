
import java.util.Scanner;

public class ConnectFourGame {

int[][] board;
// initallizing the board
public void initiallizeBoard(){
board = new int[6][7];
}
// displaying the board
public void displayBoard(){

for (int i = 0 ; i<6 ; i++){
for(int j =0 ; j <7 ; j++){
System.out.print(board[i][j]+" ");}
System.out.println();
}
}
// which move is a vallid move 
public boolean isValidMove(int column){
if (column>=7||column<0){
return false;
}
return board[0][column]==0;
}
public boolean makeMove(int column , int player){
if (!isValidMove(column)){return false;}
for (int row = 5; row >= 0; row--) {
   if (board[row][column]==0) {
board[row][column]=player;
return true;
   }
}return false;
}
// which player is the winner
public boolean checkWinner(int player){
    // horizontal
for (int row = 0; row < 6; row++) {
    for (int column = 0 ; column <4;column++){// 4 to check the winner 
    if (board[row][column]== player && board[row][column+1]== player && board[row][column+2]== player&&board[row][column+3]== player){return true;} 
    } 
}
    // vartical 
for(int row = 0 ; row <3 ; row++) {
    for(int column =0 ; column<7;column++){ if (board[row][column]== player && board[row+1][column]== player && board[row+2][column]== player&&board[row+3][column]== player){return true;} 
    } }
    // check diagonal down right 
for(int row = 0 ; row < 3 ; row++ ){
    for (int column =0 ;column < 4 ; column++){ if (board[row][column]== player && board[row+1][column+1]== player && board[row+2][column+2]== player&&board[row+3][column+3]== player){return true;} 
    }
}
// check diagonal down left
for (int row = 0 ; row < 3 ; row++){
    for(int column = 3 ; column < 7 ;column++){ if (board[row][column]== player && board[row+1][column-1]== player && board[row+2][column-2]== player&&board[row+3][column-3]== player){return true;} 
    }
}

return false; }

//chaeck if there is a draw
public boolean isDraw(){  
   for (int column = 0 ; column <7;column++){ // chack if there any place left
if (isValidMove(column)){ return false;}   } return true;}

public  void playGame(){
  Scanner input = new Scanner(System.in);
  char player = 'X';

  while (true) { 
      displayBoard();
      System.err.println("player "+player+", choose a column (0-6) : ");
      int column = input.nextInt();
      if (!isValidMove(column)){
        System.out.println("invalid move ! Try again .");
        continue;
      }
      makeMove(column, player);

      if(checkWinner(player)){
        displayBoard();
        System.err.println("player "+player+"wins!");
        break;
      }
      if (isDraw()){
        displayBoard();
        System.err.println("its a draw !");
        break;
      }
      player = (player=='X')? 'O' : 'X' ; 
  }
}
}

