package Algorithms;

import Intefaces.SchedulingAlgorithm;
import java.util.Comparator;
import Models.Process;
import java.util.Queue;

class ShortestJobFirstScheduler implements SchedulingAlgorithm {
    private final MultilevelQueueScheduler scheduler;

    public ShortestJobFirstScheduler(MultilevelQueueScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void execute(Queue<Process> queue, int quantum) {
        Process process = queue.stream().min(Comparator.comparingInt(p -> p.burstTime)).orElse(null);
        if (process != null) {
            queue.remove(process);
            System.out.println("Executing " + process);
            process.waitingTime += scheduler.getTime() - process.arrivalTime;
            scheduler.updateTime(process.burstTime);  // Update time using scheduler instance
            System.out.println("Process " + process.processId + " completed.");
        }
    }
}
