package cn.stucar.dao;

import cn.stucar.model.Coach;
import cn.stucar.model.School;

import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
public interface SchoolDao {
    public List<School> selectAllSchool();
}
