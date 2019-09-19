package git.cli.command;

import git.cli.GitCommandBuilder;
import git.cli.TransferProtocol;

import java.util.StringJoiner;

public class CloneCommandBuilder extends GitCommandBuilder {

    private TransferProtocol transferProtocol;
    private String url;
    private String outPath;
    private String branch;
    private String username;
    private String password;

    public CloneCommandBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public CloneCommandBuilder withOutPath(String outPath) {
        this.outPath = outPath;
        return this;
    }

    public CloneCommandBuilder withBranch(String outPath) {
        this.branch = branch;
        return this;
    }

    public CloneCommandBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public CloneCommandBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String build() {
        return new StringJoiner(delimiter, prefix, " ")
            .add("")
            .add("clone")
            .add(branch != null ? "-b" : "").add(branch != null ? branch : "")
            .add(addCredential(url))
            .add(outPath)
            .toString();
    }

    private CharSequence addCredential(String url) {
        if (url.startsWith("https://") && username != null && !username.isEmpty()) {
            return "https://" + username + ":" + password + "@" + url.replaceFirst("https://", "");
        }
        return url;
    }
}
