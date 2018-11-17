package Main;

import Exceptions.FileFormatException;
import Exceptions.InvalidSearchParameters;
import Exceptions.WrongTypeException;
import INIParser.INIParser;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            INIParser testimgovno = new INIParser("exampleFile.ini");
            System.out.println(testimgovno.getValue("COMMON", "DiskCachePath"));
        } catch (IOException | FileFormatException | InvalidSearchParameters | WrongTypeException E) {
            E.printStackTrace();
        }
    }
}
