package Models;

import Enums.SchedulingAlgorithm;

public class Process {
    public int processId;
    public int priority;
    public int arrivalTime;
    public int burstTime;
    public int waitingTime;

    public Process(int processId, int priority, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
    }

    @Override
    public String toString() {
        return "Process " + processId +
                " (Priority " + priority + "):" +
                " Algorithm = " + SchedulingAlgorithm.values()[priority] +
                ", Arrival Time = " + arrivalTime +
                ", Burst Time = " + burstTime +
                ", Waiting Time = " + waitingTime;
    }
}
