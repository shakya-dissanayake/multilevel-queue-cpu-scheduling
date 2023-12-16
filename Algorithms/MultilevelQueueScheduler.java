package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import Models.Process;
import Interfaces.SchedulingAlgorithm;

public class MultilevelQueueScheduler {
    private final List<Queue<Process>> queues;
    private int time;
    private final int quantum;

    public int getTime() {
        return time;
    }

    public void updateTime(int increment) {
        time += increment;
    }

    public MultilevelQueueScheduler(int numQueues) {
        queues = new ArrayList<>(numQueues);
        for (int i = 0; i < numQueues; i++) {
            queues.add(new LinkedList<>());
        }
        time = 0;
        quantum = 2; // Time quantum for Round Robin
    }

    public void addProcess(Process process) {
        queues.get(process.priority).add(process);
    }

    public void execute() {
        while (queues.stream().anyMatch(queue -> !queue.isEmpty())) {
            for (int i = 0; i < queues.size(); i++) {
                Queue<Process> queue = queues.get(i);
                if (!queue.isEmpty()) {
                    SchedulingAlgorithm scheduler = getScheduler(i);
                    scheduler.execute(queue, quantum);
                }
            }
            ageProcesses();
        }
    }

    private SchedulingAlgorithm getScheduler(int priority) {
        return switch (priority) {
            case 0 -> new RoundRobinScheduler(this);
            case 1 -> new ShortestJobFirstScheduler(this);
            case 2 -> new FirstComeFirstOutScheduler(this);
            default -> throw new IllegalArgumentException("\u001B[31mInvalid priority\u001B[0m");
        };
    }

    private void ageProcesses() {
        for (int i = 1; i < queues.size(); i++) {
            Queue<Process> queue = queues.get(i);
            List<Process> processesToRemove = new ArrayList<>();

            for (Process process : queue) {
                process.waitingTime++;

                if (process.waitingTime >= 5) {
                    process.priority = Math.max(process.priority - 1, 0);
                    processesToRemove.add(process);
                }
            }

            queue.removeAll(processesToRemove);
            queues.get(0).addAll(processesToRemove);
        }
    }
}
