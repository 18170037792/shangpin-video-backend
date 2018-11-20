package cn.shangpin.dao;

import cn.shangpin.pojo.PersonalDataTable;

public interface PersonalDataDao {

    public int insert(PersonalDataTable personalDataTable);

    public int update(PersonalDataTable personalDataTable);
}
