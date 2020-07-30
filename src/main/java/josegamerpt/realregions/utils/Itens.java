package josegamerpt.realregions.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Itens {

	public static void shrink(ArrayList<ItemStack> list, int newSize) {
		int size = list.size();
		if (newSize >= size)
			return;
		for (int i = newSize; i < size; i++) {
			list.remove(list.size() - 1);
		}
	}

	public static ItemStack getHead(Player player, int quantidade, String name) {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, quantidade);
		SkullMeta skull = (SkullMeta) item.getItemMeta();
		skull.setDisplayName(Text.color(name));
		ArrayList<String> lore = new ArrayList<String>();
		skull.setLore(lore);
		skull.setOwningPlayer(Bukkit.getServer().getPlayer(player.getName()));
		item.setItemMeta(skull);
		return item;
	}

	public static ItemStack getHead(Player player) {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta skull = (SkullMeta) item.getItemMeta();
		skull.setDisplayName(player.getName());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("&fClick to Teleport");
		skull.setLore(Text.color(lore));
		skull.setOwningPlayer(Bukkit.getServer().getPlayer(player.getName()));
		item.setItemMeta(skull);
		return item;
	}

	public static ItemStack addLore(ItemStack i, List<String> lor) {
		if (i != null) {
			ItemStack is = i.clone();
			ItemMeta meta;
			if (is.hasItemMeta() == false) {
				meta = Bukkit.getItemFactory().getItemMeta(is.getType());
			} else {
				meta = is.getItemMeta();
			}

			List<String> lore;
			if (meta.hasLore() == false) {
				lore = new ArrayList<String>();
			} else {
				lore = meta.getLore();
			}
			lore.add(Text.color("&9"));
			lore.addAll(Text.color(lor));
			meta.setLore(lore);
			is.setItemMeta(meta);
			return is;
		} else {
			return null;
		}
	}

	public static ItemStack setLore(ItemStack i, List<String> lor) {
		if (i != null) {
			ItemStack is = i.clone();
			ItemMeta meta;
			if (is.hasItemMeta() == false) {
				meta = Bukkit.getItemFactory().getItemMeta(is.getType());
			} else {
				meta = is.getItemMeta();
			}

			List<String> lore;
			lore = new ArrayList<String>();

			lore.add(Text.color("&9"));
			lore.addAll(Text.color(lor));
			meta.setLore(lore);
			is.setItemMeta(meta);
			return is;
		} else {
			return null;
		}
	}

	public static ItemStack createItem(Material material, int quantidade, String nome) {
		ItemStack item = new ItemStack(material, quantidade);
		ItemMeta meta = item.getItemMeta();
		if (nome == null) {
		} else {
			meta.setDisplayName(Text.color(nome));
		}
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, int quantidade, String nome, List<String> desc) {
		ItemStack item = new ItemStack(material, quantidade);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nome));
		meta.setLore(Text.color(desc));
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItemLoreEnchanted(Material m, int i, String name, List<String> desc) {
		ItemStack item = new ItemStack(m, i);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		meta.setLore(Text.color(desc));
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
}