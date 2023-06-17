package policies;

import algo.DLList;
import algo.DLNode;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    private final DLList<Key> dlList;
    private final HashMap<Key, DLNode<Key>> mapper;

    public LRUEvictionPolicy(){
        dlList = new DLList<>();
        mapper = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key element) {
        if(mapper.containsKey(element)){
            dlList.detatchNode(mapper.get(element));
            dlList.addNodeAtLast(mapper.get(element));
        }else{
            DLNode<Key> node = dlList.addElementAtLast(element);
            mapper.put(element,node);
        }
    }

    @Override
    public Key evictKey() {
        DLNode<Key> node = dlList.getFirstNode();
        if(node == null) return null;
        dlList.detatchNode(node);
        return node.getValue();
    }
}
