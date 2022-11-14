import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi zadatu rec: ");
        String rec = sc.nextLine();
        System.out.println("Unesi string: ");
        String S = sc.nextLine();

        //4
        //LOXXTXXTOLXTOTTOxabOLeadcaOTTOLOTTO
        //2
        //LOTTTOdLdsO3TdasTsdaO

        Solution solution = new Solution(S);
        //int result = solution.solution(S);

        SolutionAll solutionAll = new SolutionAll(S,rec);
        int result2 = solutionAll.solution(S,rec);

        //System.out.println("Resenje samo za BALLOON "+result);
        System.out.println("Resenje za sve "+result2);




    }
}