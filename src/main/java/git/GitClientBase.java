package git;

public abstract class GitClientBase implements GitClient {

    private final GitProperties properties;

    public GitClientBase(GitClientBaseBuilder builder) {
        this.properties = builder.properties;
    }

    protected GitProperties getProperties() {
        return properties;
    }

    public abstract static class GitClientBaseBuilder {

        private GitProperties properties;

        public GitClientBaseBuilder withProperties(GitProperties properties) {
            this.properties = properties;
            return this;
        }

        protected GitProperties getProperties() {
            return properties;
        }

        public abstract GitClientBase build();
    }


}
