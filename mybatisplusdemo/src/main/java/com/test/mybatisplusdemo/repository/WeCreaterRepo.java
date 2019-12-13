package com.test.mybatisplusdemo.repository;

import com.test.mybatisplusdemo.entity.WeCreater;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 构建者数据库记录表 Repository 接口
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
public interface WeCreaterRepo extends JpaRepository<WeCreater,String> {

}
