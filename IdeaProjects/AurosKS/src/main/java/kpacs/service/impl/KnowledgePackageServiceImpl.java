package kpacs.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import kpacs.dao.KnowledgePackageDao;
import kpacs.model.KnowledgePackage;
import kpacs.service.KnowledgePackageService;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }

    @Override
    public KnowledgePackage creat(KnowledgePackage knowledgePackage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        knowledgePackage.setCreationDate(formatter.format(LocalDate.now()));
        return knowledgePackageDao.create(knowledgePackage);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageDao.delete(id);
    }
}
