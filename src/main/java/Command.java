package main.java;
import java.io.*;
import java.util.*;

public class Command extends Util {
    static ProcessBuilder processBuilder = new ProcessBuilder();

    /**
     * command execution
     * @param os OS data
     * @param command command to execution
     * @return command output result
     */

    public static String getCommandExecution(OS os ,String command){
        ArrayList<String> commands = new ArrayList<String>();
        switch(os) {
            case LINUX:
                commands.addAll(Arrays.asList("bash","-c",command));
                break;
            case WINDOWS:
                commands.addAll(Arrays.asList("cmd.exe","/c",command));
                break;
            default:
                break;
        }


        processBuilder.command(commands);
        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                return output.toString();
            } else {
                // System.out.println(RED+"[+]System can't run: "+command+RESET);
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}