class Solution {
    public int numSteps(String s) {
        int op=0;
        int carry=0;
        for(int i=s.length()-1;i>0;i--){
            if(((s.charAt(i)-'0')+carry)%2==1){
                op+=2;
                carry=1;
            }
            else{
                op++;
            }
        }
        return carry+op;
    }
}
