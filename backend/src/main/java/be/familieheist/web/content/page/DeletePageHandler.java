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
public class DeletePageHandler {
    private final PageService pageService;

    @Operation(
        tags = "deletePageById",
        summary = "Delete a Content Page",
        description = "Delete a single Content Page by ID",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the Content Page"),
            @ApiResponse(responseCode = "400", description = "Unable to delete Content Page")
        }
    )
    public Mono<Void> deletePageById(@Parameter(in = ParameterIn.PATH, description = "Content Page ID") String id) {
        return pageService.deletePageById(id);
    }
}
