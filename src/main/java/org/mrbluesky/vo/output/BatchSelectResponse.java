package org.mrbluesky.vo.output;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mrbluesky.vo.entity.BatchProgram;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchSelectTestResponse {

  private List<BatchProgram> batchProgram;

}
