/**
 *    ||          ____  _ __                           
 * +------+      / __ )(_) /_______________ _____  ___ 
 * | 0xBC |     / __  / / __/ ___/ ___/ __ `/_  / / _ \
 * +------+    / /_/ / / /_/ /__/ /  / /_/ / / /_/  __/
 *  ||  ||    /_____/_/\__/\___/_/   \__,_/ /___/\___/
 *
 * Copyright (C) 2013 Bitcraze AB
 *
 * Crazyflie Nano Quadcopter Client
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package se.bitcraze.crazyflielib.crtp;

import java.nio.ByteBuffer;

public class LogPacket extends CrtpPacket {

   /**
    * Create a new Logger packet.
    * 
    */
   public static final byte CMD_GET_ITEM = 0x00;
   byte item_id;

   public LogPacket(byte item_id){
      super((byte) 0x50);
      this.item_id = item_id;
   }

   @Override
      protected void serializeData(ByteBuffer buffer) {
         buffer.put(CMD_GET_ITEM);
         buffer.put(item_id);
      }

   @Override
      protected int getDataByteCount() {
         return 1 * 2; // 2 bytes
      }

}
