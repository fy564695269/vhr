package com.example.springbootvhr.service.system.basic;

import com.example.springbootvhr.dao.PositionDao;
import com.example.springbootvhr.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionDao positionDao;

    public List<Position> getAllPositions() {
        return positionDao.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
        return positionDao.insert(position);
    }

    public Integer updatePosition(Position position) {
        return positionDao.update(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionDao.deleteById(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
        return positionDao.deletePositionsByIds(ids);
    }
}
