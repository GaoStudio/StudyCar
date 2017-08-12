package cn.stucar.controller;

import cn.stucar.model.Result;
import cn.stucar.model.School;
import cn.stucar.services.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/11.
 */
@RestController
@RequestMapping(value = "/api/school", produces="application/json;charset=UTF-8")
@ResponseBody
@Api(description="驾校基本操作")
public class SchoolController extends BaseController{
    @Resource
    private SchoolService schoolService;

    @ApiOperation(value = "获取所有驾校",httpMethod = "GET",notes = "获取所有驾校")
    @ApiResponse(code = 200, message = "success",response = Result.class)
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Result<ArrayList> getAllSchool(){
      return new Result(1,"success", schoolService.getAllSchool());
    }
}