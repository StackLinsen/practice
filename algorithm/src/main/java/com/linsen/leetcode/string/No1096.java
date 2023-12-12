package com.linsen.leetcode.string;

import java.util.*;

/**
 * @author: linsen
 * @date: 2023/3/7
 * @description:
 */
public class No1096 {

    String expression;
    int idx;


    public static void main(String[] args) {

        No1096 no1096 = new No1096();
        no1096.braceExpansionII("{a,b}{c,{d,e}}");
    }




    public List<String> braceExpansionII(String expression){

        this.expression = expression;
        this.idx = 0;
        Set<String> ret = expr();

        return new ArrayList<>(ret);
    }

    /**
     * expr表示一个任意一种表达式
     * expr-> term | term，expr
     * expr可以分解成一个最外层没有逗号分割的表达式 或者 一个最外层没有逗号分割的表达式和任意表达式通过逗号相连
     *
     * 不断调用term，并与其结果进行合并。如果匹配到表达式末尾或者当前字符不是逗号时，则返回
     * @return
     */
    private Set<String> expr() {
        Set<String> ret = new TreeSet<>();

        while(true){
            //与term()求解结果求并集
            ret.addAll(term());
            //如果匹配到逗号则继续，否则结束匹配
            if(idx < expression.length() && expression.charAt(idx) == ','){
                idx++;
                continue;
            }else{
                break;
            }
        }
        return ret;
    }

    /**
     * 用term表示一个最外层没有逗号分隔的表达式
     * term可以由小写英文字母或者花括号包括的表达式直接相连组成
     * 不断的调用item，并与其结果求积。如果匹配到表达式末尾或者当前字符不是小写字母，并且也不是左括号时，则返回
     * @return
     */
    private Set<String> term() {
        Set<String> ret = new TreeSet<String>(){{
            add("");
        }};

        while(idx < expression.length() && (expression.charAt(idx) == '{' || Character.isLetter(expression.charAt(idx)))){
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<>();
            for(String left : ret){
                for(String right : sub){
                    tmp.add(left + right);
                }
            }
            ret = tmp;
        }
        return ret;
    }

    /**
     *  item表示每一个相接单元
     *  item可以进一步分解为小写英文字母letter或者花括号包括的表达式
     *  根据当前字符是不是左括号来求解，如果是左括号，则调用expr，返回结果；否则构造一个只包含当前字符的字符串集合，返回结果
     * @return
     */
    private Set<String> item() {
        Set<String> ret = new TreeSet<>();
        if(expression.charAt(idx) == '{'){
            idx++;
            ret = expr();
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(expression.charAt(idx));
            ret.add(sb.toString());
        }
        idx++;
        return ret;
    }


}
