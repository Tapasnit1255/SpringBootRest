package com.nit.service;

import java.util.List;

import com.nit.entity.Tourist;
import com.nit.exception.TouristNotFound;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public Tourist fechTouristById(Integer tid)throws TouristNotFound;
	public String updateTouristDetails(Tourist tourist)throws TouristNotFound;
}
