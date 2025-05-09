
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t); //add current ping

        //Remove pings older than 3000ms
        while(queue.peek()<t-3000){
            queue.poll();
        }

        return queue.size(); // Recent calls within [t-3000, t]
    }


    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

    }

}
