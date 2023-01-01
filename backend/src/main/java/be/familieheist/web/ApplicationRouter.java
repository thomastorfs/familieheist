package be.familieheist.web;

import be.familieheist.web.content.page.GetPageHandler;
import be.familieheist.web.content.page.part.CreatePagepartHandler;
import be.familieheist.web.content.page.part.PagepartCreateCommandDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ApplicationRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(GetPageHandler getPageHandler,
                                                 CreatePagepartHandler createPagepartHandler) {
        return route()
            .GET("/api/pages/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> getPageById(getPageHandler, serverRequest),
                consumer -> consumer.beanClass(GetPageHandler.class).beanMethod("getPageById").build())
            .POST("/api/pageparts",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> createPagepart(createPagepartHandler, serverRequest),
                consumer -> consumer.beanClass(CreatePagepartHandler.class).beanMethod("createPagepart").build())
            .resources("/*.css", new ClassPathResource("/static/"), builder -> builder.operationId("css"))
            .resources("/*.js", new ClassPathResource("/static/"), builder -> builder.operationId("js"))
            .resources("/*.ico", new ClassPathResource("/static/"), builder -> builder.operationId("ico"))
            .resources("/*.html", new ClassPathResource("/static/"), builder -> builder.operationId("html"))
            .build();
    }

    private Mono<ServerResponse> getPageById(GetPageHandler getPageHandler, ServerRequest serverRequest) {
        String pageId = serverRequest.pathVariable("id");

        return getPageHandler.getPageById(pageId)
            .flatMap(pageDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pageDTO));
    }

    private Mono<ServerResponse> createPagepart(CreatePagepartHandler createPagepartHandler, ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PagepartCreateCommandDTO.class)
            .flatMap(createPagepartHandler::createPagepart)
            .flatMap(pagepartDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pagepartDTO));
    }
}
