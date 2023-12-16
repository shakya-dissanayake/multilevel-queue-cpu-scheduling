import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import Models.Process;
import Algorithms.MultilevelQueueScheduler;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numberOfProcesses = scanner.nextInt();
        scanner.nextLine();

        List<Process> processes = new ArrayList<>();

        for (int i = 1; i <= numberOfProcesses; i++) {
            System.out.println("\n\u001B[33mEnter details for Process " + i + ":\u001B[0m");

            // priority/algorithm list
            System.out.println("Priority: (0-->2 : highest-->lowest)");
            System.out.println("\t0: Round Robin");
            System.out.println("\t1: Shortest Job First");
            System.out.println("\t2: First Come, First Served");
            System.out.print("> ");

            int priority = -1;
            while (priority < 0 || priority > 2) {
                priority = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (priority < 0 || priority > 2) {
                    System.out.println("Invalid priority. Please choose a value between 0 and 2.");
                    System.out.print("> ");
                }
            }

            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            scanner.nextLine();

            processes.add(new Process(i, priority, arrivalTime, burstTime));
        }

        MultilevelQueueScheduler scheduler = new MultilevelQueueScheduler(3);

        for (Process process : processes) {
            scheduler.addProcess(process);
        }

        scheduler.execute();
    }
}
