package com.ecommerce.wishlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Class for default controller i.e swagger ui
 *
 * @author Saniya Jameel
 */
@RestController
@RequestMapping("/")
public class DefaultController {
    public DefaultController() {}

    /**
     * the following method is used to show swagger ui to the user
     */
    @GetMapping
    @Operation(hidden = true)
    public RedirectView swagger() {
        return new RedirectView("swagger-ui/index.html");
    }
}
