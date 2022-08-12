package main.java;

class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int min = nums[nums.length - 1];
        int position = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (min > nums[i]) {
                position = i;
                min = nums[i];
                break;
            } else {
                min = nums[i];
            }
        }
        if (position == nums.length - 1) {
            reserver(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (min < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                break;
            }
        }
        reserver(nums, position + 1, nums.length - 1);
    }

    private void reserver(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
    }

    public static void main(String[] args) {
        int[] req = new int[]{1, 3, 2};
        LeetCode31 solution31 = new LeetCode31();
        solution31.nextPermutation(req);
        System.out.println();
    }
}