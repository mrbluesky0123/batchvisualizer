package org.mrbluesky.vo.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchSelectPostInput {

  private String systemId;
  private Integer batchSeqeunce;
  private String batName;


}
