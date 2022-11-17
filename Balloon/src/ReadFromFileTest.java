import Exceptions.NoFileException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {
    String StringPath = "src/files/searchStrings.txt";
    String StringPathWrong = "src/files/unknownFile.txt";

    ReadFromFile rf = new ReadFromFile(StringPath);
    //ArrayList<String> str = rf.ReadFromFile(StringPath);

    @Test
    void readFromFile() throws NoFileException {
        ArrayList<String> testString = new ArrayList<>();
        testString.add("BAONXXOLL");
        testString.add("BAOOLLNNOLOLGBAX");
        testString.add("QAWABAWONL");
        testString.add("ONLABLABLOON");

        assertEquals(testString,rf.ReadFromFile(StringPath));


        System.out.println("Data from file read successfully");
    }

    @Test
    public void whenExceptionThrown(){
        Exception exception = assertThrows(NoFileException.class, ()->{
            Integer.parseInt("la");
        });

        String expectedMessage = "File not found!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}