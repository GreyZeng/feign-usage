package git.snippet.basicusage.controller;

import git.snippet.basicusage.service.HelloFeignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFeignController {
    private final HelloFeignService helloFeignService;

    public HelloFeignController(HelloFeignService helloFeignService) {
        this.helloFeignService = helloFeignService;
    }

    // 服务消费者对位提供的服务
    @GetMapping(value = "/search/github")
    public ResponseEntity<byte[]> searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return helloFeignService.searchRepo(queryStr);
    }
}
