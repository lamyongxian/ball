/*
 * File             : Pedal.java
 * Author           : Lam YongXian
 * Description      : Source File for Pedal (for game paddle)
 */

import java.awt.*;
import java.applet.*;

public class Pedal
    extends Rectangle { //extends Rectangle superClass

  //FIXED CONSTANTS
  private static final int PEDAL_HEIGHT = 5; //fixed thickness of pedal
  private static final int PEDAL_WIDTH = 100; //fixed thickness of pedal

  //PEDAL VALUES (to be initialise by constructors!)
  private Color fillColor; //pedal colour
  private Color drawColor; //pedal outline colour

  private int xPos; //actual x position
  private int yPos; //actual y position

  private int originalXPos; //starting x
  private int originalYPos; //starting y

  private int pedalWidth = PEDAL_WIDTH; //set width to default width

  //CONSTRUCTORS

  //constructors constants
  public final Color FILL_DEFAULT = Color.black;
  public final Color DRAW_DEFAULT = Color.white;

  //default contructor
  public Pedal() {
  super(0, 0, PEDAL_WIDTH, PEDAL_HEIGHT);
} //set default

  //overloaded constructor
  public Pedal(int x, int y) {
    super(x, y, PEDAL_WIDTH, PEDAL_HEIGHT); //inherited method from Rectangle
    xPos = x;
    originalXPos = x;
    yPos = y;
    originalYPos = y;

    //set default Color
    fillColor = FILL_DEFAULT;
    drawColor = DRAW_DEFAULT;
  } //set xPos, yPos, lenght, fillColor, drawColor

  public Pedal(int x, int y, Color fill, Color draw) {
    super(x, y, PEDAL_WIDTH, PEDAL_HEIGHT); //inherited method from Rectangle
    xPos = x;
    originalXPos = x;
    yPos = y;
    originalYPos = y;
    fillColor = fill;
    drawColor = draw;

  } //set xPos, yPos, lenght, fillColor, drawColor


  //PEDAL METHODS
  public void moveRect() {
    super.setLocation(xPos, yPos);
  } //relocate pedal

  public void movePedal(int x, int y) {
    if (x + pedalWidth >= y) {
      xPos = y - pedalWidth;
    }
    else {
      xPos = x;
    }
  } //movePedal horizontally

  public void reset() {
    xPos = originalXPos;
    yPos = originalYPos;
  } //reset pedal

  public void paint(Graphics g) {
    g.setColor(fillColor);
    g.fillRect(super.x, super.y, super.width, PEDAL_HEIGHT);
    g.setColor(drawColor);
    g.drawRect(super.x, super.y, super.width, PEDAL_HEIGHT);

  } //draw and fill the Reactangle that represents the pedal
}

// Copyright (C) 2005 Lam Yong Xian.
