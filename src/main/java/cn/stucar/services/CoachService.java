package cn.stucar.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/11.
 */
public interface CoachService {
   public int apply(HttpServletRequest request, MultipartFile logo, MultipartFile card, MultipartFile auth,String userid, String phone, String name, int car);
}
