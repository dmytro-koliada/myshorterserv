package kpacs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import javax.sql.DataSource;
import kpacs.dao.KnowledgePackageSetDao;
import kpacs.dao.mapper.KPacSetRowMapper;
import kpacs.model.KnowledgePackageSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageSetDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO k_pac_sets (titles) VALUES (?);";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, knowledgePackageSet.getTitle());
            return ps;
        }, keyHolder);
        knowledgePackageSet.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return knowledgePackageSet;
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return jdbcTemplate.query("SELECT * FROM k_pac_sets", new KPacSetRowMapper());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM k_pac_sets WHERE id = ?;", id);
    }

    @Override
    public KnowledgePackageSet getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM k_pac_sets WHERE id = ?;",
                new Object[] {id}, new KPacSetRowMapper());
    }
}
