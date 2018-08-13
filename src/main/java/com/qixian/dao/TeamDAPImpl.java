package com.qixian.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qixian.model.Team;

@Repository
public class TeamDAPImpl implements TeamDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}

	public void updateTeam(Team team) {
		Team updateTeam = getTeam(team.getId());
		updateTeam.setName(team.getName());
		updateTeam.setRating(team.getRating());
		getCurrentSession().update(updateTeam);
	}

	public Team getTeam(int id) {
		Team team = getCurrentSession().get(Team.class, id);
		return team;
	}

	public void deleteTeam(int id) {
		Team team = getTeam(id);
		if (null != team) {
			getCurrentSession().delete(team);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from team").list();
	}

}
