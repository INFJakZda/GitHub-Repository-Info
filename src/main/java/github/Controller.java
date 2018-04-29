package github;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @RequestMapping("/repositories/{owner}/{repositoryName}")
    public Model getModelInfo(@PathVariable String owner, @PathVariable String repositoryName) {
        RestTemplate restTemplate = new RestTemplate();
        Model model = restTemplate.getForObject("https://api.github.com/repos/" + owner + "/" + repositoryName, Model.class);
        return model;
    }
}
