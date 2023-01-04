package be.familieheist.web;

import be.familieheist.web.content.item.*;
import be.familieheist.web.content.page.*;
import be.familieheist.web.content.page.part.*;
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
                                                 CreatePagepartHandler createPagepartHandler,
                                                 UpdatePagepartHandler updatePagepartHandler,
                                                 DeletePagepartHandler deletePagepartHandler,
                                                 CreateItemHandler createItemHandler,
                                                 UpdateItemHandler updateItemHandler,
                                                 DeleteItemHandler deleteItemHandler) {
        return route()
            .POST("/api/page",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> createPage(createPageHandler, serverRequest),
                consumer -> consumer.beanClass(CreatePageHandler.class).beanMethod("createPage").build())
            .GET("/api/page/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> getPageById(getPageHandler, serverRequest),
                consumer -> consumer.beanClass(GetPageHandler.class).beanMethod("getPageById").build())
            .PATCH("/api/page/{id}",
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
            .PATCH("/api/pagepart/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> updatePagepartById(updatePagepartHandler, serverRequest),
                consumer -> consumer.beanClass(UpdatePagepartHandler.class).beanMethod("updatePagepartById").build())
            .DELETE("/api/pagepart/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> deletePagepartById(deletePagepartHandler, serverRequest),
                consumer -> consumer.beanClass(DeletePagepartHandler.class).beanMethod("deletePagepartById").build())
            .POST("/api/item",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> createItem(createItemHandler, serverRequest),
                consumer -> consumer.beanClass(CreateItemHandler.class).beanMethod("createItem").build())
            .PATCH("/api/item/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> updateItemById(updateItemHandler, serverRequest),
                consumer -> consumer.beanClass(UpdateItemHandler.class).beanMethod("updateItemById").build())
            .DELETE("/api/item/{id}",
                accept(MediaType.APPLICATION_JSON),
                serverRequest -> deleteItemById(deleteItemHandler, serverRequest),
                consumer -> consumer.beanClass(DeleteItemHandler.class).beanMethod("deleteItemById").build())
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
            .flatMap(result -> ServerResponse.noContent().build());
    }

    private Mono<ServerResponse> createPagepart(CreatePagepartHandler createPagepartHandler, ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PagepartCreateCommandDTO.class)
            .flatMap(createPagepartHandler::createPagepart)
            .flatMap(pagepartDTO -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(pagepartDTO));
    }

    private Mono<ServerResponse> updatePagepartById(UpdatePagepartHandler updatePagepartHandler, ServerRequest serverRequest) {
        String pagepartId = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(PagepartUpdateCommandDTO.class)
            .flatMap(pagepartUpdateCommand -> updatePagepartHandler.updatePagepartById(pagepartId, pagepartUpdateCommand))
            .flatMap(pagepartDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pagepartDTO));
    }

    private Mono<ServerResponse> deletePagepartById(DeletePagepartHandler deletePagepartHandler, ServerRequest serverRequest) {
        String pagepartId = serverRequest.pathVariable("id");
        return deletePagepartHandler.deletePagepartById(pagepartId)
            .flatMap(result -> ServerResponse.noContent().build());
    }

    private Mono<ServerResponse> createItem(CreateItemHandler createItemHandler, ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ItemCreateCommandDTO.class)
            .flatMap(createItemHandler::createItem)
            .flatMap(pagepartDTO -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(pagepartDTO));
    }

    private Mono<ServerResponse> updateItemById(UpdateItemHandler updateItemHandler, ServerRequest serverRequest) {
        String itemId = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(ItemUpdateCommandDTO.class)
            .flatMap(itemUpdateCommand -> updateItemHandler.updateItemById(itemId, itemUpdateCommand))
            .flatMap(itemDTO -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(itemDTO));
    }

    private Mono<ServerResponse> deleteItemById(DeleteItemHandler deleteItemHandler, ServerRequest serverRequest) {
        String itemId = serverRequest.pathVariable("id");
        return deleteItemHandler.deleteItemById(itemId)
            .flatMap(result -> ServerResponse.noContent().build());
    }
}
