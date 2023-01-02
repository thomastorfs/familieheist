package be.familieheist.web;

import be.familieheist.web.content.page.*;
import be.familieheist.web.content.page.part.CreatePagepartHandler;
import be.familieheist.web.content.page.part.PagepartCreateCommandDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
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
    public RouterFunction<ServerResponse> routes(CreatePageHandler createPageHandler,
                                                 GetPageHandler getPageHandler,
                                                 UpdatePageHandler updatePageHandler,
                                                 DeletePageHandler deletePageHandler,
                                                 CreatePagepartHandler createPagepartHandler) {
        return route()
            .POST("/api/page",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> createPage(createPageHandler, serverRequest),
                consumer -> consumer.beanClass(CreatePageHandler.class).beanMethod("createPage").build())
            .GET("/api/page/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> getPageById(getPageHandler, serverRequest),
                consumer -> consumer.beanClass(GetPageHandler.class).beanMethod("getPageById").build())
            .PUT("/api/page/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> updatePageById(updatePageHandler, serverRequest),
                consumer -> consumer.beanClass(UpdatePageHandler.class).beanMethod("updatePageById").build())
            .DELETE("/api/page/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> deletePageById(deletePageHandler, serverRequest),
                consumer -> consumer.beanClass(DeletePageHandler.class).beanMethod("deletePageById").build())
            .POST("/api/pagepart",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> createPagepart(createPagepartHandler, serverRequest),
                consumer -> consumer.beanClass(CreatePagepartHandler.class).beanMethod("createPagepart").build())
            .resources("/*.css", new ClassPathResource("/static/"), builder -> builder.operationId("css"))
            .resources("/*.js", new ClassPathResource("/static/"), builder -> builder.operationId("js"))
            .resources("/*.ico", new ClassPathResource("/static/"), builder -> builder.operationId("ico"))
            .resources("/*.html", new ClassPathResource("/static/"), builder -> builder.operationId("html"))
            .build();
    }

    private Mono<ServerResponse> createPage(CreatePageHandler createPageHandler, ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PageCreateCommandDTO.class)
            .flatMap(createPageHandler::createPage)
            .flatMap(pageDTO -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(pageDTO));
    }

    private Mono<ServerResponse> getPageById(GetPageHandler getPageHandler, ServerRequest serverRequest) {
        String pageId = serverRequest.pathVariable("id");
        return getPageHandler.getPageById(pageId)
            .flatMap(pageDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pageDTO));
    }

    private Mono<ServerResponse> updatePageById(UpdatePageHandler updatePageHandler, ServerRequest serverRequest) {
        String pageId = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(PageUpdateCommandDTO.class)
            .flatMap(pageUpdateCommand -> updatePageHandler.updatePageById(pageId, pageUpdateCommand))
            .flatMap(pageDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pageDTO));
    }

    private Mono<ServerResponse> deletePageById(DeletePageHandler deletePageHandler, ServerRequest serverRequest) {
        String pageId = serverRequest.pathVariable("id");
        return deletePageHandler.deletePageById(pageId)
            .flatMap(pageDTO -> ServerResponse.noContent().build());
    }

    private Mono<ServerResponse> createPagepart(CreatePagepartHandler createPagepartHandler, ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PagepartCreateCommandDTO.class)
            .flatMap(createPagepartHandler::createPagepart)
            .flatMap(pagepartDTO -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(pagepartDTO));
    }
}
