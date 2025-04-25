package week02;

import javax.swing.tree.TreeNode;
import java.util.*;

public class LeetCode_KeysNRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer>  queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int curRoom = queue.poll();
            for (int nextRoom : rooms.get(curRoom)) {
                if (!visited[nextRoom]) {
                    visited[nextRoom] = true;
                    queue.add(nextRoom);
                }
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
    public static List<List<Integer>> roomList(int[][] rooms) {
        List<List<Integer>> allRooms = new ArrayList<>();
        for(int i = 0; i < rooms.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < rooms[i].length; j++) {
                list.add(rooms[i][j]);
            }
            allRooms.add(list);
        }

        System.out.println(allRooms);
        return allRooms;
    }


    public static void main(String[] args) {
        int[][] rooms1 = new int[][]{{1},{2},{3},{}};
        int[][] rooms2 = new int[][]{{1,3},{3,0,1},{2},{0}};

        boolean res1=canVisitAllRooms(roomList(rooms1));
        boolean res2=canVisitAllRooms(roomList(rooms2));

        System.out.println(res1);
        System.out.println(res2);


    }


}
