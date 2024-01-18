package phdf_j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JFileReader {

    public String filepath;

    /**
     * This is class Reader object to parse JSON files
     * The parsed string will be passed to python wrapper
     * to make HDF data container
     * 
     * @param input_filepath Absolute filepath of the JSON file
     * @return null
     */
    public JFileReader(String input_filepath) {
        this.filepath = input_filepath;
        System.out.println("intiailised filepath = " + filepath);
    }

    /**
     * Basic function to read content of the JSON file
     * 
     * @return String
     */
    public String read() {
        String everything = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(this.filepath));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                everything = sb.toString();
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return everything;
    }

}
