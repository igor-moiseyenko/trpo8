package com.imoiseyenko.spastructure.backend.service.mobileapp.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.MobileApp;
import com.imoiseyenko.spastructure.backend.repository.entity.MobileAppType;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.MobileAppVO;

/**
 * Converter for mobile application value objects.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
@Component
public class MobileAppVOConverter {

	public MobileAppVO convertMobileAppToVO (MobileApp mobileApp) {

		MobileAppVO mobileAppVO = null;

		if (mobileApp != null) {

			mobileAppVO = new MobileAppVO();
			mobileAppVO.setId(mobileApp.getId());
			mobileAppVO.setName(mobileApp.getName());
			mobileAppVO.setPrice(mobileApp.getPrice());
			mobileAppVO.setType(mobileApp.getMobileAppType().toString());
			mobileAppVO.setRaiting(mobileApp.getRaiting());
			mobileAppVO.setDescription(mobileApp.getDescription());
		}

		return mobileAppVO;
	}

	public List<MobileAppVO> convertMobileAppsToVOs (List<MobileApp> mobileApps) {

		List<MobileAppVO> mobileAppVOs = new ArrayList<>();

		if (mobileApps != null && !mobileApps.isEmpty()) {
			for (MobileApp mobileApp : mobileApps) {
				mobileAppVOs.add(convertMobileAppToVO(mobileApp));
			}
		}

		return mobileAppVOs;
	}

	public MobileApp convertMobileAppVOToEntity (MobileAppVO mobileAppVO) {

		MobileApp mobileApp = new MobileApp();

		if (mobileAppVO != null) {

			mobileApp.setId(mobileAppVO.getId());
			mobileApp.setName(mobileAppVO.getName());
			mobileApp.setPrice(mobileAppVO.getPrice());
			mobileApp.setMobileAppType((mobileAppVO.getType() != null) ? MobileAppType.valueOf(mobileAppVO.getType())
					: null);
			mobileApp.setRaiting(mobileAppVO.getRaiting());
			mobileApp.setDescription(mobileAppVO.getDescription());
		}

		return mobileApp;
	}

}
