package net.isammoc.gbj

class Card {

	String name
	String rank
	String suit

	static constraints = {
		rank(inlist:['A', 'K', 'Q', 'J', '9', '8', '7', '6', '5', '4', '3', '2'])
		suit(inlist:['s', 'h', 'd', 'c'])
		name(validator: {name, card -> return name == "$card.rank$card.suit"})
	}
}
