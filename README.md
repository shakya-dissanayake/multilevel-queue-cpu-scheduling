# Multilevel Queue CPU Scheduling with Aging

This repository contains a Java implementation of a Multilevel Queue CPU Scheduling algorithm with aging. The scheduling algorithm is designed to address potential CPU starvation in lower-priority queues by gradually increasing the priority of waiting processes.

## Table of Contents

- [Overview](#overview)
- [How to Use](#how-to-use)
- [Example](#example)

## Overview

The project includes classes representing processes (`Process`), a multilevel queue scheduler (`MultilevelQueueScheduler`), and a main class (`Main`) for demonstration. The scheduling algorithm executes processes based on their priority, with aging implemented to prevent CPU starvation in lower-priority queues.

## How to Use

1. Clone the repository:

    ```bash
    git clone https://github.com/shakya-dissanayake/multilevel-queue-cpu-scheduling.git
    cd multilevel-queue-scheduling
    ```

2. Compile and run the Java program:

    ```bash
    javac Main.java
    java Main
    ```

## Example

The `Main` class demonstrates the usage of the multilevel queue scheduler with user-input processes. Follow the instructions to input details for each process, including priority and algorithm choice.

```
Enter the number of processes: 2

Enter details for Process 1:
Priority: (0-->2 : highest-->lowest)
	0: Round Robin
	1: Shortest Job First
	2: First Come, First Served
> 0
Arrival Time: 0
Burst Time: 10

Enter details for Process 2:
Priority: (0-->2 : highest-->lowest)
	0: Round Robin
	1: Shortest Job First
	2: First Come, First Served
> 1
Arrival Time: 0
Burst Time: 5

Executing Process 1 (Priority 0): Algorithm = RB, Arrival Time = 0, Burst Time = 10, Waiting Time = 0
Executing Process 2 (Priority 1): Algorithm = SJF, Arrival Time = 0, Burst Time = 5, Waiting Time = 0
Process 2 completed.
Executing Process 1 (Priority 0): Algorithm = RB, Arrival Time = 0, Burst Time = 8, Waiting Time = 0
Executing Process 1 (Priority 0): Algorithm = RB, Arrival Time = 0, Burst Time = 6, Waiting Time = 7
Executing Process 1 (Priority 0): Algorithm = RB, Arrival Time = 0, Burst Time = 4, Waiting Time = 16
Executing Process 1 (Priority 0): Algorithm = RB, Arrival Time = 0, Burst Time = 2, Waiting Time = 27
Process 1 completed.
````
