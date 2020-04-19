package com.example.springbootvhr.controller.system.basic;

import com.example.springbootvhr.entity.Position;
import com.example.springbootvhr.entity.ResponseBean;
import com.example.springbootvhr.service.system.basic.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public ResponseBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return ResponseBean.ok("添加成功！");
        } else
            return ResponseBean.error("添加失败！");
    }

    @PutMapping("/")
    public ResponseBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return ResponseBean.ok("修改成功！");
        } else
            return ResponseBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return ResponseBean.ok("删除成功！");
        } else
            return ResponseBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public ResponseBean deletePositionsByIds(Integer[] ids) {
        if (positionService.deletePositionsByIds(ids) == ids.length) {
            return ResponseBean.ok("删除成功！");
        }
        return ResponseBean.error("删除失败!");
    }
}
