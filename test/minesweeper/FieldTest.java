package minesweeper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import minesweeper.exception.ExplosionException;
import minesweeper.model.Field;

public class FieldTest {

	private Field field;

	@BeforeEach
	void initiateField() {
		field = new Field(3,3);
	}
	
	@Test
	void testRealDistanceOfNextLeftBlock() {
		Field nextBlock = new Field(3,2);
		boolean result = field.addNextBlock(nextBlock);
		
		assertTrue(result);
	}

	@Test
	void testRealDistanceOfRightBlock() {
		Field nextBlock = new Field(3,4);
		boolean result = field.addNextBlock(nextBlock);
		
		assertTrue(result);
	}
	
	@Test
	void testRealDistanceOfTopBlock() {
		Field nextBlock = new Field(2,3);
		boolean result = field.addNextBlock(nextBlock);
		
		assertTrue(result);
	}
	
	@Test
	void testRealDistanceOfDownBlock() {
		Field nextBlock = new Field(4,3);
		boolean result = field.addNextBlock(nextBlock);
		
		assertTrue(result);
	}
	
	@Test
	void testIfIsNextBlock() {
		Field nextBlock = new Field(2,2);
		boolean result = field.addNextBlock(nextBlock);
		
		assertTrue(result);
	}
	
	@Test
	void testIfIsNotNextBlock() {
		Field nextBlock = new Field(1,1);
		boolean result = field.addNextBlock(nextBlock);
		
		assertFalse(result);
	}
	
	@Test
	void testIsNotMarked() {
		assertFalse(field.isMarked());
	}
	
	@Test
	void testSwitchToMarkup() {
		field.switchMarkup();
		assertTrue(field.isMarked());
	}
	
	@Test
	void testOpenANotMarkedAndNotABomb() {
		assertTrue(field.open());
	}
	
	@Test
	void testOpenMarkedBlock() {
		field.switchMarkup();
		assertFalse(field.open());
	}

	@Test
	void testOpenMarkedBlockIsBomb() {
		field.switchMarkup();
		field.makeBomb();
		assertFalse(field.open());
	}
	
	@Test
	void testOpenABombBlock() {
		field.makeBomb();
		assertThrows(ExplosionException.class, () -> {
			field.open();
		});
	}
	
	

}
