
public class InverseIndexPair{

	public int inversePair(int[] nums){
        return mergeSort(nums, 0, nums.length-1);
	}

	public int mergeSort(int[] nums, int start, int end){
		if(start >= end) return 0;
		
		int mid = start + (end-start)/2;
		int c1 = mergeSort(nums, start, mid);
		int c2 = mergeSort(nums, mid+1, end);
		int[] subArray = new int[end-start+1];

		int p1 = start, p2 = mid+1, index = 0, sum = 0;
		while(p1 <= mid && p2 <= end){
			if(nums[p1] <= nums[p2]){
				subArray[index++] = nums[p1++];
			}else{//nums[p1]  > nums[p2]
                sum += mid - p1 + 1;
                subArray[index++] = nums[p2++];
			}
		}
		while(p1 <= mid){
			subArray[index++] = nums[p1];
			p1++;
		}
		while(p2 <= end){
			subArray[index++] = nums[p2];
			p2++;
		}
		index = start;
		for(int i= 0; i<end-start+1; i++){
			nums[index++] = subArray[i];
		}
        return sum+c1+c2;
	}

	public static void main(String[] args){
		int[] nums = {1,3,5,2,4};
        InverseIndexPair ip = new InverseIndexPair();
        int pairs = ip.inversePair(nums);
        System.out.println(pairs);
	}
}