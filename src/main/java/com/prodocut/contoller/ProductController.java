package com.prodocut.contoller;

import com.prodocut.model.dto.ProductDto;
import com.prodocut.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(dto));
    }

    //  @PathVariable

    @GetMapping
    public ResponseEntity<ProductDto> queryProduct(
            @NotBlank(message = "Not Empty Name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(service.queryProduct(name));

    }


    //ürün satın alma bunun  için önce liseleme olucak o tarihte indirm var mı ? bunu disacoun service ile olucak

    //eklenmek istenen ürün var ise stok güncelle diye uyarı

    //sorgular cache

    //stok güncellem end

    //ürün almak istenirse tarihteki indimli fiyar ile satılıcak ve discount serive tabloya ekleme olucak
}
