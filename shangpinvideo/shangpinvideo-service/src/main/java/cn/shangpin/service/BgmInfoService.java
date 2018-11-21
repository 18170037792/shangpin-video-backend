package cn.shangpin.service;

import cn.shangpin.dto.BgmInfoDto;

import java.util.List;

/**
 * Created by qujie on 2018/11/19
 * */
public interface BgmInfoService {

    public List<BgmInfoDto> getBgmList() throws Exception;

    public int getCount() throws Exception;
}
