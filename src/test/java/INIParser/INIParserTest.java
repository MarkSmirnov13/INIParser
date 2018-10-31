package INIParser;

import Exceptions.FileFormatException;
import Exceptions.InvalidSearchParameters;
import Exceptions.WrongTypeException;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class INIParserTest {

    @Test
    public void getValue1() {
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

    @Test
    public void getValue2() throws InvalidSearchParameters, WrongTypeException, IOException, FileFormatException {
        INIParser initest = new INIParser("exampleFile.ini");
        Object actual = initest.getValue("COMMON", "DiskCachePath");

        Object expexted = INIParser.getValue("COMMON", "DiskCachePath");
        Assert.assertEquals(expexted, actual);
    }

    @Test(expected = FileNotFoundException.class)
    public void INIParser() throws IOException, FileFormatException {
        INIParser initest = new INIParser("exampleFile.txt");
    }

    @Test(expected = InvalidSearchParameters.class)
    public void getValue_error_ISP() throws IOException, FileFormatException, InvalidSearchParameters, WrongTypeException {
        INIParser iniParser = new INIParser("exampleFile.ini");
        Object test = iniParser.getValue("COMMON", "QWERTY");
    }

    @Test(expected = NumberFormatException.class)
    public void getValue_error_WTE_INTEGER() {
        Pattern patternText = Pattern.compile("[0-9.]+");
        String text = "50000000000000000000000000000";
        Matcher matcher = patternText.matcher(text);

        if (!matcher.matches()) {
             String ans = text;
        }
        else if (text.contains(".")) {
            Double.parseDouble(text);
        }
        else {
            Integer.parseInt(text);
        }
    }

    @Test(expected = NumberFormatException.class)
    public void getValue_error_WTE_DOUBLE() {
        Pattern patternText = Pattern.compile("[0-9.]+");
        String text = "5000..";
        Matcher matcher = patternText.matcher(text);

        if (!matcher.matches()) {
            String ans = text;
        }
        else if (text.contains(".")) {
            Double.parseDouble(text);
        }
        else {
            Integer ans = Integer.parseInt(text);
        }
    }
}