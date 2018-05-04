package github;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {

    public NotFoundException(String owner, String repositoryName) {
        super("could not find user '" + owner + "', or repo '" + repositoryName + "'.");
    }
}