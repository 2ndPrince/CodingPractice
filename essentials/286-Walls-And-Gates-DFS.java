// Question  : 286. Walls and Gates 
// Link      : https://leetcode.com/problems/walls-and-gates/
// Author    : Youngseok Lee
// Meta Info : Medium, 2D Array, BFS

/*************************************************************************************** 
 *
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * Example 1:
 * 
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * 
 * Example 2:
 * 
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 ***************************************************************************************/

class Solution {
    
    private static final int[][] DIRECTIONS = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    private static final int INF = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        if(m==0) return ;
        
        for(int row=0; row < m; row++) {
            for(int col=0; col < n; col++) {
                if(rooms[row][col] == 0) {
                    dfs(rooms, row, col, 0);
                }
            }
        }

    }
    
    private void dfs(int[][] rooms, int row, int col, int step) {
        int m = rooms.length;
        int n = rooms[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return ;
        }
        if (step > rooms[row][col] ) {
            return ;
        }
        
        rooms[row][col] = step;
        for(int[] direction: DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            dfs(rooms, nextRow, nextCol, step + 1);
        }
    }
}
