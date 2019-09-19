package git.cli;

public abstract class GitCommandBuilder {

    protected final String prefix = "git";
    protected final String delimiter = " ";


    public abstract String build();

}
