package edu.bupt.slms.service;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.RespPageBean;
import edu.bupt.slms.mapper.ErrorMapper;
import edu.bupt.slms.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 10:52:52
 */
@Service
public class ErrorService {
    @Autowired
    ErrorMapper errorMapper;


    public int addError(Error error) {
        return errorMapper.insertSelective(error);
    }

    public void updateError(Error error) {
        errorMapper.updateByPrimaryKeySelective(error);
    }

    public List<Error> getErrorByaId(Integer id) {
        return errorMapper.getErrorByaId(id);
    }

    public RespPageBean getErrorByPage(boolean part,Integer page, Integer size, Error error, Date[] dateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        long total = errorMapper.getTotal(part,error, dateScope);
        List<Error> errors = errorMapper.getErrorByPage(part,page,size,error,dateScope);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(errors);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public List<Error> getTasksWithAId() {
        return errorMapper.getTasksWithAId(AccountUtils.getCurrentAccount().getId());
    }

    public List<Error> getHistoryTasksWithAId() {
        return errorMapper.getHistoryTasksWithAId(AccountUtils.getCurrentAccount().getId());
    }

    public Error getErrorId(Integer key) {
        return errorMapper.selectByPrimaryKey(key);
    }
}
