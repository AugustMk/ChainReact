package com.example.thechainreaction;

import java.util.ArrayList;
import java.util.Iterator;


public class GameLogic {



    public static int playing = selectPlayersPage.play ;   // var for  the number of players
    public int[][]  gridArr = new int[10][6];              // arr for the grid
    public static ArrayList<Integer> currentPlayers =  new ArrayList<Integer>();  // lst for the players
    public static int  player = 1  ;                       // var for the current player


    public  GameLogic(){
        createGrid();
        player();
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


    private void createGrid() {
        /**
         *  insert  zeros into the grid to represent an empty cell
         * @param none
         */


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
        boolean firstplayerturn = this.player == playing || currentPlayers.size()==1 || currentPlayers.indexOf(player) == currentPlayers.size();
        this.player = (firstplayerturn) ?  currentPlayers.get(0) : currentPlayers.get(player);
    }

    public static int nextPlayer(){
        /**
         *   checks who's playimg after the current player
         * @param none
         */
        boolean firstplayerturn = player == playing || currentPlayers.size()==1 || currentPlayers.indexOf(player) == currentPlayers.size();
        return (firstplayerturn) ?  currentPlayers.get(0) : currentPlayers.get(player);
    }


    public int[][] getGridArr() {
        return gridArr;
    }


    public  boolean insertB(int r , int c ){

        /**
         * placing the  player's orb into the array
         *  first letter represent the color of the player , and the second letter  represent the number of players to place in cell
         * @param  (r)row and c(column)
         */
        /*
        MUST READ !!!!!!

        AN OCCUPIED CELL IS REPRESENTED BY TWO NUMBERS , THE FIRST NUMBER REPRESENT THE COLOR AND THE LAST NUMBER REPRESENT
        THE NUMBER OF ORBS IN  THAT CELL
        E.G IF  IF GRID[5][2] = 23 , IT MEANS THE CELL IS OCCUPIED BY  PLAYER WHITE AND THE CELL HAS BEEN FILED WITH THREE ORBS
         */
        if(gridArr[r][c] ==0){   //checks if the cell is empty
            gridArr[r][c] = player* 10 +1  ;
            return true ;}

         //u have to vhecl for other conditions !!

        return false;
    }


    private  boolean isEdge( int r , int c){
        /**
         * checks whether the cell clicked is at the edge
         * @param (r)row and c(column)
         **/
        return true;
    }

    private  boolean isCorner(int r , int c){
        /**
         * checks whether the cell clicked is at the corner
         * @param (r)row and c(column)
         **/
        return true;
    }


    //handle explosions that are at the  edges
    private void handleEdgeExplosion(int r , int c, int p){
        /**
         *  handles the explosions which occur at the edges
         * @param (r)row and c(column)  and p (player)
         **/


    }

    //
    private void handleCornerExplosion(int r , int c , int p){
        /**
         * handle the explosions that are happening at the corners
         * @param (r)row , c(column)  and  p (player)
         **/


    }

    //
    private void handleExplosion(int r , int c , int p){
        /**
         * handle explosions that are happenning anywhere except the corners or the edge
         * @param (r)row , c(column)  and  p (player)
         **/


    }

    // move
    public void explode( int r , int c , int p) {
        /**
         *  change the color of the orbs  in a cell which an orb explode to and move the orb to the  cell
         * @param (r)row , c(column)  and  p (player)
         **/

    }

    // restart the game
    public void restart(){
        /**
         *  clears the boards and reset the players
         * @param none
         *
         **/

    }



    // checks if a player's orbs have been elimated and removes the player from playing
    public void eliminatePlayer( ) {
        /**
         *  removes  the players from the  grid  if the plauer's orbs are removed
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
    private boolean checkPlayer(int j){
        /**
         * checks if the prbs of the player has been removed
         * @param j (player number)
         */

        return false ;
    }

    //checks if the player can play
    public static boolean canPlay(int p){
        /**
         * checks if the player can play
         * @param p (player)
         */
       return true;
    }

    public static boolean isWin(){
        /**
         * checks if there's a winner/ win
         * @param none
         */
        return  true ;
    }

    public static int  getWinner(){
        /**
         * get the winner
         * @param none
         */
        return 0 ;

    }
}
