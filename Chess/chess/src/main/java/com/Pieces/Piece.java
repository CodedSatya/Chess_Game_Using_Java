package com.Pieces;

import java.util.LinkedList;

public class Piece {
  public int xp;
  public int yp;
  public boolean isWhite;
  public String name;
  LinkedList<Piece> ps;
  public Piece(int xp,int yp,String name,boolean isWhite,LinkedList<Piece> ps){
    this.xp = xp;
    this.yp = yp;
    this.isWhite = isWhite;
    this.name = name;
    this.ps = ps;
    ps.add(this);
  }


  public void move(int xp,int yp){
    for(Piece x:ps){
      if(x.xp == xp && x.yp == yp){
        x.kill();
      }
    }
    this.xp = xp;
    this.yp = yp;

  }

  public void kill(){
    ps.remove(this);
  }

}

