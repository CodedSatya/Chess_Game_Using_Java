package com.chess;

import java.awt.*;

import javax.swing.*;

public class Board {
  JFrame f;
  JPanel p;
  public void createBoard(){
    f = new JFrame("Chess");
    f.setBounds(10, 10, 512, 512);
    f.setUndecorated(true);
    
    p = new JPanel(){
      @Override
      public void paint(Graphics g) {
        boolean white = true;
        for(int i = 0 ; i<8;i++){
          for(int j=0;j<8;j++){
            if(white){
              g.setColor(Color.white);
            }else{
              g.setColor(Color.black);
            }
            g.fillRect(i*64, j*64, 64, 64);
            white = !white;
          } 
          white = !white;
        }

        
      }
    };

    f.add(p);


    f.setDefaultCloseOperation(3);
    f.setVisible(true);

  }
}
