package com.chess;

// import com.functions.Functions;

// import com.Warriors.*;
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // Functions f = new Functions();
        Board b = new Board();
        b.createBoard();

        b.setBoard_White();
        b.setBoard_Black();
    
    }
}
