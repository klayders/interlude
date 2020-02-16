//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package l2.gameserver.skills.effects;

import l2.gameserver.model.Effect;
import l2.gameserver.stats.Env;

public final class EffectSleep extends Effect {
  public EffectSleep(Env env, EffectTemplate template) {
    super(env, template);
  }

  public void onStart() {
    super.onStart();
    this._effected.startSleeping();
    this._effected.abortAttack(true, true);
    this._effected.abortCast(true, true);
    this._effected.stopMove();
  }

  public void onExit() {
    super.onExit();
    this._effected.stopSleeping();
  }

  public boolean onActionTime() {
    return false;
  }
}
