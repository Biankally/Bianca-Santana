
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    
    public static void main(String[] args) {
        
        int[][] mat = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };

        printMatrix(mat);

        printMatrix(setMatrixZeroes(mat));
        
    }

    public static int[][] setMatrixZeroes(int[][] mat){

        Set<Integer> rowIndexesToChange = new HashSet<>();
        Set<Integer> columnIndexesToChange = new HashSet<>();

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == 0){
                    rowIndexesToChange.add(i);
                    columnIndexesToChange.add(j);
                }
            }
        }

        for (int rowIndex : rowIndexesToChange)
            Arrays.fill(mat[rowIndex], 0);

        for (int[] row : mat)
            for (int columIndex : columnIndexesToChange)
                row[columIndex] = 0;
        
        return mat;
    }
   
    private static void printMatrix(int[][] matrix){
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
