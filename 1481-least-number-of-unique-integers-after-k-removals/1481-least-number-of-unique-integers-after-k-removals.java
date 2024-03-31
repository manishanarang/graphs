class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        map = map.entrySet()
                  .stream()
                  .sorted((a,b)->a.getValue()-b.getValue())
                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,LinkedHashMap::new)); 
        int n = arr.length;
        
        for(var entry: map.entrySet()){
            
            while(entry.getValue()!=0){
                map.put(entry.getKey(), entry.getValue()-1);
                k--;
                if(k == 0){
                    System.out.println(map);
                    return (int)map.entrySet().stream().filter(e -> e.getValue()>0).count();
                }
            }
        }
        return map.keySet().size();      
    }
    
}