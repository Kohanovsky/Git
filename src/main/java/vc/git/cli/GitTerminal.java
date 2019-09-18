package vc.git.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitTerminal {


    public Process openProcess(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public String invoke(String command) {
        Process currentProcess = null;
        try {
            currentProcess = openProcess(command);
            return collectRespond(currentProcess);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            closeProcess(currentProcess);
        }
    }


    private String collectRespond(Process process) throws IOException {
        StringBuilder respond = new StringBuilder();

        try(BufferedReader br =
            new BufferedReader(new InputStreamReader(process.getInputStream()))) {

            String line;
            while ((line = br.readLine()) != null) {
                respond.append(line)
                    .append(System.lineSeparator());
            }
        }

        return respond.toString();
    }


    private void closeProcess(Process process) {
        try {
            if (process == null) {
                return;
            }
            process.destroy();
        } catch (Exception e) {
            process.destroyForcibly();
        }
    }



}
