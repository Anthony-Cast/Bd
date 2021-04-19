package com.example.demo3.controller;

import com.example.demo3.entity.Category;
import com.example.demo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories/lista")
    public String listaCategoria(Model model){
        model.addAttribute("listaCategorias",categoryRepository.findAll());
        return "category/lista";
    }
    @GetMapping("/categories/newCategory")
    public String newCategory(){
        return "category/newForm";
    }
    @GetMapping("/categories/editarCategory")
    public String editarCategory(@RequestParam("id") int id,Model model){
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent()){
            model.addAttribute("categoriaEditar",optional.get());
            return "category/editar";
        }
        return "redirect:/categories/lista";
    }
    @PostMapping("/categories/guardarCategory")
    public String guardarCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categories/lista";
    }
    @GetMapping("/categories/borrarCategory")
    public String borrarCategory(@RequestParam("id") int id){
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent()){
            categoryRepository.deleteById(id);
        }
        return "redirect:/categories/lista";
    }
    @PostMapping("/categories/buscar")
    public String buscarCategoria(@RequestParam("searchField") String search,Model model){
        model.addAttribute("listaCategorias",categoryRepository.buscarporNombreCategoria(search));
        return "category/lista";
    }
}
