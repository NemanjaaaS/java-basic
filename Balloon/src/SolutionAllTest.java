import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionAllTest {



    SolutionAll sol = new SolutionAll("BAOOLL NNOLOL GBAX","BA LL OON");




    @Test
    public void fillRecMap() {


        HashMap<Character,Integer> Rmapa = new HashMap<>();
        Rmapa.put('B',1);
        Rmapa.put('A',1);
        Rmapa.put('L',2);
        Rmapa.put('O',2);
        Rmapa.put('N',1);
        assertEquals(Rmapa,sol.fillRecMap(),"RecMap should contain{'B'=1,'A'=1,'L'=2,'O'=2,'N'=1}");
        //System.out.println("HashMap RecMap created successfully");

    }

    @Test
    public void fillStringMap() {

        HashMap<Character,Integer> Smapa = new HashMap<>();
        Smapa.put('B',0);
        Smapa.put('A',0);
        Smapa.put('L',0);
        Smapa.put('O',0);
        Smapa.put('N',0);
        sol.fillRecMap();
        assertEquals(Smapa,sol.fillStringMap(),"Smap should contain{'B'=0,'A'=0,'L'=0,'O'=0,'N'=0}");
        System.out.println("HashMap with keys same as in Rec with values 0 created successfully");
    }

    @Test
    public void increaseValue() {

        HashMap<Character,Integer> Smapa = new HashMap<>();
        Smapa.put('B',2);
        Smapa.put('A',2);
        Smapa.put('L',4);
        Smapa.put('O',4);
        Smapa.put('N',2);
        sol.fillRecMap();
        sol.fillStringMap();
        assertEquals(Smapa,sol.increaseValue(),"Smap values should count of characters BALON in BAOOLLNNOLOLGBAX (2,2,4,4,2)");
        System.out.println("Values increased successfully");

    }

    @Test
    public void scale() {
        //SolutionAll sol = new SolutionAll("BAOOLLNNOLOLGBAX","BALLOON");

        HashMap<Character,Integer> Testmapa = new HashMap<>();
        Testmapa.put('B',2/1);
        Testmapa.put('A',2/1);
        Testmapa.put('L',4/2);
        Testmapa.put('O',4/2);
        Testmapa.put('N',2/1);
        sol.fillRecMap();
        sol.fillStringMap();
        sol.increaseValue();


        assertEquals(Testmapa,sol.scale(),"Smap value should be ");
        System.out.println("Values from Smap devided by values from Recmap successfully");
    }

    @Test
    public void solution() {
       // SolutionAll sol = new SolutionAll("BAOOLLNNOLOLGBAX","BALLOON");
        assertEquals(2,sol.solution("BAOOLLNNOLOLGBAX","BALLOON"));
        System.out.println("Maximal number of combination return successfully");
    }
}