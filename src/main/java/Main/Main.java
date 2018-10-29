package Main;

import INIParser.INIParser;

public class Main {
    public static void main(String[] args) throws Exception {
        INIParser testimgovno = new INIParser();
        System.out.println(testimgovno.getValue("ADC_DEV", "BufferLenSeconds"));
    }
}
