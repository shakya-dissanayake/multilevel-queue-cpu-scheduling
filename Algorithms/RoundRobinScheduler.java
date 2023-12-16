package Algorithms;

import java.util.Queue;
import Interfaces.SchedulingAlgorithm;
import Models.Process;

class RoundRobinScheduler implements SchedulingAlgorithm {
    private final MultilevelQueueScheduler scheduler;

    public RoundRobinScheduler(MultilevelQueueScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void execute(Queue<Process> queue, int quantum) {
        Process process = queue.poll();
        System.out.println("Executing " + process);
        assert process != null;
        process.waitingTime += scheduler.getTime() - process.arrivalTime;
        if (process.burstTime > quantum) {
            process.burstTime -= quantum;
            scheduler.updateTime(quantum);  // Update time using scheduler instance
            queue.add(process);
        } else {
            scheduler.updateTime(process.burstTime);  // Update time using scheduler instance
            process.burstTime = 0;
            System.out.println("Process " + process.processId + " completed.");
        }
    }
}
