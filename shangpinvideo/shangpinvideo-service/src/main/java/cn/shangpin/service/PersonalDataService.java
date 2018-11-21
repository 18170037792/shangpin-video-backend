package cn.shangpin.service;

import cn.shangpin.dto.PersonalDataDto;

/**
 * Created by qujie on 2018/11/20
 * */
public interface PersonalDataService {

    public void insert(PersonalDataDto personalDataDto) throws Exception;

    public void update(PersonalDataDto personalDataDto) throws Exception;
}
