package com.linsen.leetcode.search;

import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/3
 * @description:
 */
public class No127 {


    public static void main(String[] args) {
        No127 no127 = new No127();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        no127.ladderLength("hit", "cog", wordList);
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cell = queue.poll();
                for(String nextCell : getNext(cell, wordList, seen)){
                    if(nextCell.equals(endWord)){
                        return ++step;
                    }
                    if(!seen.contains(nextCell)){
                        queue.offer(nextCell);
                        seen.add(nextCell);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private List<String> getNext(String cell, List<String> wordList, Set<String> seen) {
        List<String> nextCellList = new ArrayList<>();
        for(String word : wordList){
            if(!seen.contains(word) && canBeNext(cell, word)){
                nextCellList.add(word);
            }
        }
        return nextCellList;
    }

    private boolean canBeNext(String cell, String word) {

        int length = cell.length();
        int notSame = 0;
        for(int i = 0; i < length; i++){
            if(cell.charAt(i) != word.charAt(i)){
                notSame++;
            }
            if(notSame > 1){
                return false;
            }
        }
        return true;
    }
}
