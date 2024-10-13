package LeetCode.Arrays.Medium;

import LeetCode.Set.Medium.AAA001_1110_DeleteNodesAndReturnForest;

public class AAA004_1605FindValidMatrixGivenRowAndColumnSums {
    /*Time Limit Exceeded
    rowSum =[1,0]
    colSum=[1]
    in the second solution only difference added is single while loop instead of 2

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numRows = rowSum.length;
        int numCols= colSum.length;
        int [][] result = new int[numRows][numCols];
        int i=0,j = 0;
        int resultIJ=0;
        while(i<numRows){
            while (j<numCols){
                resultIJ = rowSum[i]<=colSum[j]?rowSum[i]:colSum[j];
                rowSum[i]= rowSum[i]-resultIJ;
                colSum[j] = colSum[j]-resultIJ;
                result[i][j]=resultIJ;

                if(rowSum[i]==0)
                    i++;
                if(colSum[j]==0)
                    j++;
            }
        }



        return result;
    }

     */

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numRows = rowSum.length;
        int numCols= colSum.length;
        int [][] result = new int[numRows][numCols];
        int i=0,j = 0;
        int resultIJ=0;
        while(i<numRows && j<numCols){
            //while (j<numCols){
                resultIJ = rowSum[i]<=colSum[j]?rowSum[i]:colSum[j];
                rowSum[i]= rowSum[i]-resultIJ;
                colSum[j] = colSum[j]-resultIJ;
                result[i][j]=resultIJ;

                if(rowSum[i]==0)
                    i++;
                if(colSum[j]==0)
                    j++;

        }



        return result;
    }
    public static void main(String[] args) {
        AAA004_1605FindValidMatrixGivenRowAndColumnSums obj = new AAA004_1605FindValidMatrixGivenRowAndColumnSums();

        int[] rowsum = new int[]{3,8};
        int [] colsum = new int[]{4,7};


        //case 2
        rowsum =new int[]{1,0};
        colsum=new int[]{1};
        for(int row[]:obj.restoreMatrix(rowsum,colsum)){
            for(int col :row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

}
