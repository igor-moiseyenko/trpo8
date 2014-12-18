package com.imoiseyenko.spastructure.backend.service.profile.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.Profile;
import com.imoiseyenko.spastructure.backend.service.profile.vo.ProfileVO;

/**
 * Converter for the {@link ProfileVO} value object to the {@link Profile}
 * entity instance and vice versa.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
@Component
public class ProfileVOConverter {

	/**
	 * Convert {@link Profile} entity instance to the {@link ProfileVO} value
	 * object.
	 * 
	 * @param profile
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public ProfileVO convertProfileToVO(Profile profile) {

		ProfileVO profileVO = null;

		if (profile != null) {

			profileVO = new ProfileVO();
			profileVO.setId(profile.getId());
			profileVO.setEmail(profile.getEmail());
			profileVO.setFirstname(profile.getFirstname());
			profileVO.setLastname(profile.getLastname());
			profileVO.setAddress(profile.getAddress());
		}

		return profileVO;
	}

	/**
	 * Convert list of {@link Profile} entity instances to the list of
	 * {@link ProfileVO} value objects.
	 * 
	 * @param profiles
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<ProfileVO> convertProfilesToVOs(List<Profile> profiles) {

		List<ProfileVO> profileVOs = new ArrayList<>();

		if (profiles != null && !profiles.isEmpty()) {
			for (Profile profile : profiles) {
				profileVOs.add(convertProfileToVO(profile));
			}
		}

		return profileVOs;
	}

	/**
	 * Convert {@link ProfileVO} value object to the {@link Profile} entity
	 * instance.
	 * 
	 * @param profileVO
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public Profile convertProfileVOToEntity(ProfileVO profileVO) {

		Profile profile = null;

		if (profileVO != null) {

			profile = new Profile();
			profile.setId(profileVO.getId());
			profile.setEmail(profileVO.getEmail());
			profile.setFirstname(profileVO.getFirstname());
			profile.setLastname(profileVO.getLastname());
			profile.setAddress(profileVO.getAddress());
		}

		return profile;
	}

	/**
	 * Convert list of {@link ProfileVO} value objects to the list of
	 * {@link Profile} entity instances.
	 * 
	 * @param profileVOs
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Profile> convertProfileVOsToEntities(List<ProfileVO> profileVOs) {

		List<Profile> profiles = new ArrayList<>();

		if (profileVOs != null && !profileVOs.isEmpty()) {
			for (ProfileVO profileVO : profileVOs) {
				profiles.add(convertProfileVOToEntity(profileVO));
			}
		}

		return profiles;
	}
}
