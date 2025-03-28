package com.example.spring.myapp.service;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.myapp.dto.EMPDTO;
import com.example.spring.myapp.dto.MENUDTO;
import com.example.spring.myapp.exception.BizException;
import com.example.spring.myapp.model.mapper.TestTableMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestTableServiceImpl extends BaseService{

	@Autowired
	TestTableMapper testtableMapper;

	public List<EMPDTO> SelectAllList(String id) throws Exception {
		List result = selectEmpdto(id);
		return result;
	}

	public List SelectMenuList() throws Exception {
		List result = testtableMapper.SelectMenuList();
		return result;
	}

	public void Insert(List<EMPDTO> saveDatas) throws Exception {
        int count;
        for (EMPDTO empdto : saveDatas) {
            if (INSERT.equals(empdto.get_status())) {
                count = insertEmpdto(empdto);
                if (count < 0) {
                    throw new BizException(
                        String.format("추가에 실패 하였습니다. [empno=%s]", empdto.empno));
                }
            }
            else if (UPDATE.equals(empdto.get_status())) {
                count = updateEmpdto(empdto);
                if (count < 0) {
                    throw new BizException(
                            String.format("추가에 실패 하였습니다. [empno=%s]", empdto.empno));
                }
            }
        }
	}

	private List selectEmpdto(String param) throws Exception {
        return testtableMapper.SelectAllList(param);
    }

	private int insertEmpdto(EMPDTO param) throws Exception {
        return testtableMapper.insert(param);
    }

    private int updateEmpdto(EMPDTO param) throws Exception {
        return testtableMapper.update(param);
    }

}
