package com.we.journey.security.repository;

import com.we.journey.security.entity.We_creater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 构建者数据库记录表 Repository 接口
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
public interface We_createrRepo extends JpaRepository<We_creater,String> {

}
