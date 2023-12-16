import java.util.List;
import java.util.ArrayList;
import Models.Process;
import Algorithms.MultilevelQueueScheduler;

public class Main {
    public static void main(String[] args){
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 0, 8));
        processes.add(new Process(2, 1, 1, 6));
        processes.add(new Process(3, 2, 2, 10));
        processes.add(new Process(4, 0, 3, 4));
        processes.add(new Process(5, 1, 4, 5));

        MultilevelQueueScheduler scheduler = new MultilevelQueueScheduler(3);

        for (Process process : processes) {
            scheduler.addProcess(process);
        }

        scheduler.execute();
    }
}
