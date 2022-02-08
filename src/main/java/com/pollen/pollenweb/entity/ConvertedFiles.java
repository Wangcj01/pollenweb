package com.pollen.pollenweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableName("ConvertedFiles")
public class ConvertedFiles implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "file_id", type = IdType.AUTO)
      private Integer fileId;

    private String fileName;

    private String fileAddress;

    private Integer userId;

    private Double fileSize;

    private LocalDateTime makeTime;

    private LocalDateTime convertTime;

    private String area;

    private String userName;

    private Integer state;


}
