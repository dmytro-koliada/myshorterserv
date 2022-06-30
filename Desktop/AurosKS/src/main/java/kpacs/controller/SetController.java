package kpacs.controller;

import kpacs.service.KnowledgePackageSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/set")
public class SetController {
    private final KnowledgePackageSetService knowledgePackageSetService;

    public SetController(KnowledgePackageSetService knowledgePackageSetService) {
        this.knowledgePackageSetService = knowledgePackageSetService;
    }

    @GetMapping("/{id}")
    public String getKPacSetDetails(@PathVariable Long id, Model model) {
        model.addAttribute("kPacSet", knowledgePackageSetService.getById(id));
        return "set";
    }
}
