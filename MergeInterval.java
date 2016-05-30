/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if(intervals == null || intervals.size() < 1) return ret;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval I1, Interval I2){
                return I1.start - I2.start;
            }
        });
        for(Interval I: intervals){
            if(ret.isEmpty()){
                ret.add(I);
            }else{
                Interval temp = ret.get(ret.size() -1);
                if(temp.end >= I.start){
                    temp.end = Math.max(temp.end, I.end);
                }else{
                    ret.add(I);
                }
            }
        }
        return ret;
        
    }
}