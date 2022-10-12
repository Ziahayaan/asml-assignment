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
        int[] returnArray = new int[totalElementSize];
        totalCols--;
        totalRows--;
        int elementsCounter = 0;
        int startColId = 0;
        int startRowId = 0;
        int endColId = totalCols;
        int endRowId = totalRows;
        int colIndex = 0;
        int rowIndex = 0;

        //Iterating the 2D array element by element
        while (elementsCounter < totalElementSize) {

            // Printing top left to right
            for (colIndex = startColId; colIndex <= endColId; colIndex++) {
                System.out.print(inputMatrix[startRowId][colIndex] + " ");
                returnArray[elementsCounter] = inputMatrix[startRowId][colIndex];
                elementsCounter++;
            }
            if(elementsCounter >= totalElementSize)break;

            endColId = totalCols;
            rowIndex += 1;
            startRowId = totalRows - rowIndex;
            startColId = colIndex - 1;

            //Printing right top to bottom
           for (; rowIndex <= endRowId; rowIndex++) {
                System.out.print(inputMatrix[rowIndex][startColId] + " ");
                returnArray[elementsCounter] = inputMatrix[rowIndex][startColId];
                elementsCounter++;
            }
            if(elementsCounter >= totalElementSize)break;

            startRowId = endRowId;
            endColId = startColId - totalCols;
            colIndex = startColId - 1;
            rowIndex = endRowId;

            //Printing bottom right to left
            for (; colIndex >= endColId; colIndex--) {
                System.out.print(inputMatrix[rowIndex][colIndex] + " ");
                returnArray[elementsCounter] = inputMatrix[rowIndex][colIndex];
                elementsCounter++;
            }
            if(elementsCounter >= totalElementSize)break;

            colIndex += 1;
            endRowId = startRowId - totalRows;
            rowIndex -= 1;
            startColId = colIndex;
            startRowId = rowIndex;
            endColId = totalCols - startColId;
            endRowId = totalRows - startRowId;
            totalCols -= 1;
            totalRows -= 1;

            //Printing left bottom to top
            for (; rowIndex >= endRowId; rowIndex--) {
                System.out.print(inputMatrix[rowIndex][colIndex] + " ");
                returnArray[elementsCounter] = inputMatrix[rowIndex][colIndex];
                elementsCounter++;
            }
            if(elementsCounter >= totalElementSize)break;

            startColId += 1;
            startRowId = endRowId;
            endColId = totalCols;
            endRowId = totalRows;
            colIndex = startColId;
            rowIndex = startRowId;
            totalCols -= 1;
            totalRows -= 1;
        }
        return returnArray;
    }
}
