package net.isammoc.gbj

class CardService {

    static transactional = true

    Card random() {
		Card.findAll()[new Random().nextInt(Card.count())]
    }
}
