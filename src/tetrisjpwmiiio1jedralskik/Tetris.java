package tetrisjpwmiiio1jedralskik;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Konrad
 */
public class Tetris extends javax.swing.JFrame {

    public Tetris() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        board.setParent(this);
        score.setText(String.valueOf(0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instruction = new javax.swing.JFrame();
        instructionText = new javax.swing.JLabel();
        buttonCloseInstruction = new javax.swing.JButton();
        board = new tetrisjpwmiiio1jedralskik.Board();
        scoreTitle = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        buttonInstruction = new javax.swing.JButton();

        instruction.setTitle("Instruction");
        instruction.setMaximumSize(new java.awt.Dimension(400, 400));
        instruction.setMinimumSize(new java.awt.Dimension(400, 400));
        instruction.setPreferredSize(new java.awt.Dimension(400, 400));
        instruction.setResizable(false);

        instructionText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        instructionText.setForeground(new java.awt.Color(255, 255, 255));
        instructionText.setText("Instrukcja: ");

        buttonCloseInstruction.setText("Close and resume game");
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
                    .addGroup(instructionLayout.createSequentialGroup()
                        .addComponent(instructionText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonCloseInstruction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap())
        );
        instructionLayout.setVerticalGroup(
            instructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(buttonCloseInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setMaximumSize(new java.awt.Dimension(500, 524));
        setMinimumSize(new java.awt.Dimension(500, 524));
        setResizable(false);

        scoreTitle.setFont(new java.awt.Font("Garamond", 0, 25)); // NOI18N
        scoreTitle.setForeground(new java.awt.Color(255, 0, 0));
        scoreTitle.setText("Score:");

        author.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setText("Created by Konrad Jędralski");
        author.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        author.setFocusable(false);
        author.setInheritsPopupMenu(false);

        score.setFont(new java.awt.Font("Garamond", 0, 25)); // NOI18N
        score.setForeground(new java.awt.Color(255, 0, 0));

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonInstruction.setText("Show instruction");
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
                        .addComponent(scoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(scoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        board.pause();
        instruction.getContentPane().setBackground(Color.DARK_GRAY);
        instruction.setVisible(true);
    }//GEN-LAST:event_buttonInstructionActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        board.start();
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonCloseInstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseInstructionActionPerformed
        instruction.setVisible(false);
        board.pause();
    }//GEN-LAST:event_buttonCloseInstructionActionPerformed

    public JLabel getScore() {
        return score;
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
    private javax.swing.JLabel score;
    private javax.swing.JLabel scoreTitle;
    // End of variables declaration//GEN-END:variables
}
