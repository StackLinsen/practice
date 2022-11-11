package com.linsen.jvm.forkjoin;

import sun.tools.jconsole.VMInternalFrame;

import java.util.concurrent.RecursiveTask;

/**
 * @author: linsen
 * @date: 2022/11/5
 * @description:
 */
public class SumTask extends RecursiveTask<Integer> {

    private final int begin;

    private final int end;


    public SumTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(this.end - this.begin < 100){
            int sum = 0;
            for(int i = begin; i <= end; i++){
                sum += i;
            }
            return sum;
        }else{

            int middle = (begin + end) / 2;
            SumTask sumTask1 = new SumTask(begin, middle);
            SumTask sumTask2 = new SumTask(middle + 1, end);

            sumTask1.fork();
            sumTask2.fork();


            int sum1 = sumTask1.join();
            int sum2 = sumTask2.join();
            return sum1 + sum2;

        }

    }
}
