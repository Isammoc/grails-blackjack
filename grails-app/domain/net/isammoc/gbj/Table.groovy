package net.isammoc.gbj

class Table {

	List bank
	List player
	
	static hasMany = [bank:Card, player:Card]
	
    static constraints = {
    }
}
