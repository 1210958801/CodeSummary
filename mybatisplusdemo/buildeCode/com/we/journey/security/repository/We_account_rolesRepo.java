package com.we.journey.security.repository;

import com.we.journey.security.entity.We_account_roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户角色中间表 Repository 接口
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
public interface We_account_rolesRepo extends JpaRepository<We_account_roles,String> {

}
