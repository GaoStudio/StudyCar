package cn.stucar.services.impl;

import cn.stucar.dao.CoachDao;
import cn.stucar.dao.SchoolDao;
import cn.stucar.dao.UserDao;
import cn.stucar.model.Coach;
import cn.stucar.model.School;
import cn.stucar.model.User;
import cn.stucar.services.CoachService;
import cn.stucar.services.SchoolService;
import cn.stucar.utils.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
@Service
public class SchoolServiceImpl implements SchoolService{
    @Resource
    public SchoolDao schoolDao;
    public List<School> getAllSchool() {
        return schoolDao.selectAllSchool();
    }
}
