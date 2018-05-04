package github;

import org.springframework.web.client.RestTemplate;

public class DataRetrieve {

    private Model model;

    private RestTemplate restTemplate;

    private String GitUrl = "https://api.github.com/repos/";

    DataRetrieve(String owner, String repositoryName) {
        this.restTemplate = new RestTemplate();
        this.model = restTemplate.getForObject( GitUrl + owner + "/" + repositoryName, Model.class);
    }

    public Model getModel() {
        return model;
    }
}
