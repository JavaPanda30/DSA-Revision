class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];
        }});
        Stack<int[]> stk = new Stack<>();
        for(int[] arr:intervals){
            if(stk.isEmpty()){
                stk.push(arr);
            }
            else{
                int chk[] = stk.pop();
                if(chk[1]>=arr[0]){
                    chk[1] = Math.max(chk[1],arr[1]);
                    stk.push(chk);
                }
                else{
                    stk.push(chk);
                    stk.push(arr);
                }
            }
        }
        int[][] ans = new int[stk.size()][2];
        int r=0;
        while(!stk.isEmpty()){
            int [] arr = stk.pop();
            ans[r][0] = arr[0];
            ans[r][1] = arr[1];
            r++;
        }
        return ans;
    }
}

*****************************************************

    class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];
            }
        });
        list.add(0,intervals[0]);
        int idx=1;
        while(idx<intervals.length){
            int[] temp = intervals[idx++];
            int[] temp2= list.get(0);
            if(temp2[1]>=temp[0]){
                temp2[1] = Math.max(temp[1],temp2[1]);
                list.set(0,temp2);
            }
            else{
                list.add(0,temp);
            }
        }
        idx=list.size()-1;
        int ans[][] = new int[list.size()][2];
        for(int[] a:list){
            ans[idx--]=a;
        }
        return ans;
    }
}
