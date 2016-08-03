package com.ucs.rsa.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ucs.rsa.common.dto.ServiceTypeDTO;
import com.ucs.rsa.common.dto.ServiceTypesDTO;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.service.ServiceTypeService;

@Controller
@RequestMapping("/servicetype")
public class ServiceTypeResource {

	@Autowired
	private ServiceTypeService serviceTypeService;

	public ServiceTypeService getServiceTypeService() {
		return serviceTypeService;
	}

	public void setServiceTypeService(ServiceTypeService serviceTypeService) {
		this.serviceTypeService = serviceTypeService;
	}

	@RequestMapping(value = "/servicetypeslist", method = { RequestMethod.GET })
	public ModelAndView serviceTypesList() {

		List<ServiceTypeModel> serviceTypeModelList = new ArrayList<>();
		serviceTypeModelList = getServiceTypeService().loadAll(
				ServiceTypeModel.class);

		ServiceTypesDTO serviceTypesDTO = new ServiceTypesDTO();
		List<ServiceTypeDTO> serviceTypeDTOs = new ArrayList<>();

		for (ServiceTypeModel serviceTypeModel : serviceTypeModelList) {
			ServiceTypeDTO serviceTypeDTO = new ServiceTypeDTO();
			serviceTypeDTO
					.setServiceTypeId(serviceTypeModel.getServiceTypeId());
			serviceTypeDTO.setServiceType(serviceTypeModel.getServiceType());
			serviceTypeDTO.setServicePrice(serviceTypeModel.getServicePrice());
			serviceTypeDTOs.add(serviceTypeDTO);
		}
		serviceTypesDTO.setServiceTypesDTO(serviceTypeDTOs);

		return new ModelAndView("xml", "servicetypeslist", serviceTypesDTO);

	}

}
