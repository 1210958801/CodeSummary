package com.test.mybatisplusdemo.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/10/22 5:06 下午
 */
@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "weid")
    @GenericGenerator(name = "weid", strategy = "uuid")
    @Column(length = 100)
    private String id;

    private OffsetDateTime createDate;
    @Column(length = 100)
    private String createBy;

    @JsonDeserialize()
    private OffsetDateTime updateDate;
    @Column(length = 100)
    private String updateBy;

    @Column(nullable = false, length = 1)
    private Byte delFlag = 0;
}
