package com.we.journey.security.repository;

import com.we.journey.security.entity.We_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统角色表 Repository 接口
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
public interface We_roleRepo extends JpaRepository<We_role,String> {

}
