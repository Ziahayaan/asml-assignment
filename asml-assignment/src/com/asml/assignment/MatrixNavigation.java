package com.asml.assignment;

import java.util.Arrays;

/**
 * This is the class to traverse a 2 dimensional matrix in the path of spiral.(
 * which is starting from top row left to right, right top to bottom, bottom to
 * top )
 * 
 * @author Allaudeen_John
 *
 */
public class MatrixNavigation {

	/**
	 * The method to print the given matrix in spiral form of order which is
	 * starting from top row left to right, right top to bottom, bottom to top
	 *
	 * @param inputMatrix the matrix which is going to be traversed in spiral way.
	 * 
	 * @return returnArray A single dimensional array which holds the navigated input array. 
	 */
	public int[] printSpiralMatrix(int[][] inputMatrix) {
		int totalRows = 0;
		int totalCols = 0;
		if (inputMatrix == null) {
			throw new IllegalArgumentException("The input matrix provided is not valid!");
		} else {
			totalRows = Long.valueOf(Arrays.stream(inputMatrix).count()).intValue();
			totalCols = Long.valueOf(Arrays.stream(inputMatrix[0]).count()).intValue();
		}

		int totalElementSize = totalRows * totalCols;
		int elementsCounter = 0;
		int startColId = 0;
		int endColId = totalCols - 1;
		int startRowId = 0;
		int endRowId = totalRows - 1;
		int colIndex = 0;
		int rowIndex = 0;
		boolean isBottomRowPrinted = false;
		int[] returnArray = new int[totalElementSize];
		// Iterating the 2D array element by element till the last element exists
		while (elementsCounter < totalElementSize) {
			// Printing the first row of the matrix left to right
			for (; colIndex <= endColId; colIndex++) {
				System.out.print(inputMatrix[startRowId][colIndex] + " ");
				returnArray[elementsCounter] = inputMatrix[startRowId][colIndex];
				elementsCounter++;
			}
			startColId = colIndex - 1;
			colIndex--;
			endRowId = totalRows - 1;
			totalRows--;
			rowIndex = startRowId + 1;

			// Printing the right side of the matrix top to bottom
			for (; rowIndex <= endRowId; rowIndex++) {
				System.out.print(inputMatrix[rowIndex][startColId] + " ");
				returnArray[elementsCounter] = inputMatrix[rowIndex][startColId];
				elementsCounter++;
			}
			if (!isBottomRowPrinted) {
				startRowId = rowIndex--;
				totalCols--;
				colIndex = startColId - 1;
				endColId = totalCols - startColId;
			} else {
				startRowId = rowIndex;
				totalCols--;
				colIndex = startColId;
				endColId = totalCols;
			}

			// Printing the bottom side of the matrix elements from right to left
			if (totalRows > 0) {
				for (; colIndex >= endColId; colIndex--) {
					System.out.print(inputMatrix[rowIndex][colIndex] + " ");
					returnArray[elementsCounter] = inputMatrix[rowIndex][colIndex];
					elementsCounter++;
					isBottomRowPrinted = true;
				}

				totalRows--;
				startRowId = rowIndex--;
				startColId = colIndex + 1;
				endRowId = startRowId - totalRows;
				endColId = colIndex + 1;

				// Print the left side of the matrix from bottom to up
				for (; rowIndex >= endRowId; rowIndex--) {
					System.out.print(inputMatrix[rowIndex][startColId] + " ");
					returnArray[elementsCounter] = inputMatrix[rowIndex][startColId];
					elementsCounter++;
				}
				totalCols--;
				startRowId = endRowId;
				startColId = endColId + 1;
				colIndex = startColId;
				endColId = totalCols;
			}
		}
		return returnArray;
	}
}
