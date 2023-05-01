package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Tourist;
import com.nit.exception.TouristNotFound;
import com.nit.repository.ITouristRepository;
@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepository touristRepo;
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal=touristRepo.save(tourist).getTid();
		return " Tourist is registered having the id value "+idVal;
	}
	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list=touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	@Override
	public Tourist fechTouristById(Integer tid) throws TouristNotFound {
		return touristRepo.findById(tid)
						.orElseThrow(()->new TouristNotFound(tid+"Tourist Not Found"));
	}
	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFound {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if(optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+" Tourist is updated";
		}
		else {
			throw new TouristNotFound(tourist.getTid()+"Tourist Not Found");
		}
	}

}
