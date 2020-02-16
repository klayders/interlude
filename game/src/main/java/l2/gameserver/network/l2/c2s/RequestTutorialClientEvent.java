//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package l2.gameserver.network.l2.c2s;

import l2.gameserver.instancemanager.QuestManager;
import l2.gameserver.model.Player;
import l2.gameserver.model.instances.NpcInstance;
import l2.gameserver.model.quest.Quest;
import l2.gameserver.network.l2.GameClient;

public class RequestTutorialClientEvent extends L2GameClientPacket {
  int event = 0;

  public RequestTutorialClientEvent() {
  }

  protected void readImpl() {
    this.event = this.readD();
  }

  protected void runImpl() {
    Player player = ((GameClient)this.getClient()).getActiveChar();
    if (player != null) {
      Quest tutorial = QuestManager.getQuest(255);
      if (tutorial != null) {
        player.processQuestEvent(tutorial.getName(), "CE" + this.event, (NpcInstance)null);
      }

    }
  }
}