package tetrisjpwmiiio1jedralskik;

import java.awt.Color;
import java.net.URL;
import javafx.scene.media.AudioClip;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Konrad
 */
public class Tetris extends javax.swing.JFrame {

    private URL rotation;
    private final AudioClip audioRotation;

    public Tetris() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        board.setParent(this);
        scoreLabel.setText(String.valueOf(0));
        try {
            rotation = Tetris.class.getResource("/tetrisjpwmiiio1jedralskik/resources/rotation.mp3");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "ERROR!", ERROR);
        }
        audioRotation = new AudioClip(rotation.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instruction = new javax.swing.JFrame();
        instructionText = new javax.swing.JLabel();
        buttonCloseInstruction = new javax.swing.JButton();
        board = new tetrisjpwmiiio1jedralskik.Board();
        pauseLabel = new javax.swing.JLabel();
        scoreTitleLabel = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        buttonInstruction = new javax.swing.JButton();

        instruction.setTitle("Instruction");
        instruction.setFocusable(false);
        instruction.setFocusableWindowState(false);
        instruction.setLocation(new java.awt.Point(200, 100));
        instruction.setMaximumSize(new java.awt.Dimension(453, 435));
        instruction.setMinimumSize(new java.awt.Dimension(453, 435));
        instruction.setPreferredSize(new java.awt.Dimension(453, 435));
        instruction.setResizable(false);

        instructionText.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        instructionText.setForeground(new java.awt.Color(255, 255, 255));
        instructionText.setText("<html> <br><font size=8><b><u>Instrukcja</u></b></font></br> <br</br> <br><u>Opis rozgrywki</u></br> <br>Gra polega na układaniu spadających klocków tak, aby utworzyć</br> <br>jak najwięcej pełnych linii, które będą się usuwały. Koniec rozgrywki</br> <br>nastąpi w momencie, kiedy jakaś figura dotknie końca planszy.</br> <br></br> <br><u>Nawigacja</u></br> <br><b>1. </b>Aby uruchomić grę naciśnij \"Start\".</br> <br><b>2. </b>W lewo: \"LEFT\".</br> <br><b>3. </b>W prawo: \"RIGHT\".</br> <br><b>4. </b>Rotacja w prawo: \"UP\".</br> <br><b>5. </b>Rotacja w lewo: \"DOWN\".</br> <br><b>6. </b>Upuszczenie klocka o jedną linię niżej (przyspieszenie): \"D\".</br> <br><b>7. </b>Upuszczenie klocka na sam dół: \"SPACE\".</br> <br><b>8. </b>Pauza: \"P\".</br> </html>");
        instructionText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        instructionText.setMinimumSize(new java.awt.Dimension(421, 313));

        buttonCloseInstruction.setText("Close and back to the game");
        buttonCloseInstruction.setFocusable(false);
        buttonCloseInstruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseInstructionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout instructionLayout = new javax.swing.GroupLayout(instruction.getContentPane());
        instruction.getContentPane().setLayout(instructionLayout);
        instructionLayout.setHorizontalGroup(
            instructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instructionText, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(buttonCloseInstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        instructionLayout.setVerticalGroup(
            instructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionText, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCloseInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setLocation(new java.awt.Point(600, 300));
        setMaximumSize(new java.awt.Dimension(500, 524));
        setMinimumSize(new java.awt.Dimension(500, 524));
        setResizable(false);

        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boardKeyPressed(evt);
            }
        });

        pauseLabel.setFont(new java.awt.Font("Garamond", 3, 48)); // NOI18N
        pauseLabel.setForeground(new java.awt.Color(255, 255, 255));
        board.add(pauseLabel);
        pauseLabel.setBounds(60, 30, 160, 60);

        scoreTitleLabel.setFont(new java.awt.Font("Garamond", 0, 25)); // NOI18N
        scoreTitleLabel.setForeground(new java.awt.Color(255, 0, 0));
        scoreTitleLabel.setText("Score:");

        author.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setText("Created by Konrad Jędralski");
        author.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        author.setFocusable(false);
        author.setInheritsPopupMenu(false);

        scoreLabel.setFont(new java.awt.Font("Garamond", 0, 25)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 0, 0));

        buttonStart.setText("Start");
        buttonStart.setFocusable(false);
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonInstruction.setText("Show instruction");
        buttonInstruction.setFocusable(false);
        buttonInstruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInstructionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(author)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                        .addComponent(author))
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInstructionActionPerformed
        instruction.getContentPane().setBackground(Color.DARK_GRAY);
        instruction.setVisible(true);
    }//GEN-LAST:event_buttonInstructionActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        board.start();
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonCloseInstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseInstructionActionPerformed
        instruction.setVisible(false);
    }//GEN-LAST:event_buttonCloseInstructionActionPerformed

    private void boardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boardKeyPressed

        if (!board.isIsStarted() || board.getCurPiece().getShape() == Shape.Tetrominoes.NoShape) {  //Blokowanie dodania kształtu, kiedy gra nie jest włączona
            return;
        }

        if (evt.getKeyCode() == 80) {
            board.pause();
            return;
        }
        if (board.isIsPaused()) {
            return;
        }

        switch (evt.getKeyCode()) {
            case 37:
                board.tryMove(board.getCurPiece(), board.getCurX() - 1, board.getCurY()); //W Lewo (strzałka w lewo)
                break;
            case 39:
                board.tryMove(board.getCurPiece(), board.getCurX() + 1, board.getCurY()); //W prawo (strzałka w prawo)
                break;
            case 40:
                board.tryMove(board.getCurPiece().rotateLeft(), board.getCurX(), board.getCurY()); //Rotacja w lewo (strzałka w dół)
                audioRotation.play();
                break;
            case 38:
                board.tryMove(board.getCurPiece().rotateRight(), board.getCurX(), board.getCurY()); //Rotacja w prawo (strzałka w górę)
                audioRotation.play();
                break;
            case 32:
                board.dropDown(); //Upuszczenie klocka na sam dół (spacja)
                break;
            case 68:
                board.oneLineDown(); //Przesunięcie klocka o jedna linię w dół - przyspieszenie spadania (klawisz D)
                break;
            default:
                break;
        }
    }//GEN-LAST:event_boardKeyPressed

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getPauseLabel() {
        return pauseLabel;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tetris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel author;
    private tetrisjpwmiiio1jedralskik.Board board;
    private javax.swing.JButton buttonCloseInstruction;
    private javax.swing.JButton buttonInstruction;
    private javax.swing.JButton buttonStart;
    private javax.swing.JFrame instruction;
    private javax.swing.JLabel instructionText;
    private javax.swing.JLabel pauseLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreTitleLabel;
    // End of variables declaration//GEN-END:variables
}
