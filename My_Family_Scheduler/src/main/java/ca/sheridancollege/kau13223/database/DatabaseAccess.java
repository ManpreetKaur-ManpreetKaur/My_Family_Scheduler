package ca.sheridancollege.kau13223.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.kau13223.beans.Event;

@Repository
public class DatabaseAccess {

	

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public List<Event> findAll() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM calendar";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event findById(Long id) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM calendar WHERE id =:id";
		namedParameters.addValue("id", id);
		return jdbc.queryForObject(query, namedParameters, new BeanPropertyRowMapper<Event>(Event.class));
	}

	public Long save(Event calendar) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO calendar( title, date, time, briefMessage, additionalInfo, enableNotification, notificationTime) VALUES( :title, :date, :time, :briefMessage, :additionalInfo, :enableNotification, :notificationTime)";
				
				namedParameters.addValue("title", calendar.getTitle());
				namedParameters.addValue("date", calendar.getDate());
				namedParameters.addValue("time", calendar.getTime());
				namedParameters.addValue("briefMessage", calendar.getBriefMessage());
				namedParameters.addValue("additionalInfo", calendar.getAdditionalInfo());
				namedParameters.addValue("enableNotification", calendar.isEnableNotification());
				namedParameters.addValue("notificationTime", calendar.getNotificationTime());

		jdbc.update(query, namedParameters, generatedKeyHolder);
		return (Long) generatedKeyHolder.getKey();
	}

	public void deleteAll() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM calendar";
		jdbc.update(query, namedParameters);
	}

	public Long count() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT count(*) FROM calendar";
		return jdbc.queryForObject(query, namedParameters, Long.TYPE);
	}

	public void saveAll(List<Event> eventList) {
		for (Event s : eventList) {
			save(s);
		}
	}
	
	public void deleteById(Long id) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM calendar WHERE id =:id";
		namedParameters.addValue("id", id);
		jdbc.update(query, namedParameters);
	}

}





