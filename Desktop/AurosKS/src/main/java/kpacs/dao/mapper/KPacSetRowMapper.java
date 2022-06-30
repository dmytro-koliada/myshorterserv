package kpacs.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import kpacs.model.KnowledgePackageSet;
import org.springframework.jdbc.core.RowMapper;

public class KPacSetRowMapper implements RowMapper<KnowledgePackageSet> {
    @Override
    public KnowledgePackageSet mapRow(ResultSet rs, int rowNum) throws SQLException {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setId(rs.getLong("id"));
        knowledgePackageSet.setTitle(rs.getString("titles"));
        return knowledgePackageSet;
    }
}
