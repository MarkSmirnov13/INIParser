package INIParser;

import java.io.IOException;
import java.util.regex.*;

import Exceptions.InvalidSearchParameters;
import Exceptions.WrongTypeException;
import org.ini4j.Ini;
import Exceptions.FileFormatException;

import java.io.File;

/**
 * @author MaximLukianchuk
 * @author MarkSmirnov
 * @version stable
*/

public class INIParser {
    private static Ini ini;

    public INIParser(String fileName) throws FileFormatException, IOException {
            ini = new Ini(new File("src/main/java/" + fileName));
            if (!(fileName.contains(".ini"))) {
                throw new FileFormatException("Incorrect file format!");
            }
    }

    public Object getValue(String sectionName, String optionName) throws WrongTypeException, InvalidSearchParameters {
        Pattern patternText = Pattern.compile("[0-9.]+");
        try {
            String text = ini.get(sectionName, optionName).split(";")[0];
            Matcher matcher = patternText.matcher(text);

            if (!matcher.matches()) {
                return text;
            }
            else if (text.contains(".")) {
                try {
                    return Double.parseDouble(text);
                } catch (NumberFormatException NFE) {
                    throw new WrongTypeException("Incorrect type format", NFE);
                }
            }
            else {
                try {
                    return Integer.parseInt(text);
                } catch (NumberFormatException NFE) {
                    throw new WrongTypeException("Incorrect type format", NFE);
                }
            }
        } catch (NullPointerException NPE) {
            throw new InvalidSearchParameters("Option or section name is incorrect!", NPE);
        }
    }
}
