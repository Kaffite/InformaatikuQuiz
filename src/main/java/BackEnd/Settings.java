package BackEnd;

import java.io.*;
import java.util.ArrayList;

public class Settings {
    private ArrayList settingMessages;

    public Settings(String path) throws IOException {
        settingMessages = readSettingMsgs(path);
    }

    private static ArrayList<String> readSettingMsgs(String path) throws IOException {
        InputStream inputStream = Settings.class.getResourceAsStream(path);
        ArrayList<String> messages = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null){
                messages.add(line);
            }
        }
        return messages;
    }

    public ArrayList getSettingMessages() {
        return settingMessages;
    }
}
