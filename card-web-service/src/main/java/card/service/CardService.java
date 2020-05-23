package card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import card.model.CardEntity;
import card.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public CardEntity getCardByName(String Name) {
		return cardRepository.findByName(Name);
	}
	
	public long getNumber() {
		return cardRepository.count();
	}
	
	public List<CardEntity> getAll(){
		return cardRepository.findAll();
	}
	
	
	
	public void addCard(CardEntity card) {
		cardRepository.save(card);
	}
	
	public void updateCard(CardEntity card) {
		cardRepository.save(card);
	}
	
	public void deleteCard(String id) {
		cardRepository.delete(cardRepository.findById(Integer.parseInt(id)));
	}

	public CardEntity getCardById(String id) {
		return cardRepository.findById(Integer.parseInt(id));
	}

	public String getUserCards(String userid) {
		List<CardEntity> cardList =  cardRepository.findByUserId(userid);
		String idList = "";
		for (CardEntity card: cardList) {
			idList += card.getId() + "/";
		}
		
		return idList.substring(0, idList.length() - 1 );
	}

	public String getBuyableCards() {
		List<CardEntity> cardList =  cardRepository.findByUserIdNull();
		String idList = "";
		for (CardEntity card: cardList) {
			idList += card.getId() + "/";
		}
		
		return idList.substring(0, idList.length() - 1 );
	}
}
	
