package kpacs.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import kpacs.model.KnowledgePackage;
import org.springframework.jdbc.core.RowMapper;

public class KPacRowMapper implements RowMapper<KnowledgePackage> {
    @Override
    public KnowledgePackage mapRow(ResultSet rs, int rowNum) throws SQLException {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setId(rs.getLong("id"));
        knowledgePackage.setTitle(rs.getString("titles"));
        knowledgePackage.setDescription(rs.getString("descriptions"));
        knowledgePackage.setCreationDate(rs.getString("creationDate"));
        return knowledgePackage;
    }
}
