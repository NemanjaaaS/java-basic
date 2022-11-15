import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi zadatu rec: ");
        String rec = sc.nextLine();
        System.out.println("Unesi string: ");
        String S = sc.nextLine();


        SolutionAll solutionAll = new SolutionAll(S,rec);
        int result = solutionAll.solution(S,rec);

        System.out.println("Resenje za sve "+result);




    }
}