
/* segment tree | set 1
 * we have an array arr[0 ... n-1], need to support two operations
 * 1 Find the sume of elements from index l to r
 * 2 Change value of a specified element of the array[i] = x
*/

class SegmentTreeNode {
	public int L;
	public int R;
    public int sum;

	public SegmentTreeNode left;
	public SegmentTreeNode right;
	public SegmentTreeNode(int L, int R, int val){
		this.L = L;
		this.R = R;
		sum = val;
		left = right = null;
	}

}

public class SegmentTree{
	private SegmentTreeNode root;

    public SegmentTree(int[] nums, int L, int R){
    	root = buildTree(nums, L, R);
    }

    public SegmentTreeNode buildTree(int[] nums, int L, int R){
        if(L > R) return null;
        if(L == R) return new SegmentTreeNode(L,R,nums[L]);
        SegmentTreeNode cur = new SegmentTreeNode(L,R,0);
        int mid = L + (R-L)/2;
        cur.left = buildTree(nums,L, mid);
        cur.right = buildTree(nums,mid+1, R);
        cur.sum = cur.left.sum + cur.right.sum;
        return cur;
    }

    public int getSum(int ql, int qr){
    	return getSumUtil(ql,qr,root);
    }
    private int getSumUtil(int ql, int qr, SegmentTreeNode node){
    	if(root == null) return 0;
    	if(node.L >= ql && node.R <= qr){
    		System.out.println("["+node.L+" "+node.R+"]:"+node.sum);
    		return node.sum;
    	}else if(node.L > qr || node.R < ql){
    		return 0;
    	}else{
    		return getSumUtil(ql, qr, node.left) + getSumUtil(ql, qr, node.right);
    	}

    }

    public void update(int[] nums, int index, int value){
        int diff =  value - nums[index];
        nums[index] = value;
        updateUtil(root, diff, index);
    }
    private void updateUtil(SegmentTreeNode node, int diff, int index){
    	if(node.L <= index && index <= node.R) node.sum += diff;
    	else if(index < node.L || index > node.R) return;
    	if(node.left != null)updateUtil(node.left, diff, index);
    	if(node.right!= null)updateUtil(node.right, diff, index);
    	
    }
    public static void main(String[] args){
    	int[] nums = {0,1,2,3,4,5,6};
    	SegmentTree tree = new SegmentTree(nums,0, nums.length-1);
    	assert(tree.getSum(1,3) == 6);
    	System.out.println(tree.getSum(1,3));
    	tree.update(nums,3, 2);
    	assert(tree.getSum(1,3) == 5);
    	System.out.println(tree.getSum(1,3));
    }
}