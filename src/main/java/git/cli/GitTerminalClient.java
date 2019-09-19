package git.cli;

import git.GitClientBase;
import git.cli.command.CloneCommandBuilder;
import git.cli.command.PullCommandBuilder;

public class GitTerminalClient extends GitClientBase {

    public static void main(String[] args) {
        new GitTerminalClient(new GitClientBuilder()).pull();
    }

    private final GitTerminal terminal;


    public GitTerminalClient(GitClientBuilder builder) {
        super(builder);
        this.terminal = builder.terminal;
    }


    @Override
    public void cloneRepo() {

        GitCommandBuilder builder =
            new CloneCommandBuilder()
                .withUrl(getProperties().getUrl())
                .withOutPath(getProperties().getOutDirectory())
                .withBranch(getProperties().getBranch())
            ;


        terminal.invoke(builder.build());
    }

    @Override
    public TerminalInvokeResult pull() {
        GitCommandBuilder builder = new PullCommandBuilder();
        return terminal.invoke(builder.build());
    }

    @Override
    public void close() {

    }

    @Override
    public TerminalInvokeResult testConnection() {
        return terminal.invoke("git --version");
    }


    public static GitClientBuilder builder() {
        return new GitClientBuilder();
    }

    public static class GitClientBuilder extends GitClientBaseBuilder {

        {
            setTerminal(GitTerminal.newInstance());
        }

        private GitTerminal terminal;

        private void setTerminal(GitTerminal terminal) {
            this.terminal = terminal;
        }


        @Override
        public GitTerminalClient build() {
            return new GitTerminalClient(this);
        }
    }
}
