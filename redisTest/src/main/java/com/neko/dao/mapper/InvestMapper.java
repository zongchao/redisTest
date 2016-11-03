package com.neko.dao.mapper;

import com.neko.dao.po.Invest;
import com.neko.dao.po.InvestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvestMapper {
    int countByExample(InvestExample example);

    int deleteByExample(InvestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Invest record);

    int insertSelective(Invest record);

    List<Invest> selectByExample(InvestExample example);

    Invest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Invest record, @Param("example") InvestExample example);

    int updateByExample(@Param("record") Invest record, @Param("example") InvestExample example);

    int updateByPrimaryKeySelective(Invest record);

    int updateByPrimaryKey(Invest record);
}