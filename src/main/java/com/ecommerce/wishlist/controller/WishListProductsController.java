package com.ecommerce.wishlist.controller;

import com.ecommerce.wishlist.dto.GetWishListProductsResponse;
import com.ecommerce.wishlist.service.IWishListProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/wishlist_products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "wishlist_products", description = "REST APIs for wishlist_products service")
public class WishListProductsController {

    private final IWishListProductsService iWishListProductsService;

    public WishListProductsController(IWishListProductsService iWishListProductsService) {
        this.iWishListProductsService = iWishListProductsService;
    }

    @GetMapping("/{wishlist_id}")
    @Operation(summary = "View all products of wishlist using the wishlist_id provided in request params")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GetWishListProductsResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<GetWishListProductsResponse> getWishListById(@NotNull @PathVariable("wishlist_id") Long wishlist_id){
        return (ResponseEntity.ok()).body(this.iWishListProductsService.getWishListProducts(wishlist_id));
    }

    @PostMapping("/{wishlist_id}/{product_id}")
    @Operation(summary = "Add a product in wishlist")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Void> addProduct(@NotNull @PathVariable("wishlist_id") Long wishlist_id, @NotNull @PathVariable("product_id") Long product_id) throws Exception {
        this.iWishListProductsService.addProduct(wishlist_id, product_id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{wishlist_id}/{product_id}")
    @Operation(summary = "Remove a product in wishlist")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Void> removeProduct(@NotNull @PathVariable("wishlist_id") Long wishlist_id, @NotNull @PathVariable("product_id") Long product_id) throws Exception {
        this.iWishListProductsService.removeProduct(wishlist_id, product_id);
        return ResponseEntity.noContent().build();
    }
}
