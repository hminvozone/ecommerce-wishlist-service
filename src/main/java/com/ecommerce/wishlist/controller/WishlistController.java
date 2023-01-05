package com.ecommerce.wishlist.controller;

import com.ecommerce.wishlist.entity.WishList;
import com.ecommerce.wishlist.service.IWishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "wishlist", description = "REST APIs for wishlist service")
public class WishlistController {
    private final IWishlistService iWishlistService;

    public WishlistController(IWishlistService iWishlistService) {
        this.iWishlistService = iWishlistService;
    }

    @GetMapping("/{user_id}")
    @Operation(summary = "View a wishlist using the wishlist_id provided in request params")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = WishList.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<WishList> getWishListById(@NotNull @PathVariable("user_id") Long user_id){
        return (ResponseEntity.ok()).body(this.iWishlistService.getWishList(user_id));
    }

    @PostMapping("/{user_id}")
    @Operation(summary = "Create a wishlist for a user using the user_id provided in request params")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Void> createWishlist(@NotNull @PathVariable("user_id") Long user_id) throws Exception {
        this.iWishlistService.createWishlist(user_id);
        return ResponseEntity.noContent().build();
    }
}
