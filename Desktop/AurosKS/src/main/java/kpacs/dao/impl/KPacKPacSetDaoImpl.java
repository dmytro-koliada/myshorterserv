package kpacs.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import kpacs.dao.KPacKPacSetDao;
import kpacs.dao.mapper.KPacRowMapper;
import kpacs.model.KnowledgePackage;
import kpacs.model.KnowledgePackageSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KPacKPacSetDaoImpl implements KPacKPacSetDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public KPacKPacSetDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(KnowledgePackageSet knowledgePackageSet) {
        String query = "INSERT INTO k_pac_k_pac_sets (k_pac_id, k_pac_set_id) VALUES (?, ?);";
        List<Long> kpacIdList = knowledgePackageSet.getKnowledgePackages().stream()
                .map(KnowledgePackage::getId)
                .collect(Collectors.toList());
        Long kpacSetId = knowledgePackageSet.getId();
        for (Long kpacId: kpacIdList) {
            jdbcTemplate.update(query, kpacId, kpacSetId);
        }
    }

    @Override
    public List<KnowledgePackage> getAllById(Long id) {
        return jdbcTemplate.query("SELECT kp.id AS id, kp.titles AS titles, "
                        + "kp.descriptions AS descriptions, kp.creationDate AS creationDate "
                        + "FROM k_pac_k_pac_sets kpkps JOIN k_pacs kp on kp.id = kpkps.k_pac_id "
                        + "WHERE k_pac_set_id = ?;",
                new Object[] {id}, new KPacRowMapper());
    }

}
