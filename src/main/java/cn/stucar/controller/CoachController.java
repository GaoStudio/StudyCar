package cn.stucar.controller;

import cn.stucar.model.Result;
import cn.stucar.services.CoachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/11.
 */
@RestController
@RequestMapping(value = "/api/coach", produces="application/json;charset=UTF-8")
@ResponseBody
@Api(description="教练基本操作")
public class CoachController extends BaseController{
    @Resource
    private CoachService coachService;

    @ApiOperation(value = "申请成为教练",httpMethod = "POST",notes = "申请成为教练")
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(HttpServletRequest request, MultipartFile logo, MultipartFile card, MultipartFile auth, String userid, String phone, String name, int car)  {
       int result = coachService.apply(request,logo,card,auth,userid,phone,name,car);
        if(result==-1){
            return retContent(0,"");
        }else {
            return retContent(1,"申请成功！请耐心等待审核");
        }
    }

}
