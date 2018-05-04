package github;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/repositories/{owner}/{repositoryName}")
public class Controller {

    String GitUrl = "https://api.github.com/repos/";

    @RequestMapping(method = RequestMethod.GET)
    public Model getModelInfo(@PathVariable String owner, @PathVariable String repositoryName) {
        this.validate(owner, repositoryName);
        return new DataRetrieve(owner, repositoryName).getModel();
    }

    public void validate(String owner, String repositoryName) {
        System.out.println(owner + " " + repositoryName);
    }
}
