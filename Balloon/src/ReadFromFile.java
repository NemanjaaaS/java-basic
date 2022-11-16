import Exceptions.NoFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ReadFromFile {

    public String path;

    public ReadFromFile(String Path) {
        path = Path;
    }
    public ArrayList<String> ReadFromFile(String Path) throws NoFileException {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            ArrayList<String> S = new ArrayList<>();
            lines.forEach(i -> S.add(i));

            return S;

        } catch (IOException e) {
            throw new NoFileException("File not found!");
        }
    }
}
