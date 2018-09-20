class Solution {
    public String countAndSay(int n) {
        return count_say("1",1,n);
    }
    public String count_say(String s, int count, int n){
        String str = "";
        int sum = 1;
        char [] ch = s.toCharArray();
        if(count == n) return s;
        for(int i = 0; i < ch.length; i++){
            if(i < ch.length - 1 && ch[i] == ch[i + 1]) sum++;
            else{
                str = str + sum;
                str = str + ch[i];
                sum = 1;
            }
        }
        return count_say(str, count + 1, n);
    }
}
