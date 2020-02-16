//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package l2.commons.threading;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public abstract class RunnableImpl implements Runnable {

  // классы из jar используют логгер
  public static final Logger _log = LoggerFactory.getLogger(RunnableImpl.class);


  public RunnableImpl() {
  }

  public abstract void runImpl() throws Exception;

  public final void run() {
    try {
      this.runImpl();
    } catch (Throwable var2) {
      log.error("Exception: RunnableImpl.run(): " + var2, var2);
    }

  }
}
