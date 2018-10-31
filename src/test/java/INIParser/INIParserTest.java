package INIParser;

import Exceptions.FileFormatException;
import Exceptions.InvalidSearchParameters;
import Exceptions.WrongTypeException;
import org.ini4j.Ini;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class INIParserTest {

    @Test
    public void getValue() {
        try {
            INIParser testIni = new INIParser("exampleFile.ini");
            System.out.println(testIni.getValue("COMMON", "DiskCachePath"));
            System.out.println(testIni.getValue("COMMON", "StatisterTimeMs"));
            System.out.println(testIni.getValue("COMMON", "LogNCMD"));
            System.out.println(testIni.getValue("COMMON", "LogXML"));
            System.out.println(testIni.getValue("COMMON", "DiskCachePath"));
            System.out.println(testIni.getValue("COMMON", "OpenMPThreadsCount"));
            System.out.println(testIni.getValue("ADC_DEV", "BufferLenSeconds"));
            System.out.println(testIni.getValue("ADC_DEV", "SampleRate"));
            System.out.println(testIni.getValue("ADC_DEV", "Driver"));
            System.out.println(testIni.getValue("NCMD", "EnableChannelControl"));
            System.out.println(testIni.getValue("NCMD", "SampleRate"));
            System.out.println(testIni.getValue("NCMD", "TidPacketVersionForTidControlCommand"));
            System.out.println(testIni.getValue("LEGACY_XML", "ListenTcpPort"));
            System.out.println(testIni.getValue("DEBUG", "PlentySockMaxQSize"));
        } catch (IOException | FileFormatException | InvalidSearchParameters | WrongTypeException E) {
            E.printStackTrace();
        }
    }
}