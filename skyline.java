class PointComp implements Comparator<int[]> {
    //<X,L/R, H>, rank by X coordinate first, then L/R indicator, then height desc
    public int compare(int[] A, int[] B){
        if(A[0] > B[0]) return 1;
        else if(A[0] < B[0]) return -1;
        else {
            return A[1]-B[1] == 0? B[2]-A[2]: A[1]-B[1];
        }
    }
}
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0) return ret;
        int m = buildings.length;
        List<int[]> endPoints = new ArrayList<int[]>();
        for(int i=0; i<m; i++){
            int[] bl = {buildings[i][0],  0, buildings[i][2]};
            int[] br = {buildings[i][1],  1, buildings[i][2]};
            endPoints.add(bl);
            endPoints.add(br);
        }
        Collections.sort(endPoints, new PointComp());
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
      
        for(int[] point :endPoints){
            Integer curHeight = null;
            if(map.size() != 0) curHeight = map.lastKey();
          
            if(point[1] == 0){//new left point
                //add one entry to the contour if point[2] > curHeight
                if(curHeight == null || point[2] > curHeight){
                    int[] contor = {point[0], point[2]};
                    ret.add(contor);
                }
                // add the current building height into the TreeMap
                if(!map.containsKey(point[2]))
                    map.put(point[2],1);
                else{
                    map.put(point[2],map.get(point[2])+1);
                }
            }else{  // a right point
                //decrease count of the entry in the treemap with height of point[2], remove it if its count is 1
                
                Integer heightCount = map.get(point[2]);
                if(heightCount == 1)
                    map.remove(point[2]);
                else
                    map.put(point[2], heightCount-1);
                    
                Integer newHeight = map.size() > 0? map.lastKey(): 0;
                
                if(curHeight > newHeight){
                   int[] contour = {point[0], newHeight};
                   int[] lastElem = ret.get(ret.size()-1);
                   // interval ended at the same x position, updated with the smaller height
                   if(contour[0] == lastElem[0] && lastElem[1] > contour[1]){
                      ret.remove(ret.size()-1);
                   }
                   ret.add(contour);
                }
                //ignor newHeight < curHeight, i.e, some lower height interval end
            }
        }
        return ret;
    }
}