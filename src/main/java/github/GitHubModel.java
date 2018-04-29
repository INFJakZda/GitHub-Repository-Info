package github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubModel {

    private int id;

    public GitHubModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
