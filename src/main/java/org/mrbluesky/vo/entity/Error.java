package org.mrbluesky.vo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="COM_ANS_MSG")
public class Error {

  @Id
  @Column(name="ans_cd")
  private String errorCode;
  @Column(name="ans_msg")
  private String errorMessage;

}
