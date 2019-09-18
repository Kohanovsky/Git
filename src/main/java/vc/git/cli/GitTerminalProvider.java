package vc.git.cli;

public class GitTerminalProvider {


    public static GitTerminalProvider newInstance() {
        return new GitTerminalProvider();
    }


    public GitTerminal getTerminal() {
        return new GitTerminal();
    }


}
