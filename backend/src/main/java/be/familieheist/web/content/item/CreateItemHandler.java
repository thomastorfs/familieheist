package be.familieheist.web.content.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CreateItemHandler {
    private final ItemService itemService;

    @Operation(
        tags = "item",
        operationId = "createItem",
        summary = "Create a Content Item",
        description = "Create a single Content Item for a specific page",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created the Content Item")
        }
    )
    public Mono<ItemDTO> createItem(@RequestBody ItemCreateCommandDTO createCommandDTO) {
        return itemService.createItem(createCommandDTO);
    }
}
