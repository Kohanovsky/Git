package git;

import git.cli.TerminalInvokeResult;

public interface GitClient {

    void cloneRepo();

    TerminalInvokeResult pull();

    TerminalInvokeResult testConnection();

    void close();

}
