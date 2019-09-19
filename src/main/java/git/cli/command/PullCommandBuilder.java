package git.cli.command;

import com.amazon.sct.appconversion.vc.git.GitProperties;
import com.amazon.sct.appconversion.vc.git.cli.GitCommandBuilder;

/**
 * Command for pull project with use terminal.
 */
public class PullCommandBuilder extends GitCommandBuilder {

    /**
     * Pulling project with credentials.
     *
     * @param properties data
     * @return url with credentials
     */
    public String withURL(GitProperties properties) {
        String url = properties.getUrl();
        String userName = properties.getUserName();
        String password = properties.getPassword();

        int index = url.indexOf("//") + 2;
        return url.substring(0, index) + userName + ":" + password + "@" + url.substring(index);
    }


    @Override
    public String build() {
        return "git pull";
    }
}
