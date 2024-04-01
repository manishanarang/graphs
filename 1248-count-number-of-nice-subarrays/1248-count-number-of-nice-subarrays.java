class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i] = 0;
            }
            else{
                nums[i]=1;
            }
        }
        int sum= 0;
        int res = 0;
        
        prefixSumCount.put(0,1);
        
        for(int i = 0; i<nums.length;i++){
            sum+=nums[i];
            
            if(prefixSumCount.containsKey(sum-k)){
                res+=prefixSumCount.get(sum-k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0)+1);
        }
        
        return res;
    }
}