package cn.stucar.services.impl;

import cn.stucar.dao.CoachDao;
import cn.stucar.dao.UserDao;
import cn.stucar.model.Coach;
import cn.stucar.model.User;
import cn.stucar.services.CoachService;
import cn.stucar.utils.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/11.
 */
@Service
public class CoachServiceImpl implements CoachService{
    @Resource
    public UserDao userDao;
    @Resource
    public CoachDao coachDao;
    public int apply(HttpServletRequest request, MultipartFile logo, MultipartFile card, MultipartFile auth,String userid,String phone, String name, int car) {
        User user = userDao.selectUserById(userid);
        String path = request.getSession().getServletContext().getRealPath("images/coach");
        String logopath,cardpath,authpath;
        try {
            logopath ="images/coach/"+ FileUpload.uploadImage(logo,user.getU_phone()+"_logo",path);
            cardpath ="images/coach/"+ FileUpload.uploadImage(card,user.getU_phone()+"card",path);
            authpath = "images/coach/"+FileUpload.uploadImage(auth,user.getU_phone()+"_auth",path);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
       return coachDao.insertCoach(new Coach(name,phone,logopath,cardpath,authpath,user.getU_id(),car));
    }
}
