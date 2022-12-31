package be.familieheist.web;

import be.familieheist.web.content.page.GetPageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ApplicationRouter {
    @Bean
    public RouterFunction<ServerResponse> applicationRoutes(GetPageHandler getPageHandler) {
        return RouterFunctions.route()
            .GET("/familieheist/api/pages/{id}", accept(MediaType.APPLICATION_JSON), serverRequest -> getPageById(getPageHandler, serverRequest))
            .resources("/familieheist/*.css", new ClassPathResource("/static/"))
            .resources("/familieheist/*.js", new ClassPathResource("/static/"))
            .resources("/familieheist/*.ico", new ClassPathResource("/static/"))
            .resources("/familieheist/*.html", new ClassPathResource("/static/"))
            .build();
    }

    private Mono<ServerResponse> getPageById(GetPageHandler getPageHandler, ServerRequest serverRequest) {
        String pageId = serverRequest.pathVariable("id");

        return getPageHandler.getPageById(pageId)
            .flatMap(pageDTO -> ServerResponse.ok().bodyValue(pageDTO));
    }
}
