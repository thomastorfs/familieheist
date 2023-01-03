package be.familieheist.web.content.page.part;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class DeletePagepartHandler {
    private final PagepartService pagepartService;

    @Operation(
        tags = "deletePagepartById",
        summary = "Delete a Content Pagepart",
        description = "Delete a single Content Pagepart by ID",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the Content Pagepart"),
            @ApiResponse(responseCode = "400", description = "Unable to delete Content Pagepart")
        }
    )
    public Mono<Void> deletePagepartById(@Parameter(in = ParameterIn.PATH, description = "Content Pagepart ID") String id) {
        return pagepartService.deletePagepartById(id);
    }
}
