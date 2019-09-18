package vc;

import vc.git.GitClient;

/**
 * Describe supported version control system types.
 */
public enum VcsKind {

    GIT() {
        @Override
        public VcsClient.VcsClientBuilder getVcsClientBuilder() {
            return GitClient.builder();
        }
    };


    public abstract VcsClient.VcsClientBuilder getVcsClientBuilder();
}
