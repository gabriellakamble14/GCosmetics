package com.GCosmetics.Dao;

import java.util.List;
import com.GCosmetics.pojo.cosmetics;

public interface CosmeticsDao 
{
	boolean addcosmetics(cosmetics cosmetics);
	boolean updatecosmetics(cosmetics cosmetics);
	boolean deletecosmetics(int id);
	cosmetics getcosmeticsById(int cosmeticsId);
	List<cosmetics> getAllcosmetics();
	List<cosmetics> getcosmeticsBycategory(String cosmeticsCategory);


}
