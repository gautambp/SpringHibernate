package self.learning.spring_web.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.learning.spring_web.daos.OfferDAO;
import self.learning.spring_web.daos.OfferVO;

@Service
@Transactional
public class OfferService {
	private OfferDAO offerDAO;
	
	@Autowired
	public void setOfferDAO(OfferDAO dao) {
		this.offerDAO = dao;
	}
	
	public List<OfferVO> getOffers() {
		return offerDAO.find();
	}
	
	public boolean createOffer(OfferVO offer) {
		return offerDAO.create(offer);
	}
}
