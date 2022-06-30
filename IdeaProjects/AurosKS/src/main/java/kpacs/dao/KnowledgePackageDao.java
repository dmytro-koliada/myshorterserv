package kpacs.dao;

import java.util.List;
import kpacs.model.KnowledgePackage;

public interface KnowledgePackageDao {
    List<KnowledgePackage> getAll();

    KnowledgePackage create(KnowledgePackage knowledgePackage);

    void delete(Long id);
}
