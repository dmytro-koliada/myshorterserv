package kpacs.controller;

import java.util.List;
import kpacs.convertor.KPacEditor;
import kpacs.model.KnowledgePackage;
import kpacs.model.KnowledgePackageSet;
import kpacs.service.KnowledgePackageService;
import kpacs.service.KnowledgePackageSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {

    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageSetService knowledgePackageSetService;

    public KnowledgePackageSetController(KnowledgePackageService knowledgePackageService,
                                         KnowledgePackageSetService knowledgePackageSetService) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageSetService = knowledgePackageSetService;
    }

    @GetMapping()
    public String getStart(Model model) {
        model.addAttribute("kPacSet", new KnowledgePackageSet());
        return "sets";
    }

    @PostMapping()
    public String commitForm(@ModelAttribute("kPacSet") KnowledgePackageSet kpacSet) {
        kpacSet = knowledgePackageSetService.create(kpacSet);
        System.out.println(kpacSet);
        return "redirect: /sets";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
        return "redirect:/sets";
    }

    @ModelAttribute("kPacData")
    public List<KnowledgePackage> kpacData() {
        return knowledgePackageService.getAll();
    }

    @ModelAttribute("kPacSetData")
    public List<KnowledgePackageSet> kpacSetsData() {
        return knowledgePackageSetService.getAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(KnowledgePackage.class,
                new KPacEditor(knowledgePackageService.getAll()));
    }
}

