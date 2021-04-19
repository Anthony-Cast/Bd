package com.example.demo3.controller;

import com.example.demo3.entity.Product;
import com.example.demo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductoController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products/lista")
    public String listaProductos(Model model){
        model.addAttribute("listaProductos",productRepository.findAll());
        return "product/lista";
    }
    @GetMapping("/products/newProduct")
    public String newProduct(){
        return "product/newForm";
    }
    @GetMapping("/products/editarProduct")
    public String editarProduct(@RequestParam("id") int id, Model model){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            model.addAttribute("productEditar",optional.get());
            return "product/editar";
        }
        return "redirect:/products/lista";
    }
    @PostMapping("/products/guardarProduct")
    public String guardarProduct(Product product){
        productRepository.save(product);
        return "redirect:/products/lista";
    }
    @GetMapping("/products/borrarProduct")
    public String borrarCategory(@RequestParam("id") int id){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            productRepository.deleteById(id);
        }
        return "redirect:/products/lista";
    }
    @GetMapping("/products/borrarProduct2")
    public String borrarCategoryPruebas(@RequestParam("id") int id){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            productRepository.deleteById(id);
        }
        return "redirect:/products/lista";//pruebas de commit and push
    }
}

