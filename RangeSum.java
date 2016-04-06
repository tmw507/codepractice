import java.util.*;

class Segment{
    public int L;
    public int R;
    public int val;
    
    public Segment left;
    public Segment right;
    public Segment(int L,int R, int val){
        this.L = L;
        this.R = R;
        this.val = val;
        left = right = null;
    }
}
public class RangeSum {
    private Segment root;
    private int[] array;
    public RangeSum(int[] nums) {
        root = constructSegmentTree(nums, 0, nums.length-1);
        array = new int[nums.length];
        array = Arrays.copyOf(nums,nums.length);
    }

    void update(int i, int val) {
        int diff = array[i] - val;
        updateHelper(i, diff, root);
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(i,j,root);
    }
    private int sumRangeHelper(int i, int j, Segment node){
        if(i>j || node == null) return 0;
        if(i<= node.L && j>= node.R){
            return node.val;
        }else {
            return sumRangeHelper(i, j, node.left) + sumRangeHelper(i,j, node.right);
        }
    }
    private void updateHelper(int i, int diff, Segment node){
        if(node == null) return;
        if(node.L <= i && i<= node.R){
            node.val += diff;
        }else return;
        if(node.left != null) updateHelper(i, diff, node.left);
        if(node.right != null) updateHelper(i, diff, node.right);
    }
    private Segment constructSegmentTree(int[] nums, int L, int R){
        if(R <= L) return null;
        else if(R == L){
            return new Segment(L,R, nums[L]);
        }
        int mid = L+(R-L)/2;
        Segment left = constructSegmentTree(nums,L, mid);
        Segment right = constructSegmentTree(nums, mid+1, R);
	int sum = 0;
	if(left != null) sum += left.val;
	if(right != null) sum += right.val;
        Segment node = new Segment(L,R, sum);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args){
        int[] nums = {-1};
        RangeSum  na = new RangeSum(nums);
        assert na.sumRange(0,0) == -1;
        na.update(0,1);
        assert na.sumRange(0,0) == 1;

    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
