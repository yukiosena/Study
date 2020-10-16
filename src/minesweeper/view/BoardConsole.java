package minesweeper.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import minesweeper.exception.ExitException;
import minesweeper.exception.ExplosionException;
import minesweeper.model.Board;

public class BoardConsole {

	private Board board;
	private Scanner input = new Scanner(System.in);
	
	public BoardConsole(Board board) {
		this.board = board;
		
		playGame();
	}

	private void playGame() {
		try {
			boolean gameContinue = true;
			
			while(gameContinue) {
				gameCycle();
				
				System.out.println("Play again? (Y/n) ");
				String answer = input.nextLine();
				
				if("n".equalsIgnoreCase(answer)) {
					gameContinue = false;
				} else {
					board.restart();
				}
			}
			
		} catch (ExitException e) {
			System.out.println("Thank you!");
		} finally {
			input.close();
		}
	}

	private void gameCycle() {
		try {
			while(!board.goalIsAchieved()) {
				System.out.println(board);
				
				String typed = captureTypedValue("Type (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(typed.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();
				
				typed = captureTypedValue("1 - Open or 2 - Switch markup: ");
				
				if("1".equals(typed)) {
					board.open(xy.next(), xy.next());
				} else if("2".equals(typed)) {
					board.switchMarkup(xy.next(), xy.next());
				}
			}
			
			System.out.println("You win!!!");
		} catch(ExplosionException e) {
			System.out.println(board);
			System.out.println("You lose..");
		}
	}
	
	private String captureTypedValue(String text) {
		System.out.println(text);
		String typed = input.nextLine();
		
		if("exit".equalsIgnoreCase(typed)) {
			throw new ExitException();
		}
		return typed;
	}
}
