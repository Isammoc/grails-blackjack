package net.isammoc.gbj

import java.util.Random

class CardController {

	def index = {
		redirect (action:'random')
	}
	
	def random = {
		[cards:[
				Card.findAll()[new Random().nextInt(Card.count())]
			]]
	}

	def list = {
		[cards:Card.findAll()]
	}
}
