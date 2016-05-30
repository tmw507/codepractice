/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Iterator<NestedInteger> outNit;
    private Deque<NestedInteger> Q;

       
    public NestedIterator(List<NestedInteger> nestedList) {
        outNit = nestedList.iterator();
        Q = new LinkedList<NestedInteger>();
    }

    @Override
    public Integer next() {
          if(hasNext()){
              return Q.pollFirst().getInteger();
          } 
          return null;
    }
    
    @Override
    public boolean hasNext() {
        if(Q == null || Q.size() == 0){
            if(outNit.hasNext() == false) return false;
            Q.addFirst(outNit.next());
            return hasNext();
        }else if( !Q.peekFirst().isInteger()) {
           // unfold the nestedList and add its elements into Q
           List<NestedInteger> nestedList = Q.pollFirst().getList();
           for(int i = nestedList.size()-1; i >= 0; i--){
               Q.addFirst(nestedList.get(i));
           }
           return hasNext(); 
        }else {
            return true;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */