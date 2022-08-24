package com.linsen.leetcode.day_20220823;

/**
 * 颜色分类
 * 荷兰国旗问题
 */
public class No75 {


    public static void main(String[] args) {
        No75 no75 = new No75();
        no75.sortColors_4(new int[]{2,0,1});
    }


    /**
     * 根据个数重写数组
     * @param nums
     */
    public void sortColors(int[] nums) {
        int length = nums.length;
        int sum0 = 0;
        int sum1 = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] == 0){
                sum0++;
            }else if(nums[i] == 1){
                sum1++;
            }
        }

        for(int i = 0; i < length; i++){
            if(i < sum0){
                nums[i] = 0;
            }else if(i < sum0 + sum1){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }


    /**
     * 单指针+两次遍历
     * @param nums
     */
    public void sortColors_2(int[] nums){
        int n = nums.length;
        int ptr = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i < n; i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }


    /**
     * 双指针
     * @param nums
     */
    public void sortColors_3(int[] nums){
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                //如果第一次走到这里发生交换时，就代表此时p0指向的数字已经等于1了
                //如果后续再走到else分支，和p0交换，那么1肯定会被交换出去，此时和指向1末端的p1交换极客
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }else if(nums[i] == 0){
                //如果走到这个分支，
                // 如果是一开始就进入该分支，p0=p1,那么只需要交换p0即可，但是p1也得移动，因为他要指向的是1的末端
                // 如果是后续进入这里的，此时p0已经指向0的末端，指向1了，所以交换出去的是1，还得和p1交换回来放在末端
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }


    /**
     * 双指针，从两头
     * @param nums
     */
    public void sortColors_4(int[] nums){

        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for(int i = 0; i <= p2; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }else if(nums[i] == 2){
                while(nums[p2] == 2 && p2 >= i){
                    p2--;
                }
                //直到遇到p2不为2时，才开始交换，如果是2，则往前移一格
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
            }
        }

    }
}
