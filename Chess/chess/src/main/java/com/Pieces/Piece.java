package com.Pieces;

import java.util.LinkedList;

import com.chess.App;

public class Piece {
  public int xp;
  public int yp;

  public int x;
  public int y;


  public boolean isWhite;
  public String name;
  LinkedList<Piece> ps;
  public Piece(int xp,int yp,String name,boolean isWhite,LinkedList<Piece> ps){
    this.xp = xp;
    this.yp = yp;

    x = xp*64;
    y = yp*64;

    this.isWhite = isWhite;
    this.name = name;
    this.ps = ps;
    ps.add(this);
  }


  public void move(int xp,int yp){
    if(App.getPiece(xp*64, yp*64)!=null){
      if(App.getPiece(xp*64, yp*64).isWhite!=isWhite){

        App.getPiece(xp*64, yp*64).kill();
      }else{
        x=this.xp*64;
        y=this.yp*64;
        return;
      }
    }


    App.checkWin();

    this.xp = xp;
    this.yp = yp;
    x=xp*64;
    y=yp*64;

  }



  public void kill(){
    ps.remove(this);
  }

}

