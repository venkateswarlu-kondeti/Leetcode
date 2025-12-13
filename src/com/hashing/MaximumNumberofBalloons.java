package com.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//1189. Maximum Number of Balloons
public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text){
        Map<Character,Integer> counts=new HashMap<>();
        Set<Character> charSet=new HashSet<>();
        int ans=0;
        for(char c : text.toCharArray()){
            if(c=='b'||c=='a'||c=='l'||c=='o'||c=='n'){
                counts.put(c,counts.getOrDefault(c,0)+1);
            }
        }
        System.out.println(counts);
        int ans1Char=counts.getOrDefault('b',0)+counts.getOrDefault('a',0)
                +counts.getOrDefault('l',0)+counts.getOrDefault('o',0)
                +counts.getOrDefault('n',0);
        int ans2Char=ans1Char;
        if(counts.size()==5 && counts.get('l')>=2 && counts.get('o')>=2){
            for(Map.Entry<Character,Integer> entry : counts.entrySet()){
                if(entry.getKey()=='l'||entry.getKey()=='o'){
                    ans1Char=Math.min(ans1Char, entry.getValue()/2);
                }else if(entry.getKey()=='b'||entry.getKey()=='a'||entry.getKey()=='n'){
                    ans2Char=Math.min(ans2Char, entry.getValue());
                }
                ans=Math.min(ans1Char,ans2Char);
            }
        }else{
            ans=0;
        }
        return ans;
    }
    public static void main(String[] args){
        MaximumNumberofBalloons b=new MaximumNumberofBalloons();
        //String t="nlaebolko";
        //String t="loonbalxballpoon";
        //String t="leetcode";
        //String t="balllllllllllloooooooooon";
        //String t="balon";
        String t="krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println("The Maximum number of balloons are: "+b.maxNumberOfBalloons(t));
    }
}
