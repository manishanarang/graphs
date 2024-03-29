class Solution {
    List<Integer> output = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

    for (int i = 0; i < numCourses; i++)
        courseDict.put(i,new ArrayList<>());
        
    for (int[] relation : prerequisites) {
      courseDict.computeIfAbsent(relation[1], k -> new ArrayList<>()).add(relation[0]);
    }
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < numCourses; ++i) {
      if (!dfs(i, courseDict, cycle, visited))
        return new int[]{};
    }

    int result[] = new int[output.size()];
    int k = output.size()-1;
    for(int i : output){
        result[k--]=i;
    }
    return result;

    }

    protected boolean dfs(
      Integer i, HashMap<Integer, List<Integer>> courseDict,
      Set<Integer> cycle, Set<Integer> visited) {

    if (cycle.contains(i))
      return false;

    if(visited.contains(i))
      return true;

    cycle.add(i);

    for (Integer child : courseDict.get(i)) {
      if(!dfs(child, courseDict, cycle, visited)){
        return false;
      }
    }
    cycle.remove(i);
    visited.add(i);
    output.add(i);
    return true;
}
}
