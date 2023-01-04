package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class GetPageByUriHandler {
    private final PageService pageService;

    @Operation(
        tags = "page",
        operationId = "getPageByUri",
        summary = "Get Content Page by URI",
        description = "Return all information regarding a single Content Page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Content Page")
        }
    )
    public Mono<PageDTO> getPageByUri(@Parameter(in = ParameterIn.PATH, description = "Content Page URI") String uri) {
        return pageService.getPageByUri(uri);
    }
}
