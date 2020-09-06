//A robot on an infinite grid starts at point (0, 0) and faces north. The robot 
//can receive one of three possible types of commands: 
//
// 
// -2: turn left 90 degrees 
// -1: turn right 90 degrees 
// 1 <= x <= 9: move forward x units 
// 
//
// Some of the grid squares are obstacles. 
//
// The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1]) 
//
// If the robot would try to move onto them, the robot stays on the previous gri
//d square instead (but still continues following the rest of the route.) 
//
// Return the square of the maximum Euclidean distance that the robot will be fr
//om the origin. 
//
// 
//
// Example 1: 
//
// 
//Input: commands = [4,-1,3], obstacles = []
//Output: 25
//Explanation: robot will go to (3, 4)
// 
//
// 
// Example 2: 
//
// 
//Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//Output: 65
//Explanation: robot will be stuck at (1, 4) before turning left and going to (1
//, 8)
// 
// 
//
// 
//
// Note: 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// The answer is guaranteed to be less than 2 ^ 31. 
// 
// Related Topics 贪心算法 
// 👍 109 👎 0

//题目:[874]walking-robot-simulation  
package demo.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
        System.out.println(solution.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //贪心
    //欧式距离：多维空间中两个点之间的绝对距离
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int res = 0;
            //使用集合Set作为障碍物的数据结构，有效地检查下一步是否受阻
            //-30000 <= obstacle[i][0] <= 30000
            //-30000 <= obstacle[i][1] <= 30000
            //2^16=65536
            Set<Long> obstacleSet = new HashSet();
            for (int[] obstacle : obstacles) {
                long ox = (long) obstacle[0] + 30000;
                long oy = (long) obstacle[1] + 30000;
                obstacleSet.add((ox << 16) + oy);
            }
            //i=0向北,i=1向东, i=2向南,i=3向西
            int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int di = 0;
            int x = 0, y = 0;
            for (int i = 0; i < commands.length; i++) {
                if (commands[i] == -1) {
                    //右
                    di = (di + 1) % 4;
                } else if (commands[i] == -2) {
                    //左
                    di = (di + 3) % 4;
                } else {
                    //命令为移动
                    int nextX = 0, nextY = 0;
                    for (int j = 0; j < commands[i]; j++) {
                        nextX = x + direction[di][0];
                        nextY = y + direction[di][1];
                        long tmp = (((long) nextX + 30000) << 16) + ((long) nextY + 30000);
                        //遇到障碍物
                        if (obstacleSet.contains(tmp)) {
                            break;
                        }
                        //更新坐标及欧式距离平方
                        x = nextX;
                        y = nextY;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}