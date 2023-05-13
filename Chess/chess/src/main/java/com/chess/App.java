package com.chess;

import com.functions.Functions;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        // System.out.println("Hello World!");

        // Functions f = new Functions();
        Board b = new Board();
        b.createBoard();
    
    }
}
