package be.familieheist.web.content.page;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class UpdatePageHandler {
    private final PageService pageService;

    @Operation(
        tags = "page",
        operationId = "updatePageById",
        summary = "Update Content Page",
        description = "Update a single Content Page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully updated the Content Page"),
            @ApiResponse(responseCode = "400", description = "Unable to update Content Page")
        }
    )
    public Mono<PageDTO> updatePageById(@Parameter(in = ParameterIn.PATH, description = "Content Page ID") String id,
                                        @RequestBody PageUpdateCommandDTO pageUpdateCommandDTO) {
        return pageService.updatePageById(id, pageUpdateCommandDTO);
    }
}
