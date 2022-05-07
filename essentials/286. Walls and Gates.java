// 286. Walls and Gates 
// https://leetcode.com/problems/walls-and-gates/
// MEDIUM

// You are given an m x n grid rooms initialized with these three possible values.

// -1 A wall or an obstacle.
// 0 A gate.
// INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

class Solution {
    
    private static final int[][] DIRECTIONS = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    private static final int INF = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        if(m==0) return ;
        
        Deque<int[]> queue = new LinkedList<>();
        
        for(int row=0; row < m; row++) {
            for(int col=0; col < n; col++) {
                if(rooms[row][col] == 0) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            
            for(int[] direction: DIRECTIONS) {
                int nextX = current[0] + direction[0];
                int nextY = current[1] + direction[1];
                
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                    continue;
                }
                if (rooms[nextX][nextY] == WALL || rooms[nextX][nextY] == GATE || (rooms[nextX][nextY] > 0 && rooms[nextX][nextY] < INF)) {
                    continue;
                }
                rooms[nextX][nextY] = rooms[current[0]][current[1]] + 1;
                queue.addLast(new int[]{nextX, nextY});
            }
            
        }
        
    }
}