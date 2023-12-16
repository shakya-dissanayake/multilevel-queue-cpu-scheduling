package Algorithms;

import java.util.Queue;
import java.util.List;

public class MultilevelQueueScheduler {
    private List<Queue<Process>> queues;
    private int time;
    private int quantum;

    public int getTime() {
        return time;
    }

    public void updateTime(int increment) {
        time += increment;
    }
}
