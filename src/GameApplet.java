/*
 * File             : GameApplet.java
 * Author           : Lam YongXian
 * Description      : Source File for GameApplet
 */

import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class GameApplet
    extends JApplet implements ActionListener {

  //game over constants
  protected final String END_TITLE = "GAME OVER"; //gameover title
  protected final String END_MSG = "You lost the game!"; //gameover message
  protected final String QUIT_MSG =
      "You have interupted the game! Game will now end!";

  protected Timer gameTimer;
  protected BallPanel game1;

  private JPanel buttonPanel;

  //buttons
  private JTextField scoreField;
  private JButton pauseGameButton;
  private JButton endGameButton;
  private JButton startGameButton;

  //constants
  private final String BUTTON_BORDER_LABEL = "Control";
  private final String PAUSE_LABEL = "PAUSE GAME";
  private final String RESUME_LABEL = "RESUME GAME";
  private final String END_LABEL = "END GAME";
  private final String START_LABEL = "START GAME!";

  private final Color BGCOLOR = Color.blue;
  private final Color P_BGCOLOR = Color.black;

  public void init() {

    //Main objects
    gameTimer = new Timer(8, this);
    game1 = new BallPanel();
    game1.setBackground(BGCOLOR);

    //instantiate panels
    initButtonPanel();

    //ContentPane
    getContentPane().setLayout(new BorderLayout());

    //getContentPane().setVisible(true);

    getContentPane().add(buttonPanel, "North");
    getContentPane().add(game1, "Center");

    //disable control buttons
    pauseGameButton.setEnabled(false);
    endGameButton.setEnabled(false);
  }

  //METHODS

  public void initButtonPanel() {
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setBorder(BorderFactory.createTitledBorder(BUTTON_BORDER_LABEL));

    //Panel objects
    pauseGameButton = new JButton(PAUSE_LABEL);
    pauseGameButton.addActionListener(this);

    endGameButton = new JButton(END_LABEL);
    endGameButton.addActionListener(this);

    startGameButton = new JButton(START_LABEL);
    startGameButton.addActionListener(this);

    scoreField = new JTextField();
    scoreField.addActionListener(this);
    scoreField.setEditable(false);

    //add
    buttonPanel.add(pauseGameButton);
    buttonPanel.add(endGameButton);
    buttonPanel.add(startGameButton);
    buttonPanel.add(scoreField);

  }

  //ACTIONPERFORMED
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == gameTimer) {
      game1.addScore(1);
      scoreField.setText(String.valueOf(game1.getScore()));
    } //display score

    if (game1.moveBall()) { //return boolean hitBottom

      //disable control buttons
      pauseGameButton.setEnabled(false);
      endGameButton.setEnabled(false);

      gameTimer.stop();
      game1.endGame(END_MSG, END_TITLE);

      startGameButton.setEnabled(true);
      game1.reset();
    }

    //pauseGameButton
    if (e.getSource() == pauseGameButton) {

      if (pauseGameButton.getText().equals(PAUSE_LABEL)) {
        pauseGameButton.setText(RESUME_LABEL);
        gameTimer.stop();
        game1.setBackground(P_BGCOLOR);
      }
      else {
        pauseGameButton.setText(PAUSE_LABEL);
        gameTimer.start();
        game1.setBackground(BGCOLOR);
      }
    }

    //endGameButton
    if (e.getSource() == endGameButton) {

      gameTimer.stop(); //stopTimer
      game1.reset(); //reset game

      endGameButton.setEnabled(false); //disable itself
      pauseGameButton.setEnabled(false); //disable pauseGameButton
      startGameButton.setEnabled(true); //allow restart

      game1.endGame(QUIT_MSG, END_TITLE);
      game1.setBackground(BGCOLOR);
    }

    //startGameButton
    if (e.getSource() == startGameButton) {
      gameTimer.start();
      pauseGameButton.setEnabled(true);
      endGameButton.setEnabled(true);
      startGameButton.setEnabled(false);
    }

    //scoreField
    if (e.getSource() == scoreField) {
      scoreField.setText(gameTimer.toString());
    }

    repaint();
  } //Ball actionListener
}
// Copyright (C) 2005 Lam Yong Xian.
