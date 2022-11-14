import java.util.Arrays;
import java.util.HashMap;
public class Solution {

    //String S = "BAXXLXLON";
    String s;

    public Solution(String S) {
        s = S;
    }


    public int solution(String S){
        int result = 0;
        s = s.toUpperCase();
        HashMap<Character,Integer> Smap = new HashMap<Character,Integer>();
        Smap.put('B',0);
        Smap.put('A',0);
        Smap.put('L',0);
        Smap.put('O',0);
        Smap.put('N',0);
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            for(Character j : Smap.keySet()) {
                if (j == chars[i]) {
                    Smap.compute(j, (k, v) -> v + 1);

                }
            }
        }
        Smap.compute('L',(k,v)->v/2);
        Smap.compute('O',(k,v)->v/2);

        int[] tempArr = new int[Smap.size()];
        for(int j = 0;j<Smap.size();j++){
            for(Character i : Smap.keySet()){
                tempArr[j] = Smap.get(i);
            }
        }
        Arrays.sort(tempArr);
        result = tempArr[0];
        return result;
    }


}
