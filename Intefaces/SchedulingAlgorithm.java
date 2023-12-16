package Intefaces;
import java.util.Queue;
import Models.Process;

public interface SchedulingAlgorithm {
    void execute(Queue<Process> queue, int quantum);
}
