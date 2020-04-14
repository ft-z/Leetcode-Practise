public class Main {

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = new int[]{0, 3, 3, 4};
        int[] nums=new int[]{-1};
        int length = removeDuplicates(nums);

        System.out.println("length" + length);

        for (int i : nums) {
            System.out.print(" " + i);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = 0;
        //可以把重复元素换到数组后面，只打印length长度的数组。交换的时候用1个额外空间。当然用妙的方法进行值覆盖会省掉额外空间
        int temp;

        //从后往前，可以很快把后面变成重复元素存储的地方
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums.length<=0){
                return -1;
            }
            //找到第一个非重复元素,考虑数组短于3的情况
            if (nums[i] == nums[nums.length - 1]) {
                length = i+1;
                continue;
            }

            //当i位置值不重复后方数组的值
            if (nums[i] != nums[i + 1]) {
                if(nums[i+1]==nums[length-1]){
                    length=i+1+1;
                    continue;
                }
                continue;
            }

            //当i值在中间，重复值，全把后方的非重复值覆盖过来(i+1~length-1)
            if (nums[i + 1] == nums[i]) {
                temp=i+1;
                while(temp!=length){
                    nums[temp-1]=nums[temp++];
                }
                length--;
            }
            //边界条件
            if (length <= 0) {
                return -1;
            }
        }

        return length;
    }
}
