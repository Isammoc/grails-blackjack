package net.isammoc.gbj

import net.isammoc.gbj.auth.User

class Table {

	List bank
	List player
	User user
	int bet = 0
	boolean abandon = false
	
	static hasMany = [bank:Card, player:Card]
	
    static constraints = {
    }
}
