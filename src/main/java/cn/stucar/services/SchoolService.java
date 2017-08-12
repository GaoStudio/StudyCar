package cn.stucar.services;

import cn.stucar.model.School;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
public interface SchoolService {
   public List<School> getAllSchool();
}
