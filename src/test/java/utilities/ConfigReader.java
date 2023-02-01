package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static FileInputStream input;
    private static Properties properties;

    static {
        String path= System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";
        try {
            input = new FileInputStream(path);  // so the class can read it
            properties = new Properties();     //loading file
            properties.load(input);
        }catch(FileNotFoundException e){
            System.out.println("Path for properties file is invalid");
        }catch(IOException e){
            System.out.println("Failed to load the properties file");
        }finally{   //closing connection in this block
            try {
                assert input != null; // make sure there is an input before closing. Null check
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occurred while closing input object");
            }
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
