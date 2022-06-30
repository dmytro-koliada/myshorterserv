package kpacs.service.impl;

import java.util.List;
import kpacs.dao.KPacKPacSetDao;
import kpacs.dao.KnowledgePackageSetDao;
import kpacs.model.KnowledgePackageSet;
import kpacs.service.KnowledgePackageSetService;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;
    private final KPacKPacSetDao kpacKpacSetDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackageSetDao,
                                          KPacKPacSetDao kpacKpacSetDao) {
        this.knowledgePackageSetDao = knowledgePackageSetDao;
        this.kpacKpacSetDao = kpacKpacSetDao;
    }

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        knowledgePackageSet = knowledgePackageSetDao.create(knowledgePackageSet);
        if (knowledgePackageSet.getKnowledgePackages() != null) {
            kpacKpacSetDao.create(knowledgePackageSet);
        }
        return knowledgePackageSet;
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetDao.getAll();
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetDao.delete(id);
    }

    @Override
    public KnowledgePackageSet getById(Long id) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetDao.getById(id);
        knowledgePackageSet.setKnowledgePackages(kpacKpacSetDao.getAllById(id));
        return knowledgePackageSet;
    }
}
