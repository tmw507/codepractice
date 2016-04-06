class ListNode {
    public int value;
    public int key;
    public ListNode next;
    public ListNode prev;
    public ListNode(int key, int val){
        this.key = key;
        this.value = val;
        prev = next = null;
    }
}

public class LRUCache {
    
    private HashMap<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;
    private int capacity;
    
    public LRUCache(){
        cache = new HashMap<Integer, ListNode>();
        head = tail = null;
        capacity = 0;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, ListNode>();
        head = tail = null;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }else
            return -1;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{//add to cache
            ListNode node = new ListNode(key,value);
            cache.put(key,node);
            
            if(cache.size() > capacity){
                if(capacity == 0) return;
                //invalidate the least recently used node
                cache.remove(tail.key);
                tail = tail.prev;
                if(tail != null)
                   tail.next = null;
                else
                    head = tail = null;
            }
            putToHead(node);
        }
    }
    private void moveToHead(ListNode node){
            if(node == head) return;
            
            if(node == tail){
                tail = node.prev;
                tail.next = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
           
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        
    }
    private void putToHead(ListNode node){
        if(head == null ){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
    }
}