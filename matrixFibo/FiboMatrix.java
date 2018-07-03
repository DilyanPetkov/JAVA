package matrixFibo;

import java.util.ArrayList;
import java.util.List;

public class FiboMatrix {
	private int matrixToTraverse[][];
	int sizeOfMatrix;
	private List<List<Integer>> fiboList;

	private FiboMatrix(int[][] matrix, int n) {
		fiboList = new ArrayList<>();
		this.sizeOfMatrix = n;
		this.matrixToTraverse = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.matrixToTraverse[i][j] = matrix[i][j];
			}
		}
	}
	
	private void reverseColumns()
    {
        for (int i = 0; i < matrixToTraverse[0].length; i++)
            for (int j = 0,  k = matrixToTraverse[0].length - 1;
                             j < k; j++, k--)
            {  
                int temp = matrixToTraverse[j][i];
                matrixToTraverse[j][i] = matrixToTraverse[k][i];
                matrixToTraverse[k][i] = temp;
            }
    }
    private void transpose()
    {
        for (int i = 0; i < matrixToTraverse.length; i++)
            for (int j = i; j < matrixToTraverse[0].length; j++)
            {  
                int temp = matrixToTraverse[j][i];
                matrixToTraverse[j][i] = matrixToTraverse[i][j];
                matrixToTraverse[i][j] = temp;
            }
    }
      
    
    public void printMatrix()
    {
        for (int i = 0; i < matrixToTraverse.length; i++)
        {
            for (int j = 0; j < matrixToTraverse[0].length; j++)
                System.out.print(matrixToTraverse[i][j] + " ");
            System.out.println("");
             
        }
    }
    public void rotate90()
    {	
    	transpose();
        reverseColumns();
    }
    public void mirrorPatch() {
        
        for (int i = 0; i < this.matrixToTraverse.length; i++) {
            // for each column
            flipRow(matrixToTraverse[i]);
        }
    }

    private void flipRow(int[] row) {
        int length = row.length;
        for (int i = 0; i < length/2; i++) {
            int x = row[i];
            row[i] = row[length -1 - i];
            row[length -1 - i] = x;
        }
    }
    public void getAllSpiralListsClockwise() {
        
        int size = sizeOfMatrix;
        for(int k = 0; k < this.sizeOfMatrix; k++) {
       
            for(int i = 0; i < this.sizeOfMatrix; i++) {
                if(size > 3){
                    for(int j = 3; j  <= size - i ; j++) {
                        getSpiralListFromMatrix(k,i,j);
                    }
                }else{
                    for(int p = 3; p <= size - i; p++){
                       getSpiralListFromMatrix(k,i,3);
                    }
                }
            }
            size--;
        }
    }
    public void getAllSpiralListsAntiClockwise() {
    	mirrorPatch();
    	getAllSpiralListsClockwise();
    }
    //За да работи напълно, трябва да използвам функцията rotate90 4 пъти в едната и 4 пъти в другата посока
    public void getSpiralListFromMatrix(int startRow, int startCol, int contourSize) {
        List<Integer> arr = new ArrayList<>();

        int endRow = startRow + contourSize - 1;
        int endCol = startCol + contourSize - 1;

        for (int i = startCol; i <= endCol ; i++) { // move right
            arr.add(matrixToTraverse[startRow][i]);
        }

        for (int i = startRow+1; i <= endRow ; i++) { // move down
            arr.add(matrixToTraverse[i][endCol]);
        }

        for (int i = endCol-1; i >= startCol; i--) { // move left
            arr.add(matrixToTraverse[endRow][i]);
            System.out.println("End Row: " + endRow);
        }

        for (int i = endRow-1; i > startRow; i--) { // move up
            arr.add(matrixToTraverse[i][startCol]);
            if(i == startRow + 1) {
            	arr.add(matrixToTraverse[i][startCol + 1]);
            }
        }
        
        this.fiboList.add(arr);
    }
    public boolean isFibonacciSequence() {
        if (fiboList.isEmpty()) {
            return false;
        }
        List<Pair<List<Integer>, Boolean>> fibonaccis = getSequencesFromList();
        
        for(Pair<List<Integer>,Boolean> p: fibonaccis ) {
        	if(p.getValue()) {
        		return true;
        	}
        }
        
        return false;
    }

	private List<Pair<List<Integer>, Boolean>> getSequencesFromList() {
		List<Pair<List<Integer>,Boolean>> fibonaccis = new ArrayList<>();
        for(List<Integer> a:this.fiboList) {
        	fibonaccis.add(new Pair<>(a,isFibonacciList(a)));
        }
		return fibonaccis;
	}
    private boolean isFibonacciList(List<Integer> list) {
    	for(int i = 0; i < list.size() - 2; i++) {
    		if (list.get(i) + list.get(i + 1) != list.get(i + 2)) {
                return false;
            }
    	}
    	
    	return true;
    }
    
    public List<List<Integer>> getFiboList(){
    	return this.fiboList;
    }
    

   

    public static void main(String[] argc) {
    	int arr[][] = {{1, 1, 2, 4},
                	   {21, 1, 1, 2},
                	   {13, 21, 34, 3},
                	   {13, 13, 8, 5}};
    	FiboMatrix a = new FiboMatrix(arr,4);
    	a.getAllSpiralListsClockwise();
    	//a.getSpiralListFromMatrix(0, 0, 3);
    	
    	List<List<Integer>> copy = a.getFiboList();
    	System.out.println(copy.size());
    	for(List<Integer> l: copy) {
    		for(Integer i : l) {
    			System.out.print(i + " ");
    		}
    		System.out.print("\n");
    	}
    	System.out.println("Is fibonachi: " + a.isFibonacciSequence());
    }
}
