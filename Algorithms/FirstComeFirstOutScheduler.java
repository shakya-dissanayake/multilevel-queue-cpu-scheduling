package Algorithms;

import java.util.Queue;
import Interfaces.SchedulingAlgorithm;
import Models.Process;

public class FirstComeFirstOutScheduler implements SchedulingAlgorithm {
    private final MultilevelQueueScheduler scheduler;

    public FirstComeFirstOutScheduler (MultilevelQueueScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void execute(Queue<Process> queue, int quantum) {
        Process process = queue.poll();
        System.out.println("Executing " + process);
        assert process != null;
        process.waitingTime += scheduler.getTime() - process.arrivalTime;
        scheduler.updateTime(process.burstTime);  // Update time using scheduler instance
        System.out.println("Process " + process.processId + " completed.");
    }
}
