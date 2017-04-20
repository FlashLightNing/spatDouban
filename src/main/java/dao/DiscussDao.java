package com.zufan.dao;

import com.zufan.entity.Discuss;

public interface DiscussDao {
	void addNewDiscuss(Discuss discuss);
	Discuss getDiscussById(Long id);
	
}
