package com.test.mybatisplusdemo.controller;

import com.test.mybatisplusdemo.entity.WeCreater;
import com.test.mybatisplusdemo.po.CreaterPo;
import com.test.mybatisplusdemo.po.DataSourcePo;
import com.test.mybatisplusdemo.po.ResultPoJo;
import com.test.mybatisplusdemo.po.ReturnCode;
import com.test.mybatisplusdemo.service.CreaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @Description: 创建者控制器
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/9 9:59 上午
 */
@RestController
@Api(tags = "创建者对外接口")
@AllArgsConstructor
@RequestMapping(value = "/grant/creater")
public class CreaterController {

    private final CreaterService createrService;

    @PostMapping(value = "/build")
    @ApiModelProperty(value = "通过配置的数据库参数生成代码")
    public String buildCode(@RequestBody DataSourcePo po) {
        return createrService.buildCode(po);
    }

    @PostMapping(value = "/downLoad")
    @ApiModelProperty(value = "下载生成的源码")
    public void buildCode(HttpServletRequest request, HttpServletRequest response) {
        createrService.downLoad(request, response);
    }

    @ApiOperation(value = "获取全部的库列表", notes = "获取全部的库列表")
    @GetMapping(value = "getRepoList")
    public ResultPoJo<List<WeCreater>> allList(@RequestBody CreaterPo po) {
        return createrService.allList(po);
    }

    @ApiOperation(value = "删除构建者库数据", notes = "删除库对象")
    @RequestMapping(value = "delete", method = POST)
    public ResultPoJo<ReturnCode> delete(@RequestBody CreaterPo po) {
        return createrService.delete(po);
    }

}
