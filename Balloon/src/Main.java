import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        String StringPath = "src/files/searchStrings.txt";

        ReadFromFile rf = new ReadFromFile(StringPath);
        ArrayList<String> S = rf.ReadFromFile(StringPath);

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi zadatu rec: ");
        String rec = sc.nextLine();
        String filePath ="src/files/results.txt";
        FileWriter fw = new FileWriter(filePath,true);

        for(int i = 0;i<S.size();i++){
            SolutionAll solutionAll = new SolutionAll(S.get(i),rec);
            int result = solutionAll.solution(S.get(i),rec);
            String str = "Rec: "+rec+" se pojavljuje "+result+" u reci:"+S.get(i)+"\n";
            fw.write(str);

            System.out.println("Resenje za sve "+str);
        }
        fw.close();

    }

}
