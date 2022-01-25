package com.pjf.server.controller;


import com.pjf.server.entity.Position;
import com.pjf.server.service.IPositionService;
import com.pjf.server.util.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
@RestController
@Api(tags = "职位管理")
@RequestMapping("/system/config/pos")
public class PositionController {
    @Resource
    private IPositionService positionService;

    @ApiOperation("获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPosition() {
        return positionService.list();
    }

    @ApiOperation("添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        position.setCreateDate(LocalDateTime.now());
        if (positionService.save(position)) {
            return RespBean.success("职位添加成功");
        }
        return RespBean.error("职位添加失败");
    }

    @ApiOperation("更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updateById(position)) {
            return RespBean.success("职位更新成功");
        }
        return RespBean.error("职位更新失败");
    }

    @ApiOperation("删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.removeById(id)) {
            return RespBean.success("职位删除成功");
        }
        return RespBean.error("职位删除失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids) {
        if (positionService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("职位删除成功");
        }
        return RespBean.error("职位删除失败");
    }

}
