package org.mrbluesky.vo.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponse {

  private String status;
  private String statusMessage;
  private IResponse businessResponse;

}
