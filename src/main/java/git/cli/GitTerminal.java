package git.cli;

import com.amazon.sct.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GitTerminal {


    public static GitTerminal newInstance() {
        return new GitTerminal();
    }

    public Process openProcess(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public TerminalInvokeResult invoke(String command) {
        Process currentProcess = null;
        try {
            currentProcess = openProcess(command);
            return getResult(currentProcess);

        } catch (Exception e) {
            Logger.GENERAL.writeError(e);
            return new TerminalInvokeResult(TerminalInvokeResult.Status.ERROR, e.getMessage());

        } finally {
            closeProcess(currentProcess);
        }
    }


    private TerminalInvokeResult getResult(Process process) throws IOException {
        String successMessage = collectRespond(process.getInputStream());
        String errorMessage = collectRespond(process.getErrorStream());

        if (errorMessage.isEmpty()) {
            return new TerminalInvokeResult(TerminalInvokeResult.Status.SUCCESS, successMessage);
        } else {
            return new TerminalInvokeResult(TerminalInvokeResult.Status.ERROR, errorMessage);
        }
    }


    private String collectRespond(InputStream inputStream) throws IOException {
        StringBuilder respond = new StringBuilder();

        try(BufferedReader br =
            new BufferedReader(new InputStreamReader(inputStream))) {

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
