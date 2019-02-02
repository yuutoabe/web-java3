package jp.co.systena.tigerscave.ShoppingApp.HighAndLow;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HighAndLowSession implements Serializable {
  private static final long serialVersionUID = 4562563099681792276L;

  private HighAndLow highAndLow;
}
