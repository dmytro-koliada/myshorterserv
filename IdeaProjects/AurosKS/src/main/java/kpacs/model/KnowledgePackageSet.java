package kpacs.model;

import java.util.List;

public class KnowledgePackageSet {
    private Long id;
    private String title;
    private List<KnowledgePackage> knowledgePackages;

    public KnowledgePackageSet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KnowledgePackage> getKnowledgePackages() {
        return knowledgePackages;
    }

    public void setKnowledgePackages(List<KnowledgePackage> knowledgePackages) {
        this.knowledgePackages = knowledgePackages;
    }
}
