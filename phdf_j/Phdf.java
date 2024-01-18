package phdf_j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileSystemView;

public class Phdf {

    private String myDocPath;
    private String pythonPath;
    private String cliPath;
    private String targetDir;
    private String dataString;
    private List<String> command;

    /**
     * HDF object manager to handle get_json, find_python, run_python
     * <p>
     * Obective is to pass JSON to python to create HDF file container
     */
    public Phdf() {
        this.myDocPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        this.pythonPath = myDocPath + "/anaconda3/bin/python";
        this.cliPath = myDocPath + "/gitRepos/phdf/cli.py";
        System.out.println("PhdfProcess initialized");
    }

    public void initCommand() {
        this.command = new ArrayList<>();
        appendCommand(this.pythonPath);
        appendCommand(this.cliPath);
        appendCommand("--measure_timing");
        appendCommand("--skip_cleanup");
        System.out.println("command iniialized: " + this.command);
    }

    public String getCommand() {
        return this.command.toString();
    }

    public void appendCommand(String cmdSnippet) {
        this.command.add(cmdSnippet);
    }

    public void appendUserInputToCommand(String inputString, String inputDir) {
        this.targetDir = inputDir;
        this.dataString = inputString;
        appendCommand(this.dataString);
        appendCommand(this.targetDir);
    }

    public String getMyDocPath() {
        return this.myDocPath;
    }

    public void setMyDocPath(String myDocPath) {
        this.myDocPath = myDocPath;
    }

    public String getPythonPath() {
        return this.pythonPath;
    }

    public void setPythonPath(String inputPythonPath) {
        this.pythonPath = inputPythonPath;
    }

    public String getCliPath() {
        return this.cliPath;
    }

    public void setCliPath(String cliPath) {
        this.cliPath = cliPath;
    }

    public String getTargetDir() {
        return this.targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public String getDataString() {
        return this.dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * Sends a commond to OS using ProcessBuilder, to run python cli app
     * on the JSON
     * 
     * @param dataString The JSON content in
     * @param targetDir  Parent directory of where the output file should be
     * @return int
     */

    public int run(String dataString, String targetDir) {
        initCommand();
        appendUserInputToCommand(dataString, targetDir);
        int n = this.dataString.length();
        if (n > 1000) {
            System.out.println(
                    " >> calling subprocess phdf (data.length=" + n + ") " + this.targetDir);
        } else {
            System.out.println(
                    " >> calling subprocess phdf " + this.dataString + " " + this.targetDir);
        }

        ProcessBuilder builder = new ProcessBuilder(this.command);
        Process process;
        try {
            process = builder.inheritIO().start();
            process.waitFor();
            System.out.println(" >> phdf completed with exitCode=" + process.exitValue());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 1;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
            return 2;
        }
        return 0;
    }

}