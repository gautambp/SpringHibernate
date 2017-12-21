package self.learning.spring.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadDAO {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public UploadVO findUpload(long id) {
		MapSqlParameterSource params = new MapSqlParameterSource("uploadId", id);
		return jdbc.queryForObject("select * from ehr_upload where id = :uploadId", params, new UploadRowMapper());
	}

	public List<UploadVO> findUploads() {
		return jdbc.query("select * from ehr_upload", new UploadRowMapper());
	}
	
	public boolean create(UploadVO uploadVO) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(uploadVO);
		return jdbc.update("insert into ehr_upload (id, registry_name, form_name, site_id, facility_id, ehr_upload_id, ehr_upload_file_name, ehr_upload_dt, ehr_upload_by) "
										+ "values (:id, :registryName, :formName, :siteId, :facilityId, :ehrUploadId, :ehrUploadFile, :ehrUploadDate, :ehrUploadBy)", params) == 1;
	}
	
	public int[] create(List<UploadVO> uploadVOs) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(uploadVOs.toArray());
		return jdbc.batchUpdate("insert into ehr_upload (id, registry_name, form_name, site_id, facility_id, ehr_upload_id, ehr_upload_file_name, ehr_upload_dt, ehr_upload_by) "
				+ "values (:id, :registryName, :formName, :siteId, :facilityId, :ehrUploadId, :ehrUploadFile, :ehrUploadDate, :ehrUploadBy)", params);
	}
	
	public boolean delete(long id) {
		MapSqlParameterSource params = new MapSqlParameterSource("uploadId", id);
		return jdbc.update("delete from ehr_upload where id = :uploadId", params) == 1;
	}
	
	class UploadRowMapper implements RowMapper<UploadVO> {

		public UploadVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UploadVO uploadVO = new UploadVO();
			uploadVO.setId(rs.getLong("id"));
			uploadVO.setSiteId(rs.getLong("site_id"));
			uploadVO.setFacilityId(rs.getLong("facility_id"));
			uploadVO.setEhrUploadId(rs.getLong("ehr_upload_id"));
			uploadVO.setRegistryName(rs.getString("registry_name"));
			uploadVO.setFormName(rs.getString("form_name"));
			uploadVO.setEhrUploadFile(rs.getString("ehr_upload_file_name"));
			uploadVO.setEhrUploadDate(rs.getDate("ehr_upload_dt"));
			uploadVO.setEhrUploadBy(rs.getLong("ehr_upload_by"));
			return uploadVO;
		}
		
	}
}
