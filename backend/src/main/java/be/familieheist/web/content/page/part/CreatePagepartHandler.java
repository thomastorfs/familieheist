package be.familieheist.web.content.page.part;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CreatePagepartHandler {
    private final PagepartService pagepartService;

    @Operation(
        tags = "createPagepart",
        summary = "Create a Content Pagepart",
        description = "Create a single Content Pagepart for a specific page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created the Content Pagepart")
        }
    )
    public Mono<PagepartDTO> createPagepart(@RequestBody PagepartCreateCommandDTO createCommandDTO) {
        return pagepartService.createPagepart(createCommandDTO);
    }
}
