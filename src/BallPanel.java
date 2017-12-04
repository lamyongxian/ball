/*
 * File             : BallPanel.java
 * Author           : Lam YongXian
 * Description      : Source File for BallPanel
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BallPanel
    extends JPanel implements MouseMotionListener {

  //Set pedal constants
  private int PEDAL_X = 300; //x lenght
  private int PEDAL_Y = 500; //y lenght

  private int HIT_PEDAL_SCORE = 5; //hit pedal score

  //instantiate ball and pedal
  protected Ball playBall = new Ball(20, 30, 14, 4);
  protected Pedal playPedal = new Pedal(PEDAL_X, PEDAL_Y);

  //Score
  private int gameScore = 0;

  //BallPanel Methods

  public BallPanel() {
    addMouseMotionListener(this);
  } //default constructor

  public boolean moveBall() {
    boolean stopBall = false;
    playBall.move();
    playPedal.moveRect();
    if (playBall.checkCollision(playPedal, this)) {
      stopBall = true;
      addScore(HIT_PEDAL_SCORE);
    }
    return stopBall;
  } //call playBall to call move()

  public void endGame(String message, String title) {
    JOptionPane.showMessageDialog(null, message, title,
                                  JOptionPane.INFORMATION_MESSAGE);
  } //display endGame Message

  public void addScore(int add) {
    gameScore += add;
  } //add and return new score

  public int getScore() {
    return gameScore;
  } //returns current score

  public void reset() {
    playBall.reset();
    playPedal.reset();
  } //reset BallPanel

  public void mouseMoved(MouseEvent e) {
    playPedal.movePedal(e.getX() - (playPedal.width / 2), getWidth());
    //repaint();
  } //mouseMoved event

  public void mouseDragged(MouseEvent e) {}

  //mouseDragged event

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //g.setColor(Color.black);
    //g.fillRect(0,0,getWidth(),getHeight());
    playBall.paint(g);
    playPedal.paint(g);
  }
}

// Copyright (C) 2005 Lam Yong Xian.
