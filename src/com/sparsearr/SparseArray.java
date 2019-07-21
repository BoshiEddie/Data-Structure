package com.sparsearr;

public class SparseArray {
	public static void main(String[] args) {
		
		//the chess board which has 11*11 
		//0 means there is no chess on that position
		//1 represents for white while 2 represents for black
		int[][] chessboard1 = new int[11][11];
		chessboard1[1][2] = 1;
		chessboard1[2][3] = 2;
		chessboard1[3][6] = 7;
		
		//show the original 2d array
		System.out.println("Original Array");
		for(int[] row: chessboard1) 
		{
			for(int item : row) 
			{
				System.out.print(item + " ");	
			}
			System.out.println();
		}
		
		//start to convert original array to sparse array
		//step 1.
		//go through all the data in the original array
		//count the number of lines and number of rows as well as number of data which is not the default value
		
		int value = 0;
		
		System.out.println("Sparse Array");
		
		for(int i = 0 ; i < chessboard1.length; i++) 
		{
			for(int j = 0 ; j < chessboard1[0].length; j++)
			{
				if(chessboard1[i][j] != 0)
				{
					value ++;
				}
			}
		}
		//for zipping the array with a lot 
		//create corresponding sparseArray 
		int sparseArray [][] = new int[value+1][3];
		//set the value 
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = value;
		
		int count = 0;
		for(int i = 0; i < 11; i++) {
			for(int j = 0 ; j < 11 ; j++) {
				if(chessboard1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i; 
					sparseArray[count][1] = j; 
					sparseArray[count][2] = chessboard1[i][j]; 
				}
			}	
		}
 		
		for(int[] row : sparseArray) {
			for(int data : row) {
				System.out.print(data + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		//put the sparse array back to 2d array;
		
		int[][] chessArr = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		for(int i = 1; i < sparseArray.length ; i ++) {
			for(int j = 0 ; j < sparseArray[0].length; j++) {
				chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
			}
		}
		
		for(int[] row : chessArr) {
			for(int data : row) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}
}
