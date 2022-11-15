import Exceptions.NoInputException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;




public class Main {
    public static void main(String[] args) throws NoInputException {

        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\nstefanovic\\IdeaProjects\\Balloon\\src\\files\\searchStrings.txt"))){
            ArrayList<String> S = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Unesi zadatu rec: ");
            String rec = sc.nextLine();
            lines.forEach(i-> S.add(i));
            String filePath ="C:\\Users\\nstefanovic\\IdeaProjects\\Balloon\\src\\files\\results.txt";
            FileWriter fw = new FileWriter(filePath,true);

            for(int i = 0;i<S.size();i++){
                SolutionAll solutionAll = new SolutionAll(S.get(i),rec);
                int result = solutionAll.solution(S.get(i),rec);
                String str = "Rec: "+rec+" se pojavljuje "+result+" u reci:"+S.get(i)+"\n";
                fw.write(str);

                System.out.println("Resenje za sve "+str);
            }
            fw.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Unesi zadatu rec: ");
            String rec = sc.nextLine();
            System.out.println("Unesi string: ");
            String S = sc.nextLine();


            SolutionAll solutionAll = new SolutionAll(S,rec);
            int result = solutionAll.solution(S,rec);
            System.out.println("Resenje za sve "+result);

        }catch (NoInputException ex){
            System.out.println(ex.getMessage());
        }*/


    }
}