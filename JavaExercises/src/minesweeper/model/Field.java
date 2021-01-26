package minesweeper.model;

import java.util.ArrayList;
import java.util.List;

import minesweeper.exception.ExplosionException;

public class Field {

	private final int row;
	private final int column;
	
	private boolean isOpen = false;
	private boolean bomb = false;
	private boolean marked = false;
	
	private List<Field> nextBlocks = new ArrayList<>();
	
	public Field (int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public boolean addNextBlock(Field nextBlock) {
		boolean differentRow = row != nextBlock.row;		
		boolean differentColumn = column != nextBlock.column;
		boolean diagonal = differentRow && differentColumn;
		
		int deltaRow = Math.abs(row - nextBlock.row);
		int deltaColumn = Math.abs(column - nextBlock.column);
		int geralDelta = deltaRow + deltaColumn;
		
		if(geralDelta == 1 && !diagonal) {
			nextBlocks.add(nextBlock);
			return true;
		} else if(geralDelta == 2 && diagonal) {
			nextBlocks.add(nextBlock);
			return true;
		} else {
			return false;
		}
	}
	
	public void switchMarkup() {
		if(!isOpen) {
			marked = !marked;
		}
	}
	
	public boolean open() {
		if(!isOpen && !marked) {
			isOpen = true;
			
			if(bomb) {
				throw new ExplosionException();
			}
			
			if(safeBlock()) {
				nextBlocks.forEach(n -> n.open());
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean safeBlock() {
		return nextBlocks.stream().noneMatch(n -> n.bomb);
	}
	
	public void makeBomb() {
		bomb = true;
	}
	
	public boolean isBomb() {
		return bomb;
	}
	
	public boolean isMarked() {
		return marked;
	}
	
	void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public boolean isOpened() {
		return isOpen;
	}
	
	public boolean isClosed() {
		return !isOpened();
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	boolean goalIsAchieved () {
		boolean solved = !bomb && isOpen;
		boolean isSafe = bomb && marked;
		return solved || isSafe;
	}
	
	long bombIsNear() {
		return nextBlocks.stream().filter(n -> n.bomb).count();
	}
	
	void restart() {
		isOpen = false;
		bomb = false;
		marked = false;
	}
	
	public String toString() {
		if(marked) {
			return "x";
		} else if(isOpen && bomb) {
			return "*";
		} else if(isOpen && bombIsNear() > 0) {
			return Long.toString(bombIsNear());
		} else if(isOpen) {
			return " ";
		} else {
			return "?";
		}
	}
}
