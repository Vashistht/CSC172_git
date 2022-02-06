//import java.util.Arrays;
//
//public class MakeMove {
//
//    public static int[][]currentBoard = new int[4][4];
//    public static int numMoves;
//
////    say our array of the board is called array2D
//
//    //2D array copy method
//    public static int[][] cloneBoard(){
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                currentBoard[i][j] = array2D[i][j];
//            }
//        }
//        return currentBoard;
//    }
//
//
//    //The methods below all shift elements in the array according to the desired direction
//    public static void moveLeft(int[][] array){
//        int[][] tempArray = array;
//        int tempValue;
//        for(int i = 0; i < tempArray.length; i++){
//            for(int j = 3; j >= 1; j--){
//                if((tempArray[i][j] != 0 ) && (tempArray[i][j-1] == 0)){
//                    tempValue = tempArray[i][j-1];
//                    tempArray[i][j-1] = tempArray[i][j];
//                    tempArray[i][j] = tempValue;
//                }
//            }
//        }
//    }
//
//    public static void moveRight(int[][] array){
//        int[][] tempArray = array;
//        int tempValue;
//        for(int i = 0; i < tempArray.length; i++){
//            for(int j = 0 ; j < 3; j++){
//                if((tempArray[i][j] != 0 && tempArray[i][j+1] == 0)){
//                    tempValue = tempArray[i][j+1];
//                    tempArray[i][j+1] = tempArray[i][j];
//                    tempArray[i][j] = tempValue;
//                }
//            }
//        }
//    }
//
//    public static void moveUp(int[][] array){
//        int[][] tempArray = array;
//        int tempValue;
//        for(int i = 1; i <= 3 ; i++){
//            for(int j = 0; j < 4; j++){
//                if(tempArray[i][j] != 0 && tempArray[i-1][j] == 0){
//                    tempValue = tempArray[i - 1][j];
//                    tempArray[i-1][j] = tempArray[i][j];
//                    tempArray[i][j] = tempValue;
//                }
//            }
//        }
//    }
//
//    public static void moveDown(int[][] array){
//        int[][] tempArray = array;
//        int tempValue;
//        for(int i = 2; i >= 0; i--){
//            for(int j = 0; j < 4; j ++){
//                if(tempArray[i][j] != 0 && tempArray[i + 1][j] == 0){
//                    tempValue = tempArray[i + 1][j];
//                    tempArray[i+1][j] = tempArray[i][j];
//                    tempArray[i][j] = tempValue;
//                }
//            }
//        }
//    }
//
//    public static void addingTiles(int[][] board, String dir) {
//        int[][] tempArray = board;
//        switch (dir) {
//            case "a":
//                //movedArray temporarily stores the current board for comparison, if the two arrays
//                //are equal, it means no movement was made, therefore it was an invalid move
//                cloneBoard();
//                //Checks if numbers are the same, if they are then you add them
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (tempArray[i][j] == tempArray[i][j + 1]) {
//                            tempArray[i][j] += tempArray[i][j + 1];
//                            tempArray[i][j + 1] = 0;
//                        }
//                    }
//                }
//                //Loops through array to check if there is a zero to the left of the element,
//                //If there is, you swap them, essentially shifting to the left
//                for (int i = 0; i < tempArray.length; i++) {
//                    for (int j = 0; j < tempArray[i].length; j++) {
//                        moveLeft(board);
//                    }
//                }
//
//                if(!Arrays.deepEquals(currentBoard, tempArray)) {
//                    MakeBoard.updateBoard();
//                    numMoves++;
//                }
//                break;
//
//            case "d":
//                cloneBoard();
//                //Check if numbers are the same, if they are, add them
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 3; j > 0; j--) {
//                        if(tempArray[i][j] == tempArray[i][j - 1]){
//                            tempArray[i][j] += tempArray[i][j-1];
//                            tempArray[i][j-1] = 0;
//                        }
//                    }
//                }
//                //Loops through array to check if there is a zero to the right of the element,
//                //If there is, you swap them, essentially shifting to the right
//                for(int i = 0; i < tempArray.length; i++){
//                    for(int j = 0; j < tempArray[i].length; j++){
//                        moveRight(board);
//                    }
//                }
//
//                if(!Arrays.deepEquals(currentBoard, tempArray)) {
//                    MakeBoard.updateBoard();
//                    numMoves++;
//                }
//
//                break;
//            case "w":
//                cloneBoard();
//                //Check if numbers in the row above are the same, if they are, add them
//                for (int i = 1; i <= 3; i++) {
//                    for (int j = 0; j < 4; j++) {
//                        if(tempArray[i][j] == tempArray[i - 1][j]){
//                            tempArray[i-1][j] += tempArray[i][j];
//                            tempArray[i][j] = 0;
//                        }
//                    }
//                }
//                //Loops through array to check if there is a zero above the element,
//                //If there is, you swap them, essentially shifting "above"
//                for (int i = 0; i < tempArray.length; i++) {
//                    for (int j = 0; j < tempArray[i].length; j++) {
//                        moveUp(board);
//                    }
//                }
//
//                if(!Arrays.deepEquals(currentBoard, tempArray)) {
//                    MakeBoard.updateBoard();
//                    numMoves++;
//                }
//                break;
//            case "s":
//                cloneBoard();
//                //down
//                for (int i = 3; i > 0; i--) {
//                    for (int j = 0; j < 4; j++) {
//                        if(tempArray[i][j] == tempArray[i - 1][j]){
//                            tempArray[i][j] += tempArray[i-1][j];
//                            tempArray[i-1][j] = 0;
//                        }
//                    }
//                }
//                //Loops through array to check if there is a zero below the element,
//                //If there is, you swap them, essentially shifting "down"
//                for (int i = 0; i < tempArray.length; i++) {
//                    for (int j = 0; j < tempArray[i].length; j++) {
//                        moveDown(board);
//                    }
//                }
//                if(!Arrays.deepEquals(currentBoard, tempArray)) {
//                    Board.updateBoard();
//                    numMoves++;
//                }
//                break;
//        }
//    }
//}
