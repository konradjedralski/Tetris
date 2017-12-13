package tetrisjpwmiiio1jedralskik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javafx.scene.media.AudioClip;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import tetrisjpwmiiio1jedralskik.Shape.Tetrominoes;

public class Board extends JComponent implements ActionListener {

    private BufferedImage imageBackground = null;
    private final int BoardWidth = 10;
    private final int BoardHeight = 22;
    private final int backgroundWidth = 290;
    private final int backgroundHeight = 500;
    private final Timer timer;
    private boolean isFallingFinished = false; //Zmienna określająca, czy kształt tetris zakończył spadanie
    boolean isStarted = false;
    boolean isPaused = false;
    private int numLinesRemoved = 0; //Liczba usuniętych linii
    int curX = 0; //Rzeczywista pozycja X opadającego kształtu tetris
    int curY = 0; //Rzeczywista pozycja Y opadającego kształtu tetris
    Shape curPiece;
    private final Tetrominoes[] board; //board zawiera wszystkie kwadraty kawałków i pozostałości kawałków, które spadły
    private Tetris parent;
    private JLabel scoreLabel;
    private JLabel pauseLabel;
    private final Icon icon = new ImageIcon(Board.class.getResource("/tetrisjpwmiiio1jedralskik/resources/gameOver.png"));
    private URL pieceDropped;
    private URL removeFullLine;
    private URL finishedGame;
    private final AudioClip audioPieceDropped;
    private final AudioClip audioRemoveFullLine;
    private final AudioClip audioFinishedGame;

    public Board() {
        try {
            imageBackground = ImageIO.read(tetrisjpwmiiio1jedralskik.Board.class.getResource("/tetrisjpwmiiio1jedralskik/resources/background.jpg"));
            pieceDropped = Board.class.getResource("/tetrisjpwmiiio1jedralskik/resources/pieceDropped.mp3");
            removeFullLine = Board.class.getResource("/tetrisjpwmiiio1jedralskik/resources/removeFullLine.mp3");
            finishedGame = Board.class.getResource("/tetrisjpwmiiio1jedralskik/resources/finishedGame.mp3");
        } catch (IOException ex) {
            imageBackground = new BufferedImage(backgroundWidth, backgroundHeight, BufferedImage.TYPE_INT_ARGB);
            JOptionPane.showMessageDialog(parent, ex, "ERROR!", ERROR);
        }
        this.setFocusable(true);
        curPiece = new Shape();
        timer = new Timer(400, this); //Timer z opóźnieniem 400ms               
        board = new Tetrominoes[BoardWidth * BoardHeight];
        clearBoard();
        audioPieceDropped = new AudioClip(pieceDropped.toString());
        audioRemoveFullLine = new AudioClip(removeFullLine.toString());
        audioFinishedGame = new AudioClip(finishedGame.toString());
    }

    //Metoda łącząca JLabel z klasy Board z JLabel znajdującym się w klasie Tetris
    public void setParent(Tetris parent) {
        this.parent = parent;
        scoreLabel = this.parent.getScoreLabel();
        pauseLabel = this.parent.getPauseLabel();
    }

    //Metoda sprawdzająca, czy obiekt zakończył spadanie
    //Jeśli tak, tworzony zostaje nowy element, jeśli nie spadający obiekt spada o jedną linię niżej
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    int squareWidth() {
        return (int) getSize().getWidth() / BoardWidth;
    }

    int squareHeight() {
        return (int) getSize().getHeight() / BoardHeight;
    }

    //Uzyskanie dostępu do do tablicy board, gdzie są pamiętane wszystkie pozostałe kwadraty (pozostałości kawałków, które upadły)
    Tetrominoes shapeAt(int x, int y) {
        return board[(y * BoardWidth) + x];
    }

    public void start() {
        if (isPaused) {
            return; //Podczas pauzy nie można startować gry
        }
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();

        newPiece();
        timer.start();
    }

    //Pauza uruchomiona klawiszem P
    public void pause() {
        if (!isStarted) {
            return; //Kiedy gra nie jets włączona nie można zrobić pauzy
        }
        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            pauseLabel.setText("Paused");
        } else {
            timer.start();
            pauseLabel.setText("");
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics graph) {
        Graphics2D graph2 = (Graphics2D) graph;
        graph2.drawImage(imageBackground, 0, 0, backgroundWidth, backgroundHeight, null);

        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();

        //Rysowanie kształtów lub ich pozostałości, które zostały upuszczone na spód planszy
        for (int i = 0; i < BoardHeight; ++i) {
            for (int j = 0; j < BoardWidth; ++j) {
                Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
                if (shape != Tetrominoes.NoShape) {
                    drawSquare(graph, 0 + j * squareWidth(), boardTop + i * squareHeight(), shape);
                }
            }
        }

        //Rysowanie aktualnego spadającego obiektu
        if (curPiece.getShape() != Tetrominoes.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawSquare(graph, 0 + x * squareWidth(), boardTop + (BoardHeight - y - 1) * squareHeight(), curPiece.getShape());
            }
        }
    }

    //Zrzucenie elementu w dół 
    //Próba upuszczenia elementu o jedną linię, aż znajdzie się na samym dole planszy lub, na górze poprzeniego elementu
    public void dropDown() {
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1)) {
                break;
            }
            --newY;
        }
        pieceDropped();
    }

    //Upuszczenie obiektu o jedną linię w dół
    public void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1)) {
            pieceDropped();
        }
    }

    //Uzupełnia planszę pustymi kształtami NoShapes, używane w wykrywaniu kolizji
    private void clearBoard() {
        for (int i = 0; i < BoardHeight * BoardWidth; ++i) {
            board[i] = Tetrominoes.NoShape;
        }
    }

    //Metoda zapisuje spadający kawałek do tablicy board
    //board zawiera wszystkie kwadraty kawałków i pozostałości kawałków, które spadły
    //Kiedy kawałek upadł następuje sprawdzenie, czy można usunąć pełne linie z planszy
    //Następnie następuje utworzenie nowego kształtu
    private void pieceDropped() {
        for (int i = 0; i < 4; ++i) {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BoardWidth) + x] = curPiece.getShape();
        }

        audioPieceDropped.play();

        removeFullLines();

        if (!isFallingFinished) {
            newPiece();
        }
    }

    //Tworzenie nowego kształtu tetris
    //Otrzymuje nowy losowy kształt
    //Obliczanie wartość początkową curX i curY
    //Jeśli nie można przejść do początkowych wartości gra się kończy
    //Jesteśmy na szczycie, timer jest zatrzymany
    private void newPiece() {
        curPiece.setRandomShape();
        curX = BoardWidth / 2 + 1;
        curY = BoardHeight - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY)) {
            curPiece.setShape(Tetrominoes.NoShape);
            timer.stop();
            isStarted = false;
            audioFinishedGame.play();
            JOptionPane.showMessageDialog(parent, "Your game is finished!\nScore: " + String.valueOf(numLinesRemoved), "GAME OVER!", HEIGHT, icon);
        }
    }

    //Metoda starająca się przesunąć kształt tetris 
    //Metoda zwraca false, jeśli dotarła do granic planszy lub sąsiaduje z upuszczonymi już fargemntami
    public boolean tryMove(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight) {
                return false;
            }
            if (shapeAt(x, y) != Tetrominoes.NoShape) {
                return false;
            }
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();
        return true;
    }

    //Sprawdzenie czy istnieje pełny wiersz spośród wszystkich wierszy na planszy
    //Jeśli jest co najmniej jedna pusta linia, to jest ona usuwana i zostaje zwiększony licznik usuniętych linii
    //Następuje przesunięcie wszystkich linii powyżej usunietego wiersza o jedną linię w dół, co powoduje zniszczenie całej linii
    //Kwadraty mogą pozostać nad pustymi lukami (tzw. naiwna grawitacja)
    private void removeFullLines() {
        int numFullLines = 0;

        for (int i = BoardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BoardWidth; ++j) {
                if (shapeAt(j, i) == Tetrominoes.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < BoardHeight - 1; ++k) {
                    for (int j = 0; j < BoardWidth; ++j) {
                        board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
                        audioRemoveFullLine.play();
                    }
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            scoreLabel.setText(String.valueOf(numLinesRemoved)); //Wypisywanie wyniku
            isFallingFinished = true;
            curPiece.setShape(Tetrominoes.NoShape);
            repaint();
        }
    }

    //Każdy kawałek tetris składa się z czterech kwadratów
    //Kształty tetris mają różne kolory
    private void drawSquare(Graphics g, int x, int y, Tetrominoes shape) {
        Color colors[] = {
            new Color(0, 0, 0), new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        //Symulowanie krawędzi 3D        
        //Rysowanie górnej i lewej krawędzi kwadratu jaśniejszym kolorem    
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        //Rysowanie dolnej i prawej krawędzi kwadratu ciemniejszym kolorem
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);

    }
}
