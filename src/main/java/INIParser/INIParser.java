package INIParser;

import java.io.IOException;
import java.util.regex.*;
import org.ini4j.Ini;
import Exceptions.FileFormatException;

import java.io.File;

/**
 * @author MaximLukianchuk
 * @author  MarkSmirnov
 * @version stable
*/

public class INIParser {
    private static Ini ini;

    public INIParser(String fileName) throws FileFormatException, IOException {
            ini = new Ini(new File("src/main/java/" + fileName));
            if (!(fileName.contains(".ini"))) {
                throw new FileFormatException("Incorrect file format");
            }
    }

    public Object getValue(String sectionName, String optionName) {
        Pattern patternText = Pattern.compile("[a-zA-Za]");
        String text = ini.get(sectionName, optionName).split(";")[0];
        Matcher matcher = patternText.matcher(text);
        if (matcher.matches()) {
            return text;
        }
        else if (text.contains(".")) {
            return Double.parseDouble(text);
        }
        else {
            return Integer.parseInt(text);
        }
    }


}
