package nz.pactifylauncher.packet.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import fr.speccy.azclientapi.bukkit.packets.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import pactify.client.api.plprotocol.metadata.PactifyModelMetadata;
import pactify.client.api.plprotocol.metadata.PactifyScaleMetadata;
import pactify.client.api.plprotocol.metadata.PactifyTagMetadata;
import pactify.client.api.plsp.packet.client.*;

import java.util.Iterator;

public class PacketAZModifier {
    public static void setSubTag(Player player, String subtag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entitySubTagPacket = new PactifyTagMetadata();
        entitySubTagPacket.setText(ChatColor.translateAlternateColorCodes('&', subtag));
        entityMetaPacket.setSubTag(entitySubTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setSupTag(Player player, String suptag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entitySupTagPacket = new PactifyTagMetadata();
        entitySupTagPacket.setText(ChatColor.translateAlternateColorCodes('&', suptag));
        entityMetaPacket.setSupTag(entitySupTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setTag(Player player, String tag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setText(ChatColor.translateAlternateColorCodes('&', tag));
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }
    public static void setPlayerModel(Player player, Integer entityID) {
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player players = (Player)var2.next();
            AZClientPlugin.main.getAZManager().sendPLSPMessage(players, new PLSPPacketPlayerModel(player.getUniqueId(), new PactifyModelMetadata(entityID)));
        }

    }
    public static void resetPlayerModel(Player player) {
        Iterator var1 = Bukkit.getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player players = (Player)var1.next();
            AZClientPlugin.main.getAZManager().sendPLSPMessage(players, new PLSPPacketPlayerModel(player.getUniqueId(), new PactifyModelMetadata(-1)));
        }
    }
    public static void setPlayerScale(Player player, Float BboxH, Float BboxW, Float RenderD, Float RenderH, Float RenderW, Boolean ScaleItems) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setBboxH(BboxH);
        scaleMetadata.setBboxW(BboxW);
        scaleMetadata.setRenderD(RenderD);
        scaleMetadata.setRenderH(RenderH);
        scaleMetadata.setRenderW(RenderW);
        scaleMetadata.setScaleItems(ScaleItems);
        scaleMetadata.setDefined(true);
        entityMetaPacket.setScale(scaleMetadata);
        Iterator var10 = Bukkit.getOnlinePlayers().iterator();

        while(var10.hasNext()) {
            Player players = (Player)var10.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void resetPlayerScale(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setDefined(false);
        entityMetaPacket.setScale(scaleMetadata);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {
            Player players = (Player)var4.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void setPlayerOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setOpacity(opacity);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {
            Player players = (Player)var4.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void resetPlayerOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setOpacity(-1.0F);
        Iterator var3 = Bukkit.getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player players = (Player)var3.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void setNameTagOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setOpacity(opacity);
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void resetNameTagOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setOpacity(-1.0F);
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {
            Player players = (Player)var4.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void setSneakNameTagOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setSneakOpacity(opacity);
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void resetSneakNameTagOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setSneakOpacity(-1.0F);
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {
            Player players = (Player)var4.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }

    public static void setNameTag(Player player, String tag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setText(ChatColor.translateAlternateColorCodes('&', tag));
        entityMetaPacket.setTag(entityTagPacket);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }

    }
    public static void setVignette(Player player, Float red, Float green, Float blue) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(true, red, green, blue));
    }

    public static void resetVignette(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(false, 0.0F, 0.0F, 0.0F));
    }

    public static void setWorldEnv(Player player, String env) {
        World world = player.getWorld();
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketWorldEnv(String.valueOf(world), env));
    }
    public static void reset(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketReset());
    }
}
