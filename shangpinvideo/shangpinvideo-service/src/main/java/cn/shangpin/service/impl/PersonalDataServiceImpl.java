package cn.shangpin.service.impl;

import cn.shangpin.dao.PersonalDataDao;
import cn.shangpin.dto.PersonalDataDto;
import cn.shangpin.exception.ServiceException;
import cn.shangpin.pojo.PersonalDataTable;
import cn.shangpin.service.PersonalDataService;
import cn.shangpin.utils.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    private PersonalDataDao personalDataDao;

    @Override
    public void insert(PersonalDataDto personalDataDto) throws Exception {
        PersonalDataTable table = new PersonalDataTable();
        BeanUtils.copyProperties(personalDataDto,table);
        int result = personalDataDao.insert(table);
        if(result==0){
            throw  new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    @Override
    public void update(PersonalDataDto personalDataDto) {

    }
}
