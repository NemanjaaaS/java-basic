package Exceptions;


import java.io.IOException;

public class NoFileException extends IOException {
    public NoFileException(String message){
        super(message);
    }
}
