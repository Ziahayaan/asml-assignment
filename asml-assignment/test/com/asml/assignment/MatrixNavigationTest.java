package com.asml.assignment;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MatrixNavigationTest {

	private MatrixNavigation matrixNavigation = new MatrixNavigation();
	
	@Test(expected = IllegalArgumentException.class)
	public void printSpiralMatrixWhenInputMatrixIsNull() {
		
		int[][] inputMatrix = null;
		
		matrixNavigation.printSpiralMatrix(inputMatrix);
		
	}

	
	@Test
	public void printSpiralMatrixWhenInputMatrixHasSinglerow() {
		
		int[][] inputMatrix = {{1, 2, 3, 4}};
		int[] expectedResult = {1, 2, 3, 4};
		
		int[] returnArray = matrixNavigation.printSpiralMatrix(inputMatrix);
		
		assertArrayEquals(expectedResult, returnArray);
	}
	
	@Test
	public void printSpiralMatrixWhenInputMatrixHasMultipleRow() {
		
		int[][] inputMatrix = { { 1,  2,  3, 4 }, 
								{ 12, 13, 14, 5 }, 
								{ 11, 16, 15, 6 },
								{ 10, 9, 8, 7 } };
		int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		
		int[] returnArray = matrixNavigation.printSpiralMatrix(inputMatrix);
		
		assertArrayEquals(expectedResult, returnArray);
	}
}
