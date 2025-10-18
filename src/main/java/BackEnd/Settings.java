package BackEnd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Settings {
    private ArrayList settingMessages;

    public Settings(String path) throws IOException {
        settingMessages = readSettingMsgs(path);
    }

    private static ArrayList<String> readSettingMsgs(String path) throws IOException {
        ArrayList<String> messages = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
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
