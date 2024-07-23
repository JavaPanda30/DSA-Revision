public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n=1;
        int xor=0;
        for(int i=0;i<A.size();i++){
            xor=xor^(A.get(i));
            xor=xor^(i+1);
        }
        // System.out.println("xor: " +xor);
        //xor has a^b in it 
        int brkp = 0;
        while(true){
            if((xor&1)==0){
                xor>>=1;
                brkp++;
            }
            else{
                break;
            }
        }
        int a=0;
        int b=0;
        for(int i :A){
               if(((i>>brkp)&1)==0){
                   a^=i;
               }
               else if(((i>>brkp)&1)==1){
                   b^=i;
               }
        }
        while(n<=A.size()){
            if(((n>>brkp)&1)==0){
                a^=n;
            }
            else if(((n>>brkp)&1)==1){
                b^=n;
            }
            n+=1;
        }
        // System.out.println("a:"+a);
        // System.out.println("b:"+b);
        ArrayList<Integer> ans = new ArrayList<>();
        if(A.contains(a)){
            ans.add(a);
            ans.add(b);
        }
        else{
            ans.add(b);
            ans.add(a);
        }
        return ans;        
    }
}
