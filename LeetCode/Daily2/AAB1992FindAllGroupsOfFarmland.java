package LeetCode.Daily2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AAB1992FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        List<int[]> results = new ArrayList<int[]>();
        int result[];
        int i =0,j=0;
        while(i<land.length){
            j=0;
            while(j<land[0].length){
                if(land[i][j]==1){
                    result = findAnIsland(land,i,j);
                    System.out.println(Arrays.toString(result));
                    results.add(result);
                }
                j++;
            }
            i++;
        }
        return results.toArray(new int[0][]);
    }
    public int[] findAnIsland(int [][] land,int startX, int startY){
        int endX = startX;
        int endY = startY;
        for(endX = startX;endX<land.length && land[endX][startY]==1;endX++){
            for(endY = startY;endY<land[0].length && land[endX][endY]==1;endY++){
                land[endX][endY] =0;
            }
        }

        return new int[]{startX,startY,endX-1,endY-1};
    }

    public static void main(String[] args) {
        AAB1992FindAllGroupsOfFarmland obj = new AAB1992FindAllGroupsOfFarmland();
        int [][] results = obj.findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}});
        for(int[] row: results){
            System.out.println(Arrays.toString(row));
        }
    }
}
