/*
 * File             : Ball.java
 * Author           : Lam YongXian
 * Description      : Source File for ball
 */

////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

////////////////////////////

public class Ball
    extends JApplet {

  //FIXED CONSTANTS (DO NOT EDIT)

  //chDir constants
  private final int CHANGEDIR = -1;
  private final int X = 0;
  private final int Y = 1;
  private final int ORIGIN = 0;

  //BALL VALUES
  private int size; //size
  private int speed; //original speed

  private Color fillColor; //ball colour
  private Color drawColor; //border colour

  private int xDir; //direction x heading (=speed)
  private int yDir; //direction y heading (=speed)

  private boolean hitBottom; //ball hit bottom

  //BALL POSITION
  private int xPos;
  private int yPos;

  private int xOriginal;
  private int yOriginal;

  //CONSTRUCTORS

  //set default constants
  private final int X_DEFAULT = 0; //set default x position
  private final int Y_DEFAULT = 0; //set default y position
  private final int SIZE_DEFAULT = 20; //set default size
  private final int SPEED_DEFAULT = 10; //set default speed

  private final Color FILL_DEFAULT = new Color(255, 255, 255); //white
  private final Color DRAW_DEFAULT = new Color(0, 0, 0); //black

  //Default Constructor
  public Ball() {
    xPos = X_DEFAULT;
    yPos = Y_DEFAULT;
    size = SIZE_DEFAULT;

    xDir = SPEED_DEFAULT;
    yDir = SPEED_DEFAULT;
    speed = SPEED_DEFAULT;

    fillColor = FILL_DEFAULT;
    drawColor = DRAW_DEFAULT;

    xOriginal = X_DEFAULT;
    yOriginal = Y_DEFAULT;

  } //set default xPos, yPos, size, speed, fillColor, drawColor

  //Overloaded Constructors
  public Ball(int x, int y) {
    xPos = x;
    yPos = y;
    size = SIZE_DEFAULT;

    speed = SPEED_DEFAULT;
    xDir = SPEED_DEFAULT;
    yDir = SPEED_DEFAULT;

    fillColor = FILL_DEFAULT;
    drawColor = DRAW_DEFAULT;

    xOriginal = x;
    yOriginal = y;
  } //assign values to xPos, yPos and set default size, speed, fillColor, drawColor

  public Ball(int x, int y, int sz, int sp) {
    xPos = x;
    yPos = y;
    size = sz;

    speed = sp;
    xDir = sp;
    yDir = sp;

    fillColor = FILL_DEFAULT;
    drawColor = DRAW_DEFAULT;

    xOriginal = x;
    yOriginal = y;

  } //assigned values to xPos, yPos, size, speed and set default fillColor, drawColor

  public Ball(Color fill, Color draw) {
    xPos = X_DEFAULT;
    yPos = Y_DEFAULT;
    size = SIZE_DEFAULT;

    speed = SPEED_DEFAULT;
    xDir = SPEED_DEFAULT;
    yDir = SPEED_DEFAULT;

    fillColor = fill;
    drawColor = draw;

    xOriginal = X_DEFAULT;
    yOriginal = Y_DEFAULT;
  } //assign value to fillColor, drawColor and set default xPos, yPos, size, speed

  public Ball(int x, int y, int sz, int sp, Color fill, Color draw) {
    xPos = x;
    yPos = y;
    size = sz;

    speed = sp;
    xDir = sp;
    yDir = sp;

    fillColor = fill;
    drawColor = draw;

    xOriginal = x;
    yOriginal = y;
  } //set assigned values to xPos, yPos, size, speed, fillColor, drawColor

  //BALL METHODS

  public void chSpeed(int times) {
    xDir *= times;
    yDir *= times;
  } //toggle speed by times (default=1)

  public void move() {
    xPos += xDir;
    yPos += yDir;
  } //change ball position by speedj

  public void reset() {
    xPos = xOriginal;
    yPos = yOriginal;
  } //reset xPos, yPos to Original values

  public boolean checkCollision(Pedal pedal, BallPanel panel) {
    hitBottom = false;
    if (pedal.intersects(xPos, yPos, size, size)) {
      yDir = -yDir;
    } //check collision with paddle

    if (xPos < ORIGIN) {
      xDir = -xDir;
    } //ball hit left border

    else if (xPos + size >= panel.getWidth()) {
      xDir = -xDir;
    } //ball hit top

    else if (yPos < ORIGIN) {
      yDir = -yDir;
    } //ball hit top border

    else if (yPos + size >= panel.getHeight()) {
      yDir = -yDir;
      hitBottom = true;
    } //ball hit bottom

    return hitBottom;

  } //controls bouncing

  //GET

  public int getX() {
    return xPos;
  } //returns current x position

  public int getY() {
    return yPos;
  } //returns current y position

  public int getOriginalSpeed() {
    return speed;
  } //returns original speed

  public void paint(Graphics g) {
    g.setColor(fillColor);
    g.fillOval(xPos, yPos, size, size);
    g.setColor(drawColor);
    g.drawOval(xPos, yPos, size, size);

  } //draw ball

}

// Copyright (C) 2005 Lam Yong Xian.
