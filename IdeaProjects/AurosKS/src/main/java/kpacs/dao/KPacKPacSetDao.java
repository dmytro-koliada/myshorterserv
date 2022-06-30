package kpacs.dao;

import java.util.List;
import kpacs.model.KnowledgePackage;
import kpacs.model.KnowledgePackageSet;

public interface KPacKPacSetDao {
    void create(KnowledgePackageSet knowledgePackageSet);

    List<KnowledgePackage> getAllById(Long id);
}
