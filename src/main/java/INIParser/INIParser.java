package INIParser;

import java.util.regex.*;
import org.ini4j.Ini;

import java.io.File;

/**
 *
 */
public class INIParser {
    private static Ini ini;

    public INIParser() throws Exception {
        ini = new Ini(new File("src/main/java/exampleFile.ini"));
    }

    // ТЕСТОВЫЙ КОММЕНТ

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
