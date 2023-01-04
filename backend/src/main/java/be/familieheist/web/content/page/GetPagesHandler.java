package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetPagesHandler {
    private final PageService pageService;

    @Operation(
        tags = "page",
        operationId = "getPages",
        summary = "Get Content Pages",
        description = "Return basic information about Content Pages",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Content Pages")
        }
    )
    public Mono<List<PageDTO>> getPages() {
        return pageService.getPages();
    }
}
