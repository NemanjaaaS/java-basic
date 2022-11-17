import Exceptions.IndexOutOfBound;
import Exceptions.NoInputException;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionAll {
    String inputString;
    String wantedWord;

    HashMap<Character,Integer> Smap = new HashMap<Character,Integer>();
    HashMap<Character,Integer> Recmap = new HashMap<Character,Integer>();
    public SolutionAll(String iString,String word) {
        inputString = iString;
        wantedWord = word;
    }
    //stavljamo input rec u HashMap RecMap
    public HashMap fillRecMap(){
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
        return Recmap;

    }
    //stavljamo karaktere iz RecMap kao kljuvece u Smap i stavljamo vrednost na 0
    public HashMap fillStringMap(){
        for(Character i : Recmap.keySet()){
            Smap.put(i,0);
        }
        return Smap;
    }

    //povecavamo vrednosti Smap da vidimo koliko se puta ponavlja karakter u zadatoj reci
    public HashMap increaseValue(){
        char[] chars = inputString.toCharArray();

        try{
            for(int i=0;i<chars.length;i++){
                for(Character j : Smap.keySet()) {
                    if (j == chars[i]) {
                        Smap.compute(j, (k, v) -> v + 1);

                    }
                }
            }

        }catch (IndexOutOfBound e){
            System.out.println("Index out of bound, please check lengths!");
        }
        return Smap;
    }
    //delimo vrednost Smap sa vrednosti Recmap pod istim kljucem
    public HashMap scale(){
        for(Character j : Smap.keySet()) {

            Smap.compute(j, (k, v) -> v / Recmap.get(j));
        }
        return Smap;
    }
    public int solution(String S,String Rec){
        inputString = inputString.toUpperCase();
        wantedWord = wantedWord.toUpperCase();

        if(inputString.length() == 0 || wantedWord.length() == 0){
            throw new NoInputException("Inputed string or wanted word is empty!");
        }

        fillRecMap();

        fillStringMap();

        increaseValue();

        scale();

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