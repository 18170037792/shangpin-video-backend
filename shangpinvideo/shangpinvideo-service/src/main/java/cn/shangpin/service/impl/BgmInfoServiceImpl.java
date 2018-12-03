package cn.shangpin.service.impl;

import cn.shangpin.dao.BgmInfoDao;
import cn.shangpin.dto.BgmInfoDto;
import cn.shangpin.exception.ServiceException;
import cn.shangpin.pojo.BgmInfoTable;
import cn.shangpin.service.BgmInfoService;
import cn.shangpin.utils.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qujie on 2018/11/20
 * Bgm信息业务接口
 * */
@Service
public class BgmInfoServiceImpl implements BgmInfoService {

    @Autowired
    private BgmInfoDao bgmInfoDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<BgmInfoDto> getBgmList() throws Exception {
        List<BgmInfoTable> tables = bgmInfoDao.getBgmList();
        List<BgmInfoDto> dtos = new ArrayList<>();
        for (BgmInfoTable table:tables
             ) {
            BgmInfoDto dto=new BgmInfoDto();
            BeanUtils.copyProperties(table,dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getCount() throws Exception {
        int count = bgmInfoDao.getCount();
        return count;
    }

}
