package org.mrbluesky.vo.output;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mrbluesky.vo.entity.Error;
import org.mrbluesky.vo.entity.BatchProgram;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchSelectResponse implements IResponse {

  private Error error;
  private List<BatchProgram> batchProgram;

}
