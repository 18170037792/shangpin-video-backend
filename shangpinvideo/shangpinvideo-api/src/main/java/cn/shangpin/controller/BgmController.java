package cn.shangpin.controller;

import cn.shangpin.dto.BgmInfoDto;
import cn.shangpin.service.BgmInfoService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bgm")
public class BgmController {

    @Autowired
    private BgmInfoService bgmInfoService;

    /**
     * 获取bgm列表
     * */
    @GetMapping("/bgmList")
    public JsonResult<List<BgmInfoDto>> getBgmList() throws Exception{
        /**
         * 查询统计
         * */
        int count = bgmInfoService.getCount();
        if(count==0){
            return new JsonResult<>(Constant.SUCCESS_CODE,Constant.COUNT_ZERO);
        }
        List<BgmInfoDto> bgmList = bgmInfoService.getBgmList();
        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.QUERY_SUCCESS,bgmList);
    }
}
