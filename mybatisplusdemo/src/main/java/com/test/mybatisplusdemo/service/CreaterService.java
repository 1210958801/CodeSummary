package com.test.mybatisplusdemo.service;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.test.mybatisplusdemo.base.BaseEntity;
import com.test.mybatisplusdemo.constants.CreaterConstants;
import com.test.mybatisplusdemo.entity.WeCreater;
import com.test.mybatisplusdemo.po.CreaterPo;
import com.test.mybatisplusdemo.po.DataSourcePo;
import com.test.mybatisplusdemo.po.ResultPoJo;
import com.test.mybatisplusdemo.po.ReturnCode;
import com.test.mybatisplusdemo.repository.WeCreaterRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @Description: 创建者业务层
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/9 9:59 上午
 */
@Slf4j
@Service
@AllArgsConstructor
public class CreaterService {

    private final WeCreaterRepo weCreaterRepo;

    /**
     * 通过参数构建代码
     */
    public String buildCode(DataSourcePo po) {
        //启动构建者
        builder(po);

        //询问是否已经生成成功
        String projectPath = System.getProperty("user.dir") + "/buildeCode/com";
        File file = new File(projectPath);
        if (file.exists()) {
            return "生成成功";
        }
        return "生成失败";
    }

    /**
     * 下载已经生成的代码,并且删除
     */
    public void downLoad(HttpServletRequest request, HttpServletRequest response) {
        String projectPath = System.getProperty("user.dir") + "/buildeCode/com";
        File file = new File(projectPath);
        if (file.exists()) {
            //打包

            //发送响应头

            //删除
        }
    }

    /**
     * 获取构建者库列表
     */
    public ResultPoJo<List<WeCreater>> allList(CreaterPo po) {
        ResultPoJo<List<WeCreater>> poJo = new ResultPoJo<>();

        Example<WeCreater> of = null;
        if (po.getHost() != null) {
            WeCreater weCreater = new WeCreater();
            weCreater.setHost(po.getHost());
            of = Example.of(weCreater);
        }

        List<WeCreater> all = weCreaterRepo.findAll(of);
        poJo.setResult(all);
        return poJo;
    }

    /**
     * 删除库列表
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo<ReturnCode> delete(CreaterPo po) {
        ResultPoJo<ReturnCode> poJo = new ResultPoJo<>();

        WeCreater weCreater = new WeCreater();
        weCreater.setHost(po.getHost());
        weCreaterRepo.delete(weCreater);

        poJo.setErrorStatus(ReturnCode.SUCCESS);
        return poJo;
    }

    /**
     * 构建者
     */
    public void builder(DataSourcePo po) {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/buildeCode");
        globalConfig.setAuthor("WeCreater");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setSwagger2(true);
        globalConfig.setMapperName("%sRepo");
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(po.getUrl());
        dataSourceConfig.setDriverName(po.getDriverName());
        dataSourceConfig.setUsername(po.getUsername());
        dataSourceConfig.setPassword(po.getPassword());
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(po.getParent());
        packageConfig.setMapper("repository");
        //模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/entity.java.vm");
        templateConfig.setMapper("/repo.java.vm");
        if (!po.isWheSerCon()) {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setController(null);
        }
        if (!po.isWheXml()) {
            templateConfig.setXml(null);
        }
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setEntityTableFieldAnnotationEnable(true);
        //判断是否生成所有的表
        if (po.isWheAll()) {
            strategy.setExclude(CreaterConstants.DONOT_CREATE_TABLES.split(","));
        } else {
            strategy.setInclude(po.getTables());
        }
        strategy.setEntitySerialVersionUID(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setPackageInfo(packageConfig);
        mpg.setStrategy(strategy);
        mpg.setTemplate(templateConfig);
        mpg.execute();
    }
}
