package TwentyFourty8;

import java.security.SecureRandom;

/**
 * COP3330C.01
 *
 * @author Emma
 */
public class Game {

    SecureRandom rand = new SecureRandom();
    Tile aTile = new Tile();

    private int score;
    private int numMove;
    private int numEmpty = 0;
    private Board tiles;

    public Game() {
        tiles = new Board();
    }

    //initializes the score, creates the board of tiles, and adds the 2 starting tiles
    public void startGame() {
        score = 0;
        tiles.createBoard();
        addRandom();
        addRandom();
//        printBoard();

    }
    
    //prints the game board to output
//    public void printBoard() {
//        System.out.println("+----------+");
//
//        for (int x = 0; x < 4; x++) {
//            for (int y = 0; y < 4; y++) {
//                System.out.printf("%d ", tiles.getBoard().get(x).get(y).getValue());
//            }
//            System.out.printf("\n");
//        }
//        System.out.println("+----------+");
//    }
    
    //adds a random tile to an empty place on the board
    public void addRandom() {
        int x, y, temp;
        do {
            x = rand.nextInt(4);
            y = rand.nextInt(4);
            if (rand.nextInt(1) > 0.9) {
                temp = 4;
            } else {
                temp = 2;
            }

        } while (tiles.getBoard().get(x).get(y).getValue() != 0);
        {
            tiles.getBoard().get(x).get(y).setValue(temp);
        }
    }

    public void moveRight() {
        int storage;

        //goes through all the tiles and finds places to merge
        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                if (y != 3 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = y + 1;

                    while (storage < 4 && tiles.getBoard().get(y).get(storage).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(x).get(storage - 1), tiles.getBoard().get(x).get(storage));
                        storage++;
                    }

                    if (storage < 4) {
                        convergeTile(tiles.getBoard().get(x).get(storage - 1), tiles.getBoard().get(x).get(storage));
                    }
                }
            }
        }
        
        //goes through the process again to fill in empty tiles
        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                if (y != 3 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = y + 1;

                    while (storage < 4 && tiles.getBoard().get(y).get(storage).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(x).get(storage - 1), tiles.getBoard().get(x).get(storage));
                        storage++;
                    }
                }
            }
        }

        numMove++;
        addRandom();
//        printBoard();
    }

    public void moveLeft() {
        int storage;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (y != 0 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = y - 1;

                    while (storage < 3 && tiles.getBoard().get(x).get(storage).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(x).get(storage + 1), tiles.getBoard().get(x).get(storage));
                        storage++;
                    }

                    if (storage < 3) {
                        convergeTile(tiles.getBoard().get(x).get(storage + 1), tiles.getBoard().get(x).get(storage));
                    }
                }
            }
        }
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (y != 0 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = y - 1;

                    while (storage < 3 && tiles.getBoard().get(x).get(storage).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(x).get(storage + 1), tiles.getBoard().get(x).get(storage));
                        storage++;
                    }
                }
            }
        }

        numMove++;
        addRandom();
//        printBoard();
    }

    public void moveUp() {
        int storage;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (x != 0 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = x - 1;

                    while (storage < 3 && tiles.getBoard().get(storage).get(y).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(storage + 1).get(y), tiles.getBoard().get(storage).get(y));
                        storage++;
                    }

                    if (storage < 3) {
                        convergeTile(tiles.getBoard().get(storage + 1).get(y), tiles.getBoard().get(storage).get(y));
                    }
                }
            }
        }
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (x != 0 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = x - 1;

                    while (storage < 3 && tiles.getBoard().get(storage).get(y).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(storage + 1).get(y), tiles.getBoard().get(storage).get(y));
                        storage++;
                    }
                }
            }
        }

        numMove++;
        addRandom();
//        printBoard();
    }

    public void moveDown() {
        int storage;

        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                if (x != 3 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = x + 1;

                    while (storage < 4 && tiles.getBoard().get(storage).get(y).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(storage - 1).get(y), tiles.getBoard().get(storage).get(y));
                        storage++;
                    }

                    if (storage < 4) {
                        convergeTile(tiles.getBoard().get(storage - 1).get(y), tiles.getBoard().get(storage).get(y));
                    }
                }
            }
        }

        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                if (x != 3 && tiles.getBoard().get(x).get(y).getValue() != 0) {
                    storage = x + 1;

                    while (storage < 4 && tiles.getBoard().get(storage).get(y).getValue() == 0) {
                        convergeTile(tiles.getBoard().get(storage - 1).get(y), tiles.getBoard().get(storage).get(y));
                        storage++;
                    }
                }
            }
        }

        numMove++;
        addRandom();
//        printBoard();
    }

    //merges two tiles
    public void convergeTile(Tile last, Tile next) {
        if (next.getValue() == last.getValue() || next.getValue() == 0) {
            next.merge(last);   //detailed in the tile class
            last.setValue(0);
        }
    }

    public int setScore() {
        score = numMove * 4;
        return score;
    }

    //checks to see if all the tiles are empty
    public boolean emptyTile() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (tiles.getBoard().get(x).get(y).getValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //checks to see if any of the tiles have matching neighbors that could be merged
    public boolean equalNeighbor() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                if (y < 3) {
                    if (tiles.getBoard().get(x).get(y).equals(tiles.getBoard().get(x).get(y + 1))) {
                        return true;
                    }
                }

                if (x < 3) {
                    if (tiles.getBoard().get(x).get(y).equals(tiles.getBoard().get(x + 1).get(y))) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    //checks to see if there are any moves left
    public boolean noMovesLeft() {
        if (emptyTile()) {
            return false;
        }
        return !(equalNeighbor());
    }

    //ends the game if there are no moves left
    public boolean endGame() {
        if (noMovesLeft() == !(equalNeighbor())) {
            return true;
        } else {
            return false;
        }
    }

    //if you have 2048 on your board, you'll win!
    public boolean winGame() {
        int value;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                value = tiles.getBoard().get(x).get(y).getValue();
                if (value == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public Board getTiles() {
        return tiles;
    }

    public int getScore() {
        return score;
    }

    public int getNumMove() {
        return numMove;
    }

}
