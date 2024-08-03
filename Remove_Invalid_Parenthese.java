// Time Complexity : O(n * 2(n-1)) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> removeInvalidParentheses(String s) {
       Queue<String> q = new LinkedList<>();
       HashSet<String> set = new HashSet<>(); 
       List<String> res = new ArrayList<>();
       q.add(s);
       set.add(s);
       boolean flag = false;

       //start bfs
       while(!q.isEmpty() && !flag){
          int size = q.size();
           for(int i=0; i< size; i++){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                res.add(curr);
            }
            else if(flag == false){
                for(int j = 0; j<curr.length(); j++){
                    char c = s.charAt(j);
                    if(c > 'a' && c < 'z'){
                        continue;
                    }
                    String child = curr.substring(0,j) + curr.substring(j+1); // skip each character
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                }
            }
           }
       }
       return res;
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if (c == ')'){
                count --;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }

}