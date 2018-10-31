package Main;

import Exceptions.FileFormatException;
import INIParser.INIParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            INIParser testimgovno = new INIParser("exampleFile.ini");
            System.out.println(testimgovno.getValue("ADC_DEV", "BufferLenSeconds"));
        } catch (IOException | FileFormatException IOE) {
            IOE.printStackTrace();
        }
    }
}
