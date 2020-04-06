package edu.bupt.slms.service;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.RespPageBean;
import edu.bupt.slms.mapper.ErrorMapper;
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


    public List<Error> getErrors() {
        return errorMapper.getAllErrors();
    }
}
