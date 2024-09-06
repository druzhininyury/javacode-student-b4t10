package ru.javacode.student;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private long factor;

    public FactorialTask(long factor) {
        this.factor = factor;
    }

    @Override
    protected Long compute() {

        if (factor <= 1L) {
            return 1L;
        }

        FactorialTask recursiveTask = new FactorialTask(factor - 1L);
        recursiveTask.fork();

        return factor * recursiveTask.join();
    }
}
