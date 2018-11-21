package cn.shangpin.controller;

import cn.shangpin.dto.PersonalDataDto;
import cn.shangpin.dto.UserInfoDto;
import cn.shangpin.pojo.PersonalDataTable;
import cn.shangpin.service.PersonalDataService;
import cn.shangpin.utils.Constant;
import cn.shangpin.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/personal")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @PostMapping("/add")
    public JsonResult<Object> addPersonal(@RequestBody PersonalDataDto personalDataDto, HttpSession session) throws Exception{
        UserInfoDto user = (UserInfoDto) session.getAttribute("user");
        personalDataDto.setUserId(user.getId());
        personalDataService.insert(personalDataDto);
        return new JsonResult<>(Constant.SUCCESS_CODE,Constant.SAVE_SUCCESS);
    }
}
