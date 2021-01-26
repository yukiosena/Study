package minesweeper;

import minesweeper.model.Board;
import minesweeper.view.BoardConsole;

public class App {

	public static void main(String[] args) {
		
		Board board = new Board(6, 6, 3);
		new BoardConsole(board);
		
	}
}
	