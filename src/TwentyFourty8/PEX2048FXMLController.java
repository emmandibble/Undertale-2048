package TwentyFourty8;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PEX2048FXMLController {
    
    @FXML
    private ResourceBundle resources;
    
    private Game myGame;
    private Board gameBoard;
    private Tile tile;
    
    @FXML
    private URL location;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Label score;
    
    @FXML
    private Label highScore;
    
    @FXML
    private Label helperLabel;
    
    @FXML
    private ImageView oneOne, oneTwo, oneThree, oneFour, twoOne, twoTwo, twoThree, twoFour, threeOne,
            threeTwo, threeThree, threeFour, fourOne, fourTwo, fourThree, fourFour;
    
    @FXML
    protected ImageView temmie;
    
    @FXML
    void helpFunction(MouseEvent event) {
        if (myGame.getNumMove() <= 24 && myGame.getNumMove() > 16) {
            helperLabel.setText("move down");
        }
        
        if (myGame.getNumMove() <= 16 && myGame.getNumMove() > 0) {
            helperLabel.setText("move left");
        }
        
        if (myGame.getNumMove() <= 38 && myGame.getNumMove() > 24) {
            helperLabel.setText("move right");
        }
        
        if (myGame.getNumMove() > 38) {
            helperLabel.setText("move up");
        }
    }
    
    public PEX2048FXMLController() {
        gameBoard = new Board();
        tile = new Tile();
        myGame = new Game();
    }
    
    @FXML
    void moveTile(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                playSoundLeft();
                myGame.moveLeft();
                //resets the graphics on the board
                connectBoards();
                myGame.setScore();
                score.setText(String.valueOf(myGame.getScore()));

                //checks to see if the game is won or lost after each move
                if (myGame.endGame() == true || myGame.winGame() == true) {
                    lastMessage();
                    break;
                }
                break;
                
            case RIGHT:
                playSoundRight();
                myGame.moveRight();
                connectBoards();
                myGame.setScore();
                score.setText(String.valueOf(myGame.getScore()));
                
                if (myGame.endGame() == true || myGame.winGame() == true) {
                    lastMessage();
                    break;
                }
                break;
                
            case DOWN:
                playSoundDown();
                myGame.moveDown();
                connectBoards();
                myGame.setScore();
                score.setText(String.valueOf(myGame.getScore()));
                
                if (myGame.endGame() == true || myGame.winGame() == true) {
                    lastMessage();
                    break;
                }
                break;
                
            case UP:
                playSoundUp();
                myGame.moveUp();
                myGame.setScore();
                connectBoards();
                score.setText(String.valueOf(myGame.getScore()));
                
                if (myGame.endGame() == true || myGame.winGame() == true) {
                    lastMessage();
                    break;
                }
                break;
            
        }
    }
    
    @FXML
    void startGame(ActionEvent event) {
        score.setText("0");
        highScore.setText("20624");
        myGame.startGame();
        connectBoards();
    }
    
    public void connectBoards() {
        oneOne.setImage(new Image(myGame.getTiles().getBoard().get(0).get(0).getImage().toString()));
        oneTwo.setImage(new Image(myGame.getTiles().getBoard().get(0).get(1).getImage().toString()));
        oneThree.setImage(new Image(myGame.getTiles().getBoard().get(0).get(2).getImage().toString()));
        oneFour.setImage(new Image(myGame.getTiles().getBoard().get(0).get(3).getImage().toString()));
        
        twoOne.setImage(new Image(myGame.getTiles().getBoard().get(1).get(0).getImage().toString()));
        twoTwo.setImage(new Image(myGame.getTiles().getBoard().get(1).get(1).getImage().toString()));
        twoThree.setImage(new Image(myGame.getTiles().getBoard().get(1).get(2).getImage().toString()));
        twoFour.setImage(new Image(myGame.getTiles().getBoard().get(1).get(3).getImage().toString()));
        
        threeOne.setImage(new Image(myGame.getTiles().getBoard().get(2).get(0).getImage().toString()));
        threeTwo.setImage(new Image(myGame.getTiles().getBoard().get(2).get(1).getImage().toString()));
        threeThree.setImage(new Image(myGame.getTiles().getBoard().get(2).get(2).getImage().toString()));
        threeFour.setImage(new Image(myGame.getTiles().getBoard().get(2).get(3).getImage().toString()));
        
        fourOne.setImage(new Image(myGame.getTiles().getBoard().get(3).get(0).getImage().toString()));
        fourTwo.setImage(new Image(myGame.getTiles().getBoard().get(3).get(1).getImage().toString()));
        fourThree.setImage(new Image(myGame.getTiles().getBoard().get(3).get(2).getImage().toString()));
        fourFour.setImage(new Image(myGame.getTiles().getBoard().get(3).get(3).getImage().toString()));
    }
    
    @FXML
    void quitGame(MouseEvent event) {
        System.exit(0);
    }
    
    public void lastMessage() {
        score.setText("Game\n over!");
        helperLabel.setText("Press Mercy\n to Quit.");
    }
    
    public void playMusic() {
        Media music = new Media(new File(new File("music.wav").getAbsolutePath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(5);
        mediaPlayer.setAutoPlay(true);
    }
    
    public void playSoundLeft() {
        Media music = new Media(new File(new File("left.wav").getAbsolutePath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setAutoPlay(true);
    }
    
    public void playSoundRight() {
        Media music = new Media(new File(new File("right.wav").getAbsolutePath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setAutoPlay(true);
    }
    
    public void playSoundDown() {
        Media music = new Media(new File(new File("down.wav").getAbsolutePath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setAutoPlay(true);
    }
    
    public void playSoundUp() {
        Media music = new Media(new File(new File("up.wav").getAbsolutePath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setAutoPlay(true);
    }
    
    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert score != null : "fx:id=\"score\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert oneOne != null : "fx:id=\"oneOne\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert oneTwo != null : "fx:id=\"oneTwo\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert oneThree != null : "fx:id=\"oneThree\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert oneFour != null : "fx:id=\"oneFour\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert twoOne != null : "fx:id=\"twoOne\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert twoTwo != null : "fx:id=\"twoTwo\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert twoThree != null : "fx:id=\"twoThree\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert twoFour != null : "fx:id=\"twoFour\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert threeOne != null : "fx:id=\"threeOne\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert threeTwo != null : "fx:id=\"threeTwo\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert threeThree != null : "fx:id=\"threeThree\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert threeFour != null : "fx:id=\"threeFour\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert fourOne != null : "fx:id=\"fourOne\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert fourTwo != null : "fx:id=\"fourTwo\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert fourThree != null : "fx:id=\"fourThree\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert fourFour != null : "fx:id=\"fourFour\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert temmie != null : "fx:id=\"temmie\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        assert helperLabel != null : "fx:id=\"helperLabel\" was not injected: check your FXML file 'PEX2048FXML.fxml'.";
        
        playMusic();
    }
}
