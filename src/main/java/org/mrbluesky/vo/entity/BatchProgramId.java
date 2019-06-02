package org.mrbluesky.vo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchProgramId implements Serializable {

  @Column(name = "sys_id")
  private String systemId;

  @Column(name = "bat_seq")
  private int batchSeq;

  @Column(name = "bat_proc_id")
  private String batchProcId;

}
