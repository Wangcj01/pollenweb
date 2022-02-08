package com.pollen.pollenweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2022-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("Files")
public class Files implements Serializable {

    private static final long serialVersionUID=1L;

      private String fileId;

    private String fileName;

    private String fileAddress;

    private String fileSize;

    private LocalDateTime uploadTime;

    private LocalDateTime makeTime;

    private String area;

    private String userName;

    private Integer userId;

    private String state;


}
