package com.imoiseyenko.spastructure.backend.service.profile.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;

/**
 * Converter for the {@link SessionVO} value object to the {@link Session} entity instance.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@Component
public class SessionVOConverter {

	/**
	 * Convert {@link Session} entity instance to the {@link SessionVO} value object.
	 * 
	 * @param session
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public SessionVO convertSessionToVO (Session session) {

		SessionVO sessionVO = null;

		if (session != null) {

			sessionVO = new SessionVO();
			sessionVO.setId(session.getId());
			sessionVO.setAccessToken(session.getAccessToken());
			sessionVO.setAccountId(session.getAccount().getId());
		}

		return sessionVO;
	}

	/**
	 * Convert list of {@link Session} entity instances to the {@link SessionVO} value objects.
	 * 
	 * @param sessions
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<SessionVO> convertSessionsToVOs (List<Session> sessions) {

		List<SessionVO> sessionVOs = new ArrayList<>();

		if (sessions != null && !sessions.isEmpty()) {
			for (Session session : sessions) {
				sessionVOs.add(convertSessionToVO(session));
			}
		}

		return sessionVOs;
	}

	/**
	 * Convert {@link SessionVO} value object to the {@link Session} entity instance.
	 * 
	 * @param sessionVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public Session convertSessionVOToEntity (SessionVO sessionVO) {

		Session session = null;

		if (sessionVO != null) {

			session = new Session();
			session.setId(sessionVO.getId());
			session.setAccessToken(sessionVO.getAccessToken());
		}

		return session;
	}

	/**
	 * Convert list of {@link SessionVO} value objects to the {@link Session} entity instances.
	 * 
	 * @param sessionVOs
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Session> convertSessionVOsToEntities (List<SessionVO> sessionVOs) {

		List<Session> sessions = new ArrayList<>();

		if (sessionVOs != null && !sessionVOs.isEmpty()) {
			for (SessionVO sessionVO : sessionVOs) {
				sessions.add(convertSessionVOToEntity(sessionVO));
			}
		}

		return sessions;
	}
}
