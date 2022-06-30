package kpacs.service;

import java.util.List;
import kpacs.model.KnowledgePackage;

public interface KnowledgePackageService {
    List<KnowledgePackage> getAll();

    KnowledgePackage creat(KnowledgePackage knowledgePackage);

    void delete(Long id);
}
