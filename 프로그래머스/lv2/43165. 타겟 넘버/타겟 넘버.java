class Solution {
    
    int cnt = 0;
    public void DFS(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) cnt++;
        } else {
            DFS(numbers, target, idx+1, sum + numbers[idx]);
            DFS(numbers, target,idx+1, sum - numbers[idx]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return cnt;
    }
}