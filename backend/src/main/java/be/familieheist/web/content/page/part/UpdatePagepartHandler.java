package be.familieheist.web.content.page.part;

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
public class UpdatePagepartHandler {
    private final PagepartService pagepartService;

    @Operation(
        tags = "updatePagepartById",
        summary = "Update a Content Pagepart by ID",
        description = "Update a single Content Pagepart by its identifier",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully updated the Content Pagepart"),
            @ApiResponse(responseCode = "400", description = "Unable to update Content Pagepart")
        }
    )
    public Mono<PagepartDTO> updatePagepartById(@Parameter(in = ParameterIn.PATH, description = "Content Pagepart ID") String id,
                                                @RequestBody PagepartUpdateCommandDTO updateCommandDTO) {
        return pagepartService.updatePagepartById(id, updateCommandDTO);
    }
}
