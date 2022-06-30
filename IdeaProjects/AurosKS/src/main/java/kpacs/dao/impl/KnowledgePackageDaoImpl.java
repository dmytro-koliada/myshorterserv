package kpacs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import javax.sql.DataSource;
import kpacs.dao.KnowledgePackageDao;
import kpacs.dao.mapper.KPacRowMapper;
import kpacs.model.KnowledgePackage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return jdbcTemplate.query("SELECT * FROM k_pacs", new KPacRowMapper());
    }

    @Override
    public KnowledgePackage create(KnowledgePackage knowledgePackage) {
        String query = "INSERT INTO k_pacs (titles, descriptions, creationDate) VALUES (?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, knowledgePackage.getTitle());
            ps.setString(2, knowledgePackage.getDescription());
            ps.setString(3, knowledgePackage.getCreationDate());
            return ps;
        }, keyHolder);
        knowledgePackage.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return knowledgePackage;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM k_pacs WHERE id = ?;", id);
    }
}
