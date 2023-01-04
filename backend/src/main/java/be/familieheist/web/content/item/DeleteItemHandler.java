package be.familieheist.web.content.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class DeleteItemHandler {
    private final ItemService itemService;

    @Operation(
        tags = "item",
        operationId = "deleteItemById",
        summary = "Delete a Content Item",
        description = "Delete a single Content Item by ID",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the Content Item"),
            @ApiResponse(responseCode = "400", description = "Unable to delete Content Item")
        }
    )
    public Mono<Void> deleteItemById(@Parameter(in = ParameterIn.PATH, description = "Content Item ID") String id) {
        return itemService.deleteItemById(id);
    }
}
