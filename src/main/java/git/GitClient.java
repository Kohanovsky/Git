package git;

import com.amazon.sct.appconversion.vc.git.cli.TerminalInvokeResult;

public interface GitClient {

    void cloneRepo();

    TerminalInvokeResult pull();

    TerminalInvokeResult testConnection();

    void close();

}
