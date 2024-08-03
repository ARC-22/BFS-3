/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Time Complexity : O(V+E) 
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node>q = new LinkedList<>();
        map = new HashMap<>();
        Node copyNode = clone(node);
        q.add(node);

        //start bfs
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor)){
                    q.add(neighbor);
                }
                Node clonedNeighbor = clone(neighbor);
                map.get(curr).neighbors.add(clonedNeighbor); 
            }
        }
        return copyNode;
    }
    private Node clone(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }
}