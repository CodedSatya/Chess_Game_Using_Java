package com.chess;

import com.Pieces.*;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */

     public static LinkedList<Piece> pieces = new LinkedList<Piece>();

     public static Piece selectedPiece = null;


    public static void main(String[] args) throws IOException {

        JFrame f;
        JPanel p;

        
        // Functions f = new Functions();
        BufferedImage all = ImageIO.read(new File("Chess\\chess\\src\\chess.png"));

        Image imgs[] = new Image[12];
        int x = 0;
        for (int i = 0; i < 400; i += 200) {
            for (int j = 0; j < 1200; j += 200) {
                imgs[x] = all.getSubimage(j, i, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                x++;
            }
        }
        // White pieces
        // White king

        Piece wking = new Piece(4, 7, "king", true, pieces);
        // White queen
        Piece wqueen = new Piece(3, 7, "queen", true, pieces);
        // White bishops
        Piece wbishop1 = new Piece(2, 7, "bishop", true, pieces);
        Piece wbishop2 = new Piece(5, 7, "bishop", true, pieces);
        // White knights
        Piece wknight1 = new Piece(1, 7, "knight", true, pieces);
        Piece wknight2 = new Piece(6, 7, "knight", true, pieces);
        // White rooks
        Piece wrook1 = new Piece(0, 7, "rook", true, pieces);
        Piece wrook2 = new Piece(7, 7, "rook", true, pieces);

        // White pawns
        Piece wpawn1 = new Piece(0, 6, "pawn", true, pieces);
        Piece wpawn2 = new Piece(1, 6, "pawn", true, pieces);
        Piece wpawn3 = new Piece(2, 6, "pawn", true, pieces);
        Piece wpawn4 = new Piece(3, 6, "pawn", true, pieces);
        Piece wpawn5 = new Piece(4, 6, "pawn", true, pieces);
        Piece wpawn6 = new Piece(5, 6, "pawn", true, pieces);
        Piece wpawn7 = new Piece(6, 6, "pawn", true, pieces);
        Piece wpawn8 = new Piece(7, 6, "pawn", true, pieces);

        // Black pieces

        // Black king
        Piece bking = new Piece(4, 0, "king", false, pieces);
        // Black queen
        Piece bqueen = new Piece(3, 0, "queen", false, pieces);
        // Black bishops
        Piece bbishop1 = new Piece(2, 0, "bishop", false, pieces);
        Piece bbishop2 = new Piece(5, 0, "bishop", false, pieces);
        // Black knights
        Piece bknight1 = new Piece(1, 0, "knight", false, pieces);
        Piece bknight2 = new Piece(6, 0, "knight", false, pieces);
        // Black rooks
        Piece brook1 = new Piece(0, 0, "rook", false, pieces);
        Piece brook2 = new Piece(7, 0, "rook", false, pieces);

        // Black pawns
        Piece bpawn1 = new Piece(0, 1, "pawn", false, pieces);
        Piece bpawn2 = new Piece(1, 1, "pawn", false, pieces);
        Piece bpawn3 = new Piece(2, 1, "pawn", false, pieces);
        Piece bpawn4 = new Piece(3, 1, "pawn", false, pieces);
        Piece bpawn5 = new Piece(4, 1, "pawn", false, pieces);
        Piece bpawn6 = new Piece(5, 1, "pawn", false, pieces);
        Piece bpawn7 = new Piece(6, 1, "pawn", false, pieces);
        Piece bpawn8 = new Piece(7, 1, "pawn", false, pieces);

        f = new JFrame("Chess");
        f.setBounds(10, 10, 512, 512);
        f.setUndecorated(true);

        p = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (white) {
                            g.setColor(Color.white.darker());
                        } else {
                            g.setColor(Color.GRAY.darker());
                        }
                        g.fillRect(i * 64, j * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }

                for (Piece piece : pieces) {

                    int index = 0;

                    if (piece.name.equalsIgnoreCase("king")) {
                        index = 0;
                    }
                    if (piece.name.equalsIgnoreCase("queen")) {
                        index = 1;
                    }
                    if (piece.name.equalsIgnoreCase("bishop")) {
                        index = 2;
                    }
                    if (piece.name.equalsIgnoreCase("knight")) {
                        index = 3;
                    }
                    if (piece.name.equalsIgnoreCase("rook")) {
                        index = 4;
                    }
                    if (piece.name.equalsIgnoreCase("pawn")) {
                        index = 5;
                    }
                    if (!piece.isWhite) {
                        index += 6;
                    }

                    g.drawImage(imgs[index], piece.x, piece.y, this);
                }

            }
        };

        f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
                // System.out.println((getPiece(e.getX(), e.getY()).isWhite?"white ":"black ")+getPiece(e.getX(), e.getY()).name);

                selectedPiece = getPiece(e.getX(), e.getY());

            }

            public void mouseReleased(MouseEvent e) {
                selectedPiece.move(e.getX()/64, e.getY()/64);
                f.repaint();

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });

        f.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece != null){
                    selectedPiece.x = e.getX()-32;
                    selectedPiece.y = e.getY()-32;
                    f.repaint();
                }
            }

            public void mouseMoved(MouseEvent e) {

            }
        });

        f.add(p);

        f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }

    public static Piece getPiece(int x,int y){
        int xp = x/64;
        int yp = y/64;
        for(Piece piece : pieces){
            if(piece.xp == xp && piece.yp == yp){
                return piece;
            }
        }
        return null;
    } 
}
