//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package l2.gameserver.network.l2.s2c;

public class ExSetMpccRouting extends L2GameServerPacket {
  public ExSetMpccRouting() {
  }

  protected void writeImpl() {
    this.writeEx(55);
  }
}