package com.chess;

import javax.swing.*;

import com.Warriors.Pawn;

import java.awt.*;

public class Board {
  
  JFrame f;
  int Boardheight = 520;
  int Boardwidth = 500;

  JPanel p;


  String [] c = {"a","b","c","d","e","f","g","h"};
  String [] r = {"1","2","3","4","5","6","7","8"};


  
  public void createBoard(){


    // Frame Initialization
    f = new JFrame("Chess");
    f.setSize(Boardwidth,Boardheight);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane();
    f.setLayout(null);
    f.setVisible(true);
    f.setResizable(false);
    // Setting custom icon

    ImageIcon logo = new ImageIcon( "Chess\\chess\\src\\chesslogo.jpg");

    f.setIconImage(logo.getImage());

    // Panel Initialization

    p = new JPanel();
    p.setLayout(null);
    p.setSize(Boardwidth, Boardheight);
    p.setBounds(0, 0, Boardwidth, Boardheight);
    f.add(p);

    // Creating the board

    String name = "";

    for(int i = 0 ; i<8 ; i++){
      
      
      for(int j = 0 ;j<8;j++){
        name = c[j]+r[i];
        JPanel b = new JPanel();
        JLabel l = new JLabel(name);
        // b.setLayout(null);
        l.setBounds(35, 35, 15, 10);
        // b.add(l);
        b.setSize(60, 60);
        b.setBounds(j*60, i*60, 60, 60);
        p.putClientProperty(name, b);
        if(i%2==0){
          if(j%2==0){
            b.setBackground(Color.white);
          }else{
            b.setBackground(Color.GRAY);
          }
        }
        else{
          if(j%2==0){
            b.setBackground(Color.GRAY);
          }else{
            b.setBackground(Color.white);
          }
        }
        p.add(b,b,0);
        p.revalidate();
        p.repaint();
      }
    }

  }


  public void movePiece(JPanel pawn , String name){
    JPanel b = (JPanel) p.getClientProperty(name);
    p.putClientProperty(name, pawn);
    b.add(pawn, pawn, 0);

    b.revalidate();
    b.repaint();
  }


  public void setBoard_White(){
    String name = "";
    for(int i=0;i<8;i++){
      name=c[i]+"2";
      movePiece(new Pawn().createWhitePawn(), name);
    }
  }
  public void setBoard_Black(){
    String name = "";
    for(int i=0;i<8;i++){
      name=c[i]+"7";
      movePiece(new Pawn().createBlackPawn(), name);
    }
  }

}
