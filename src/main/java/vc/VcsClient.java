package vc;

public abstract class VcsClient<T extends VcsProperties> {

    private T properties;

    public VcsClient(VcsClientBuilder builder) {
        this.properties = (T) builder.properties;
    }

    public abstract void cloneFromOrigin();

    public abstract void cloneFromLocal();

    public abstract String updateLocal();

    public abstract String testConnection();

    public T getProperties() {
        return properties;
    }

    public abstract static class VcsClientBuilder<T extends VcsProperties> {

        private T properties;

        public VcsClientBuilder withProperties(T properties) {
            this.properties = properties;
            return this;
        }

        protected T getProperties() {
            return properties;
        }

        public abstract VcsClient build();
    }
}
