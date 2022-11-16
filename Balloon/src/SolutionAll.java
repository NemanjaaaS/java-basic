import Exceptions.IndexOutOfBound;
import Exceptions.NoInputException;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionAll {
    String inputString;
    String wantedWord;
    public SolutionAll(String iString,String word) {
        inputString = iString;
        wantedWord = word;
    }
    public int solution(String S,String Rec){
        inputString = inputString.toUpperCase();
        wantedWord = wantedWord.toUpperCase();
        HashMap<Character,Integer> Smap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> Recmap = new HashMap<Character,Integer>();
        if(inputString.length() == 0 || wantedWord.length() == 0){
            throw new NoInputException("Inputed string or wanted word is empty!");
        }

        for(int i = 0; i< wantedWord.length(); i++){
            char c = wantedWord.charAt(i);
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

        char[] chars = inputString.toCharArray();

        try{
            for(int i=0;i<chars.length;i++){
            for(Character j : Smap.keySet()) {
                if (j == chars[i]) {
                    Smap.compute(j, (k, v) -> v + 1);

                }
            }
        }}catch (IndexOutOfBound e){
            System.out.println("Index out of bound, please check lengths!");
        }

        for(Character j : Smap.keySet()) {

            Smap.compute(j, (k, v) -> v / Recmap.get(j));
        }


        int[] tempArr = new int[Smap.size()];
        for(int j = 0;j<Smap.size();j++){
            for(Character i : Smap.keySet()){
                tempArr[j] = Smap.get(i);
            }
        }
        Arrays.sort(tempArr);

        return tempArr[0];
    }

}