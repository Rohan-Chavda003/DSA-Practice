package arrayandhashing;

public class RangeSumQuery2d {
    static class NumMatrix {
        int[][] prefixSum;

        /*
            Time Complexity  : O(m * n)
            Space Complexity : O(m * n)

            Reason:
            - We compute prefix value for each cell once. Think how and formula your self
            - prefixSum array size is (m+1) x (n+1) ≈ m * n.
        */
        public NumMatrix(int[][] matrix) {
            prefixSum = new int[matrix.length +1 ][matrix[0].length+1];

            for(int i= 1 ; i<= matrix.length  ; i++){
                for(int j=1 ; j<= matrix[0].length ; j++){
                    prefixSum[i][j] = matrix[i-1][j-1]+ prefixSum[i-1][j] +prefixSum[i][j-1] -prefixSum[i-1][j-1];
                }
            }

        /*
            prefix[i][j] =
                matrix[i][j]
                + (i > 0 ? prefix[i-1][j] : 0)
                + (j > 0 ? prefix[i][j-1] : 0)
                - (i > 0 && j > 0 ? prefix[i-1][j-1] : 0)
        */
        }
        /*
        Time Complexity  : O(1)
        Space Complexity : O(1)

        Reason:
        - Only 4 prefix array accesses.
        - No loops.
    */
        public int sumRegion(int row1, int col1, int row2, int col2) {

            return prefixSum[row2+1][col2+1] -prefixSum[row2+1][col1] - prefixSum[row1][col2+1] + prefixSum[row1][col1];

        /*
        answer =
            prefix[row2][col2]
            - (row1 > 0 ? prefix[row1-1][col2] : 0)
            - (col1 > 0 ? prefix[row2][col1-1] : 0)
            + (row1 > 0 && col1 > 0 ? prefix[row1-1][col1-1] : 0)
*/
        }
    }

/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
