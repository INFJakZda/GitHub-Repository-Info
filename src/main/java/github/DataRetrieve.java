package github;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class DataRetrieve {

    private String GitUrl = "https://api.github.com/repos/";

    private Model model;

    private RestTemplate restTemplate;

    DataRetrieve(String owner, String repositoryName) {
        this.restTemplate = new RestTemplate();
        this.GitUrl += owner + "/" + repositoryName;
    }

    public boolean validate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        try {
            restTemplate.exchange(GitUrl, HttpMethod.GET, entity, String.class);
        } catch (HttpClientErrorException ex) {
            return false;
        }
        return true;
    }

    public Model getModel() {
        return model;
    }
}
