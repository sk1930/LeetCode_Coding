package LeetCode.Daily2;

public class AAB463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        System.out.println(grid.length); // no. of rows
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i==0 ){
                        count++;
                    }
                    if(i==grid.length-1){
                        count++;
                    }
                    if(j==0 ){
                        count++;
                    }
                    if(j==(grid[0].length-1)){
                        count++;
                    }
                    if((i+1<grid.length) && (grid[i+1][j]!=1)){
                        count++;
                    }
                    if((i>0) && (grid[i-1][j]!=1)){
                        count++;
                    }
                    if((j+1<grid[0].length)&&(grid[i][j+1]!=1)){
                        count++;
                    }
                    if((j>0) &&(grid[i][j-1]!=1)){
                        count++;
                    }
                }

            }
        }


        return count;
    }

    public static void main(String[] args) {
        AAB463IslandPerimeter obj = new AAB463IslandPerimeter();

        //System.out.println(obj.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        //[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] -- output should be 16


        System.out.println(obj.islandPerimeter(new int[][]{{1}})); // output should be 4


        System.out.println(obj.islandPerimeter(new int[][]{{1,0}})); // output should be 4
    }
}
