package org.mrbluesky.vo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="BAT_VISUAL_MST")
public class BatchProgram {

  @EmbeddedId
  private BatchProgramId batchProgramId;

  @Column(name = "bat_proc_hnm")
  private String batchKoreanName;

  @Column(name = "file_yn")
  private String hasInputFile;

  @Column(name = "file_id")
  private String fileId;

  @Column(name = "res_file_send_yn")
  private String sendResultFile;

}
