package jp.co.systena.tigerscave.ShoppingApp.BlackJack;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BlackJackSession implements Serializable {
  private static final long serialVersionUID = 6334063099671792256L;

  private BlackJack blackJack;

}
