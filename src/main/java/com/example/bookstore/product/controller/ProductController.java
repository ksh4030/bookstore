package com.example.bookstore.product.controller;

import com.example.bookstore.product.model.ProductInput;
import com.example.bookstore.product.model.ProductParam;
import com.example.bookstore.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/admin/product/add")
    public String productAdd() {

        return "product/add_product";
    }

    @PostMapping("/admin/product/add")
    public String productAddSubmit(ProductInput parameter) {
        productService.add(parameter);

        return "redirect:/admin/product/add";
    }

    @GetMapping("/admin/product/list")
    public String productListAdmin(Model model, ProductParam parameter) {

        model.addAttribute("list", productService.list());

        return "product/product_list_admin";
    }

    @PostMapping("/admin/product/list")
    public String productDeleteAdmin(String productId) {

        productService.delete(productId);

        return "redirect:/admin/product/list";
    }

    @GetMapping("/admin/product/detail")
    public String productDetailAdmin(Model model, String id) {

        model.addAttribute("detail", productService.detail(id));

        return "product/product_detail_admin";
    }

    @PostMapping("/admin/product/detail")
    public String productUpdateAdmin(ProductInput parameter, String id) {

        productService.update(parameter, id);

        return "product/product_list_admin";
    }



}
