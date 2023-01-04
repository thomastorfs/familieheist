package be.familieheist.web.content.item;

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
public class UpdateItemHandler {
    private final ItemService itemService;

    @Operation(
        tags = "item",
        operationId = "updateItemById",
        summary = "Update a Content Item by ID",
        description = "Update a single Content Item by its identifier",
//        security = @SecurityRequirement(name = "basicAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully updated the Content Item"),
            @ApiResponse(responseCode = "400", description = "Unable to update Content Item")
        }
    )
    public Mono<ItemDTO> updateItemById(@Parameter(in = ParameterIn.PATH, description = "Content Item ID") String id,
                                        @RequestBody ItemUpdateCommandDTO updateCommandDTO) {
        return itemService.updateItemById(id, updateCommandDTO);
    }
}
