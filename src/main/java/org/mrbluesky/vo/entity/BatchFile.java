package org.mrbluesky.vo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="BAT_BTFILE_MST")
public class BatchFile {

  @Id
  @Column(name="file_id")
  private String fileId;

  @Column(name = "file_hnm")
  private String fileKoreanName;

  @Column(name = "file_proc_dir")
  private String fileProcDir;

  @Column(name = "file_res_dir")
  private String fileResultDir;

  @Column(name = "file_rcv_host")
  private String fileRcvHost;

  @Column(name = "file_rcv_dir")
  private String fileRcvDir;

  @Column(name = "file_snd_host")
  private String fileSndHost;

  @Column(name = "file_snd_dir")
  private String fileSndDir;

}
