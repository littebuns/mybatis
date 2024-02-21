package com.example.mybatisplus.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class MybatisPlusUtil {

    public static <VO, PO> Page<VO> convertVO(Page<PO> poPage, Class<VO> cla){
        List<PO> records = poPage.getRecords();
        if(CollectionUtils.isEmpty(records)){
           return null;
        }
        Page<VO> page = Page.of(poPage.getCurrent(), poPage.getSize(), poPage.getTotal());
        List<VO> vos = BeanUtil.copyToList(records, cla);
        page.setRecords(vos);
        return page;

    }

}
