package TwentyFourty8;

import java.util.ArrayList;

/**
 * COP3330C.01
 *
 * @author Emma
 */
public class Board {

    private ArrayList<ArrayList<Tile>> board;
    private ArrayList<Tile> insideArray;

    public Board() {

    }

    //creates the 
    public void createBoard() {
        board = new ArrayList<>();

        for (int x = 0; x < 4; x++) {
            insideArray = new ArrayList<>();

            for (int y = 0; y < 4; y++) {
                insideArray.add(new Tile());
            }
            board.add(insideArray);
        }

        //finds a random spot for the first two tiles
        int col = (int) (Math.random() * 4);
        int row = (int) (Math.random() * 4);
        int col2 = (int) (Math.random() * 4);
        int row2 = (int) (Math.random() * 4);

        while (col == col2 && row == row2) {
            col2 = (int) (Math.random() * 4);
            row2 = (int) (Math.random() * 4);
        }

        board.get(col).get(row);
        board.get(col2).get(row2);

    }

    public ArrayList<ArrayList<Tile>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Tile>> board) {
        this.board = board;
    }

}
