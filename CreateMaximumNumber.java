public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[][] pre = new int[m+1][n+1];
        int[][] cur = new int[m+1][n+1];
        int maxVal = 0;
        
        for(int kk=1; kk<=k; kk++){
            for(int i=0; i<= m; i++){
                for(int j=0; j<=n; j++){
                    if(i+j < kk) continue;
                    int temp = 0;
                    if(i == 0){
                        temp = Math.max(pre[0][kk-1]*10+ nums2[j-1], cur[0][j-1]);
                    }else if(j == 0){
                        temp = Math.max(pre[kk-1][0]*10+ nums1[i-1], cur[i-1][0]);
                    }else{
                        temp = cur[i-1][j-1];
                        if(pre[i][j-1]*10+nums2[j-1] > temp){
                            temp = pre[i][j-1]*10+nums2[j-1];
                        }
                        
                        if(pre[i-1][j]*10 + nums1[i-1] > temp){
                            temp = pre[i-1][j]*10 + nums1[i-1];
                        }
                    }
                    cur[i][j] = Math.max(cur[i][j],temp);
                    maxVal = Math.max(cur[i][j], maxVal);
                    
                    //System.out.println("maxVal:"+maxVal+" kk:"+kk+" i:"+i+" j:"+j);
                }
            }
            int[][] tempArray = pre;
            pre = cur;
            cur = tempArray;
            cur[0][0] = 0;
        }
        
        int temp = maxVal, i = k-1;
        int[] res = new int[k];
        while(temp != 0){
            res[i] = temp %10;
            temp = temp /10;
            i--;
        }
        return res;
    }
}