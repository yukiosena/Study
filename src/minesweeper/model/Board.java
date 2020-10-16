package minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import minesweeper.exception.ExplosionException;

public class Board {

	private final int row;
	private final int column;
	private int bombs;
	
	private final List<Field> field = new ArrayList<>();
	
	public Board(int row, int column, int bombs) {
		this.row = row;
		this.column = column;
		this.bombs = bombs;
		
		generateField();
		connectBlocks();
		sortBombs();
	}
	
	public void open(int row, int column) {
		try {
			field.parallelStream().
				filter(f -> f.getRow() == row && f.getColumn() == column)
				.findFirst()
				.ifPresent(f -> f.open());
		} catch (ExplosionException e) {
			field.forEach(f -> f.setOpen(true));
			throw e;
		}
	}

	public void switchMarkup(int row, int column) {
		field.parallelStream().
			filter(f -> f.getRow() == row && f.getColumn() == column)
			.findFirst()
			.ifPresent(f -> f.switchMarkup());
	}
	
	private void generateField() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				field.add(new Field(i,j));
			}
		}
	}

	private void connectBlocks() {
		for(Field f1: field) {
			for(Field f2: field) {
				f1.addNextBlock(f2);
			}
		}		
	}

	private void sortBombs() {
		long armedBombs = 0;
		Predicate<Field> isBomb = f -> f.isBomb();
		do {
			int randomNum = (int) (Math.random() * field.size());
			field.get(randomNum).makeBomb();
			armedBombs = field.stream().filter(isBomb).count();
		} while(armedBombs < bombs);
	}
	
	public boolean goalIsAchieved () {
		return field.stream().allMatch(f -> f.goalIsAchieved());
	}
	
	public void restart() {
		field.stream().forEach(f -> f.restart());
		sortBombs();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("  ");
		for (int i = 0; i < column; i++) {
			sb.append(" ");
			sb.append(i);
			sb.append(" ");
		}
		
		sb.append("\n");
		
		int n = 0;
		for (int j = 0; j < row; j++) {
			sb.append(j);
			sb.append(" ");
			for (int k = 0; k < column; k++) {
				sb.append(" ");
				sb.append(field.get(n));
				sb.append(" ");
				n++;
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
