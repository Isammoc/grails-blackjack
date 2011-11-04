package net.isammoc.gbj

import java.util.Random

class CardController {

	def cardService
	
	def index = {
		redirect (action:'random')
	}
	
	def random = {
		[cards:[cardService.random]]
	}

	def list = {
		[cards:Card.findAll()]
	}
}
