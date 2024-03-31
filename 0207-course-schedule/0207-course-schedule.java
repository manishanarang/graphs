class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    // course -> list of next courses
    HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

    // build the graph first
    for (int[] relation : prerequisites) {
      // relation[0] depends on relation[1]
      courseDict.computeIfAbsent(relation[1], k -> new ArrayList<>()).add(relation[0]);
    }

    Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < numCourses; ++i) {
      if (isCyclic(i, courseDict, visited))
        return false;
    }

    return true;
  }


  /*
   * postorder DFS check that no cycle would be formed starting from curr Course i
   */
  protected boolean isCyclic(
      Integer i, HashMap<Integer, List<Integer>> courseDict,
      Set<Integer> visited) {

    if (visited.contains(i))
      // come across a previously visited node, i.e. detect the cycle
      return true;

    // no following courses, no loop.
    if (courseDict.get(i) == null || courseDict.get(i).isEmpty())
      return false;

    // before backtracking, mark the node in the path
    visited.add(i);

    for (Integer child : courseDict.get(i)) {
      boolean hasCycle =  isCyclic(child, courseDict, visited);
      if(hasCycle){
        return true;
      }
    
    }
    visited.remove(i);
    //mark the course neigbours as empty for next iteration meaning that it's safe
    courseDict.put(i, new ArrayList<>());
    return false;
}
}