package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class GetPageHandler {
    private final PageService pageService;

    @Operation(
        tags = "getPageById",
        summary = "Get Content Page by ID",
        description = "Return all information regarding a single Content Page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Content Page")
        }
    )
    public Mono<PageDTO> getPageById(@Parameter(in = ParameterIn.PATH, description = "Content Page ID") String id) {
        return pageService.getPageById(id);
    }
}
