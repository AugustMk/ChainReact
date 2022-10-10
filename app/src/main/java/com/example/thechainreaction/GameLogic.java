package com.example.thechainreaction;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;


public class GameLogic {



    public static int playing = selectPlayersPage.play ;   // var for  the number of players
<<<<<<< HEAD
    public static int[][]  gridArr = new int[10][6];              // arr for the grid
    private Button  restartGame ;
    public static ArrayList<Integer> currentPlayers =  new ArrayList<Integer>();  // lst for the players
=======
    public static int[][]  gridArr = new int[10][6];              // arr for the gridArr
    public static ArrayList<Integer> currentPlayers = new ArrayList<>();  // lst for the players
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    public static int  player = 1  ;                       // var for the current player


    public  GameLogic(){
        player();
        while(!isWin()){
            if (canPlay(player)){
                //insertB(int r , int c );
                explodeAll();
                eliminatePlayer();
                player = nextPlayer();
            }

        }
    }
       /*
      0 -> EMPTY CELL
     1 - > PLAYER 1 : COLOR RED
     2 - >  PLAYER 2 : COLOR WHITE
     3 -> PLAYER 3 : BLUE
     4 -> PLAYER 4 : SKY BLUE
     5 -> PLAYER 5 : YELLOW
     6 -> PLAYER 6 : LIGHT PURPLE
     7 -> PLAYER 7 : DARK PURPLE
     8 - > PLAYER 8 : PINK
     9 - > PLAYER 9 : GREEN
     */

<<<<<<< HEAD

    private void createGrid() {
        /**
         *  insert  zeros into the grid to represent an empty cell
         * @param none
         */

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 6; i++) {
                gridArr[k][i] = 0;
            }

        }

=======
    public int[][] getGridArr() {
        return gridArr;
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    }

    private void  player(){
        /**
         *  insert the players into the current players list
         * @param none
         */
        for(int k = 1 ; k <= playing  ; k ++){
            currentPlayers.add(k) ;
        }
    }

    public void setPlayer() {
        /**
         *   change the player
         * @param none
         */
        boolean firstPlayerTurn = player == playing || currentPlayers.size()==1 || currentPlayers.indexOf(player) == currentPlayers.size();
        player = (firstPlayerTurn) ?  currentPlayers.get(0) : currentPlayers.get(player);
    }

    public static int nextPlayer(){
        /**
         *   checks who's playing after the current player
         * @param none
         */
<<<<<<< HEAD
        boolean firstplayerturn = player == playing || currentPlayers.size()==1 || currentPlayers.indexOf(player) == currentPlayers.size();
        return (firstplayerturn) ?  currentPlayers.get(0) : currentPlayers.get(player);
    }
    // get the grid array
    public  static int[][] getGridArr() {

        return gridArr;
=======
        boolean firstPlayerTurn = player == playing || currentPlayers.size()==1 || currentPlayers.indexOf(player) == currentPlayers.size();
        return (firstPlayerTurn) ?  currentPlayers.get(0) : currentPlayers.get(player);
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    }


    public  boolean insertB(int r , int c ){
        /**
         * placing the  player's orb into the array
         *  first letter represent the color of the player , and the second letter  represent the number of players to place in cell
         * @param  (r)row and c(column)
         */
<<<<<<< HEAD
=======
        /*
        MUST READ !!!!!!

        AN OCCUPIED CELL IS REPRESENTED BY TWO NUMBERS , THE FIRST NUMBER REPRESENT THE COLOR AND THE LAST NUMBER REPRESENT
        THE NUMBER OF ORBS IN  THAT CELL
        E.G IF  IF GRID[5][2] = 23 , IT MEANS THE CELL IS OCCUPIED BY  PLAYER WHITE AND THE CELL HAS BEEN FILED WITH THREE ORBS
         */

>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
        if(gridArr[r][c] ==0){   //checks if the cell is empty
            gridArr[r][c] = (player +1) *10 + 1 ;
            return true ;
        }else if ((gridArr[r][c]) /10 ==(player +1) && (gridArr[r][c]) % 10 < 3){
            gridArr[r][c] +=1;
            return true ;
        }

<<<<<<< HEAD
        else if(gridArr[r][c]/ 10 != player){  // checks if the cell clicked contains the balls of the player
            return false ;
        }
        else if(isCorner(r , c)  && gridArr[r][c]%10 ==1) {     // checks if the  cell clicked is at the corner and cotains one orb
            handleCornerExplosion(r, c,player);
            return true ;

        }else if(isEdge(r , c ) && gridArr[r][c]%10 ==2  ) {   // checks if the  cell clicked is at the edge and cotains 2 orbs
            handleEdgeExplosion(r, c, player);
            return true;

        }else if (gridArr[r][c]%10 == 3){          //checks if the  cell contains 3 orbs ;
            handleExplosion(r , c , player);
            return true ;

        } else if (gridArr[r][c] >0  && gridArr[r][c]%10 < 3  ){   // increment the number of orbs in a cell ;
            gridArr[r][c] =gridArr[r][c] +1;
            return true;
        }

        return false;
    }


    private  boolean isEdge( int r , int c){
        /**
         * checks whether the cell clicked is at the edge
         * @param (r)row and c(column)
         **/
        return ((r==0 || r == 9) && c != 0 &&  c != 5)|| ( (c == 0 || c == 5) && r != 0  && r != 9);
    }

    private  boolean isCorner(int r , int c){
        /**
         * checks whether the cell clicked is at the corner
         * @param (r)row and c(column)
         **/
        return (r == 0 && (c == 0|| c == 5))|| ( r == 8 && ( c == 0 || c == 5));
    }
=======
            return false;
        }
        private  boolean isEdge( int r , int c){
            /**
             * checks whether the cell clicked is at the edge
             * @param (r)row and c(column)
             **/
            return (r == 0 && c == 0) || (r == 9 && c == 5);
        }

        private  boolean isCorner(int r , int c){
            /**
             * checks whether the cell clicked is at the corner
             * @param (r)row and c(column)
             **/
            return (r ==0 || r == 9) && (c ==0 || c== 5);
        }
        private boolean isCentre(int row, int column){
        return !(isCorner(row,column) || isEdge(row,column));
        }
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d


    //handle explosions that are at the  edges
    private void handleEdgeExplosion(int r , int c, int p){
        /**
         *  handles the explosions which occur at the edges
         * @param (r)row and c(column)  and p (player)
         **/
<<<<<<< HEAD

        if( c== 0 || c == 5){
            explode( r+1 ,  c , p);
            explode( r-1 ,c , p );
            if (c == 0 ){explode(r , c+1 , p );}
            else  { explode(r, c -1, p ); }


        } else if (r == 0 || r == 8){
            explode( r ,  c-1 , p);
            explode( r ,c+1 , p );
            if (r == 0 ){explode(r+1 , c , p );}
            else  { explode(r-1, c , p ); }

        }
        gridArr[r][c] = 0 ;  // remove the orbs in the exploding cell

=======
         //top edge
         gridArr[r][c] = 0;
         if (r == 0 && (c !=0 && c != 5)){
            gridArr[r][c+1] = (10*p) + gridArr[r][c+1]%10 + 1;
            gridArr[r][c-1] = (10*p) + gridArr[r][c-1]%10 + 1;
            gridArr[r+1][c] = (10*p) + gridArr[r+1][c]%10 + 1;
         }
         //bottom edge
         else if (r == 9 && (c !=0 && c != 5)){
            gridArr[r][c+1] = (10*p) + gridArr[r][c+1]%10 + 1;
            gridArr[r][c-1] = (10*p) + gridArr[r][c-1]%10 + 1;
            gridArr[r-1][c] = (10*p) + gridArr[r-1][c]%10 + 1;
         }
         //left edge
         else if (c == 0 && (r !=0 && r != 9)){
            gridArr[r+1][c] = (10*p) + gridArr[r+1][c]%10 + 1;
            gridArr[r-1][c] = (10*p) + gridArr[r-1][c]%10 + 1;
            gridArr[r][c+1] = (10*p) + gridArr[r][c+1]%10 + 1;
         }
         //right edge
         else if (c == 5 && (r !=0 && r != 9)){
            gridArr[r+1][c] = (10*p) + gridArr[r+1][c]%10 + 1;
            gridArr[r-1][c] = (10*p) + gridArr[r-1][c]%10 + 1;
            gridArr[r][c-1] = (10*p) + gridArr[r][c-1]%10 + 1;
         }
       
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    }

    //
    private void handleCornerExplosion(int row , int column , int p){
        /**
         * handle the explosions that are happening at the corners
         * @param (r)row , c(column)  and  p (player)
         **/
<<<<<<< HEAD

        if( r== 0) {explode(r+1 , c , p );} else{explode(r-1 , c , p );}
        if (c==0){ explode(r, c+1 , p );} else {  explode(r, c-1 , p );}
        gridArr[r][c] = 0 ;   // remove the orbs in the exploding cell
=======
         //top left corner
         if (row == 0 && column == 0) {
            gridArr[0][0] = 0;
            gridArr[0][1] = (10*p) + gridArr[0][1]%10 + 1;
            gridArr[1][0] = (10*p) + gridArr[1][0]%10 + 1;
        }
        //bottom left corner
        else if (row == 9 && column == 0){
            gridArr[0][9] = 0;
            gridArr[8][0] = (10*p) + gridArr[8][0]%10 +1;
            gridArr[9][1] = (10*p) + gridArr[9][1]%10 +1;
        }
        //top right corner
        else if (row == 0 && column == 9){
            gridArr[0][5] = 0;
            gridArr[0][4] = (10*p) + gridArr[0][4]%10 +1;
            gridArr[1][5] = (10*p) + gridArr[1][5]%10 +1;
        }
        //bottom right corner
        else {
            gridArr[9][5] = 0;
            gridArr[8][5] = (10*p) + gridArr[8][5]%10 +1;
            gridArr[9][4] =  (10*p) + gridArr[9][4]%10 +1;
        }
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    }

    //
    private void handleExplosion(int r , int c , int p){
        /**
         * handle explosions that are happening anywhere except the corners or the edge
         * @param (r)row , c(column)  and  p (player)
         **/
<<<<<<< HEAD

        explode( r ,  c-1 , p);
        explode( r ,c+1 , p );
        explode(r+1 , c , p );
        explode(r-1 , c , p );
        gridArr[r][c] = 0 ;     // remove the orbs in the exploding cell
=======
         gridArr[r][c] = 0;
         gridArr[r][c+1] = (10*p) + gridArr[r][c+1]%10 + 1;
         gridArr[r][c-1] = (10*p) + gridArr[r][c-1]%10 + 1;
         gridArr[r+1][c] = (10*p) + gridArr[r+1][c]%10 + 1;
         gridArr[r-1][c] = (10*p) + gridArr[r-1][c]%10 + 1;
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
    }

    // move
    public void explode( int r , int c , int p) {
        /**
         *  change the color of the orbs  in a cell which an orb explode to and move the orb to the  cell
         * @param (r)row , c(column)  and  p (player)
         **/
<<<<<<< HEAD

        if (gridArr[r][c] / 10 != p) {
            gridArr[r][c] = p * 10 +  (gridArr[r][c] % 10);   // change the color of the orbs to that of the exploding orbs
            insertB(r , c);
        } else{
            insertB(r , c);
=======
         if (isEdge(r,c)) handleEdgeExplosion(r,c,p);
         else if (isCorner(r,c)) handleCornerExplosion(r,c,p);
         else handleExplosion(r,c,p);
    }
    public boolean isCellEmpty(int row, int column){
        return gridArr[row][column]==0;
    }
    public  boolean isUnstableCell(int row, int column){
        // return boolean: is this cell unstable
        if (isCellEmpty(row,column)) return false;
        else if (isCorner(row,column) && gridArr[row][column]%10 >1 ) return true;
        else if (isEdge(row,column) && gridArr[row][column]%10 >2) return true;
        else if (isCentre(row,column) && gridArr[row][column]%10 >3) return true;
        return true;
    }
    public  boolean isUnstableGrid(){
        // return boolean: are there any unstable cells
        for (int row =0; row<10;row++){
            for (int column = 0; column<6;column++){
                if (isUnstableCell(row,column)){
                    return true;
                }
            }
        }
        return false;
    }
    public void explodeAll(){
        //explodes unstable cells until the grid is stable
        boolean unstable = isUnstableGrid();
        while (unstable){
            for (int row =0; row<10;row++){
                for (int column = 0; column<6;column++){
                    if (isUnstableCell(row,column)){
                        explode(row,column,player);
                    }
                }
            }
            unstable = isUnstableGrid();
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
        }
    }

    // restart the game
   public void restart() {
       /**
        *  clears the boards and reset the players
        * @param none
        *
        **/
       for (int i = 0; i < 6; i++) {
           for (int w = 0; w < 10; w++) {
               gridArr[i][w] = 0;
           }
       }
   }



    // checks if a player's orbs have been eliminated and removes the player from playing
    public void eliminatePlayer() {
        /**
<<<<<<< HEAD
         *  clears the boards and reset the players
         * @param none
         *
         **/
        currentPlayers.clear();
        for (int k = 0 ; k < 9 ; k++) {
            for (int i = 0; i < 6; i++) {
                gridArr[k][i] = 0;       //change every element in the 2d array to 0
            }
        }
        for(int k = 1 ; k <= playing  ; k ++){
            currentPlayers.add(k) ;
        }
        player = currentPlayers.get(0);          //reset the  player counter
    }

    //checks if only one player is playing and declare the winner
//    public  boolean checkWin(){
//         return currentPlayers.size()==1 ;
//    }


    // checks if a player's orbs have been elimated and removes the player from playing
    public void eliminatePlayer( ) {
        /**
         *  removes  the players from the  grid  if elimated
=======
         *  removes  the players from the  gridArr  if the player's orbs are removed
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
         * @param (none
         **/
        if (Grid.rounds >= playing) {
            for (Iterator<Integer> iterator = currentPlayers.iterator(); iterator.hasNext(); ) {
                int value = iterator.next();
                if (!(checkPlayer(value))) {
                    iterator.remove();
                }
            }
        }
    }


    //checks if the player is still in the board
    private static boolean checkPlayer(int j){
        /**
         * checks if the orbs of the player has been removed
         * @param j (player number)
         */
<<<<<<< HEAD
        for (int k = 0 ; k < 9 ; k++) {
            for (int i = 0; i < 6; i++) {
                if (gridArr[k][i] / 10 == j) {
                    return true;
                }
=======
        for (int i = 0; i < 6; i++) {
            for (int w = 0; w < 10; w++) {
                if ((gridArr[i][w]) / 10 == j) return true;
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
            }
        }

        return false ;
    }

    //checks if the player can play
        public  boolean canPlay(int p){
        /**
         * checks if the player can play
         * @param p (player)
<<<<<<< HEAD
         */
        return currentPlayers.contains(p);
    }
    public void setbtn(Button btn){
        this.restartGame = btn ;
    }
=======
         **/
         for (int i: currentPlayers){
            if (i ==p) return true;
         }
        return false;
   }
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d

    public  boolean isWin(){
        /**
         * checks if there's a winner/ win
         * @param none
         */
<<<<<<< HEAD
        boolean winner = currentPlayers.size()== 1 ;
        if(winner){
            restartGame.setVisibility(View.VISIBLE);
        }
        return  winner;
    }


    public  int  getWinner(){
=======
        int numberAlive = 0;
        for (int player : currentPlayers) {
            if (checkPlayer(player)) {
                numberAlive++;
            }
        }
        return numberAlive <= 1;
    }

    public static  int  getWinner(){
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d
        /**
         * get the winner
         * @param none
         */
<<<<<<< HEAD
        return  currentPlayers.get(0);
=======
         if (currentPlayers.size() ==1) return currentPlayers.get(0);
>>>>>>> 5bb91e52aec187014a524478187314113c2bf08d

         return -1;
   }
}
