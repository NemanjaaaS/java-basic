import java.util.Arrays;
import java.util.HashMap;


public class SolutionAll {

    //String S = "BAXXLXLON";
    String s;
    String rec;

    public SolutionAll(String S,String Rec) {
        s = S;
        rec = Rec;
    }


    public int solution(String S,String Rec){
        int result = 0;
        s = s.toUpperCase();
        HashMap<Character,Integer> Smap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> Recmap = new HashMap<Character,Integer>();
        //Smap.put('B',0);
      //  Smap.put('A',0);
      //  Smap.put('L',0);
      //  Smap.put('O',0);
      //  Smap.put('N',0);

        for(int i = 0;i<rec.length();i++){
            char c = rec.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Recmap.containsKey(c)){
                Recmap.put(c,Recmap.get(c)+1);
            }else{
                Recmap.put(c,1);
            }
        }

        for(Character i : Recmap.keySet()){
            Smap.put(i,0);
        }


        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            for(Character j : Smap.keySet()) {
                if (j == chars[i]) {
                    Smap.compute(j, (k, v) -> v + 1);

                }
            }
        }
        HashMap<Character,Integer> Tempmap = new HashMap<Character,Integer>();
        for(Character i : Recmap.keySet()){
            for(Character j : Smap.keySet()){
                Tempmap.put(i,Smap.get(j)/Recmap.get(i));
            }
        }
        int[] tempArr = new int[Tempmap.size()];
        for(int j = 0;j<Tempmap.size();j++){
            for(Character i : Tempmap.keySet()){
                tempArr[j] = Tempmap.get(i);
            }
        }

        Arrays.sort(tempArr);


        result = tempArr[0];

        return result;
    }

}
