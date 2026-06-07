class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remainderIndex= new HashMap<>();
        int sum=0;
        remainderIndex.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder =sum%k;
            if(remainderIndex.containsKey(remainder)){
                if(i-remainderIndex.get(remainder)>1){
                    return true;
                }
            }else{
                remainderIndex.put(remainder,i);
            }
        }
        return false;
    }
}