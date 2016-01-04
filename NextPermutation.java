public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i=nums.length-2;
        boolean found = false;
        for(; i>=0; i--){
            if(nums[i] < nums[i+1] ){
                found = true;
                break;
            }    
        }
        if(!found){
            Arrays.sort(nums);
            return;
        }
        int j=nums.length-1;
        for(; j>i; j--){
            if(nums[j] > nums[i]) break;
        }
        swap(nums, i, j);
        Arrays.sort(nums, i+1, nums.length);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}