/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        SortedMap<Integer, List<ListNode>> nodes = new TreeMap<Integer, List<ListNode>>();
        for(ListNode node : lists) {
            while(node != null) {
                if(nodes.containsKey(node.val)) {
                    List<ListNode> list = nodes.get(node.val);
                    list.add(node);
                } else {
                    List<ListNode> list = new LinkedList<ListNode>();
                    list.add(node);
                    nodes.put(node.val, list);
                }
                node = node.next;
            }
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        for(List<ListNode> list : nodes.values()) {
            for(ListNode nd : list) {
                node.next = nd;
                node = nd;
            }
        }
        node.next = null;
        return dummyHead.next;
    }
}
