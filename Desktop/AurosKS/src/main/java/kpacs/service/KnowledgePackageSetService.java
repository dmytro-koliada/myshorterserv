package kpacs.service;

import java.util.List;
import kpacs.model.KnowledgePackageSet;

public interface KnowledgePackageSetService {
    KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet);

    List<KnowledgePackageSet> getAll();

    void delete(Long id);

    KnowledgePackageSet getById(Long id);
}
