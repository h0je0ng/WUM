package com.hnpl.wum.require.service;

import com.hnpl.wum.require.dto.RequireDto;
import com.hnpl.wum.require.mapper.RequireMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequireService {
    @Autowired
    private RequireMapper requireMapper;

    public List<RequireDto> selectList(Map map){
        return requireMapper.requireList(map);
    }
    public int countRequire(){
        return requireMapper.countRequire();
    }
    public RequireDto requireDetail(Long requireSeq){
        return requireMapper.requireDetail(requireSeq);
    }
    public Long insertRequire(RequireDto requireDto){
        requireMapper.addRequire(requireDto);
        Long requireSeq = requireMapper.findRequireSeq(requireDto);
        return requireSeq;
    }
    public int updateRequire(RequireDto requireDto){
        return requireMapper.updateRequire(requireDto);
    }
    public int deleteRequire(Map map){
        return requireMapper.deleteRequire(map);
    }
}
