import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
        
        int n = senate.length();

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiant = radiantQueue.poll();
            int dire = direQueue.poll();
            
            if (radiant < dire) {
                radiantQueue.offer(radiant + n);
            } else {
                direQueue.offer(dire + n);
            }
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}