package com.Warriors;

import javax.swing.*;
import java.awt.*;

public class Pawn {
  // JLayeredPane p = new JLayeredPane();

  JPanel p = new JPanel();
  public JPanel createWhitePawn(){
    ImageIcon pawnImg = new ImageIcon("Chess\\chess\\src\\white_pawn.png"); 
    
    pawnImg.setImage(pawnImg.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
    JLabel l = new JLabel(pawnImg);
    l.setBounds(0, 0, 60, 60);

    p.add(l, l, 0);
    return p;
  }
  public JPanel createBlackPawn(){
    ImageIcon pawnImg = new ImageIcon("Chess\\chess\\src\\black_pawn.png"); 
    
    pawnImg.setImage(pawnImg.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
    JLabel l = new JLabel(pawnImg);
    l.setBounds(0, 0, 60, 60);

    p.add(l, l, 0);
    return p;
  }
}
