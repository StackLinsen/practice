package com.linsen.jvm.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: linsen
 * @date: 2022/11/5
 * @description:
 */
public class ForkJoinTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);

        ForkJoinTask<Integer> future = forkJoinPool.submit(new SumTask(1, 10000));

        if(future.isCompletedAbnormally()){
            System.out.println(future.getException());
        }

        System.out.println(future.get());



    }
}
