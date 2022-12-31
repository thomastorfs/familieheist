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
        tags = "TODO",
        summary = "TODO",
        description = "TODO",
        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "TODO"),
            @ApiResponse(responseCode = "401", description = "TODO"),
            @ApiResponse(responseCode = "403", description = "TODO"),
            @ApiResponse(responseCode = "404", description = "TODO"),
        }
    )
    public Mono<PageDTO> getPageById(@Parameter(in = ParameterIn.PATH, description = "TODO") String id) {
        return pageService.getPageById(id);
    }
}
