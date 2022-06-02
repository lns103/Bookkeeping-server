package xyz.lns103.mybatisplus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lns103
 * @since 2022-04-16
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
  @TableId(type = IdType.INPUT)
      private Long createDate;

    private Double charge;

    private Long date;

    private Long editDate;

    private String type;

    private String note;

  private String userId;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }



  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
