package kpacs.controller;

import java.util.List;
import kpacs.model.KnowledgePackage;
import kpacs.service.KnowledgePackageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {

    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping()
    public String getStart(Model model) {
        model.addAttribute("kPac", new KnowledgePackage());
        return "kpacs";
    }

    @PostMapping("")
    public String create(@ModelAttribute("kPac") KnowledgePackage kpac) {
        knowledgePackageService.creat(kpac);
        return "redirect:/kpacs";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
        return "redirect: /kpacs";
    }

    @ModelAttribute("kPacData")
    public List<KnowledgePackage> getKPacData() {
        return knowledgePackageService.getAll();
    }
}
