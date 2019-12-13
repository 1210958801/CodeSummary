package com.we.journey.security.repository;

import com.we.journey.security.entity.We_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户表 Repository 接口
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
public interface We_accountRepo extends JpaRepository<We_account,String> {

}
