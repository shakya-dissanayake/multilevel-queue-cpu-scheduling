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

The `Main` class demonstrates the usage of the multilevel queue scheduler with example processes. Feel free to modify the example processes in the `Main` class according to your requirements.

```java
// Your example processes here
````
