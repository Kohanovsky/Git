package vc.git;

import vc.VcsClient;
import vc.git.cli.GitTerminal;
import vc.git.cli.GitTerminalProvider;

public class GitClient extends VcsClient<GitProperties> {

    private final GitTerminal terminal;


    public GitClient(GitClientBuilder builder) {
        super(builder);
        this.terminal = builder.terminal;
    }


    @Override
    public void cloneFromOrigin() {
        GitProperties properties = getProperties();
        terminal.invoke("clone origin");
    }

    @Override
    public void cloneFromLocal() {
        GitProperties properties = getProperties();
        terminal.invoke("clone local");
    }

    @Override
    public String updateLocal() {
        //Todo implement pull
        GitProperties properties = getProperties();
        return terminal.invoke("git pull");
    }

    @Override
    public String testConnection() {
        return terminal.invoke("git --version");
    }


    public static GitClientBuilder builder() {
        return new GitClientBuilder();
    }

    public static class GitClientBuilder extends VcsClientBuilder<GitProperties> {

        {
            setTerminal(GitTerminalProvider.newInstance().getTerminal());
        }

        private GitTerminal terminal;

        public void setTerminal(GitTerminal terminal) {
            this.terminal = terminal;
        }


        @Override
        public VcsClient build() {
            return new GitClient(this);
        }
    }
}
