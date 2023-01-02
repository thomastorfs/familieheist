package be.familieheist.web.content.page;

import be.familieheist.web.content.page.part.PagepartDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CreatePageHandler {
    private final PageService pageService;

    @Operation(
        tags = "createPage",
        summary = "Create a Content Page",
        description = "Create a single Content Page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created the Content Page")
        }
    )
    public Mono<PageDTO> createPage(@RequestBody PageCreateCommandDTO createCommandDTO) {
        return pageService.createPage(createCommandDTO);
    }
}
