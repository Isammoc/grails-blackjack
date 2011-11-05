package net.isammoc.gbj

class TableController {

	def cardService

	def index = { redirect(action:"create") }

	def create = {
		def table = new Table()
		table.addToBank(cardService.random())
		table.addToPlayer(cardService.random())
		table.addToPlayer(cardService.random())
		table.save(flush:true)
		redirect(action:"show",params:[id:table.id])
	}

	def show = {
		def table = Table.get(params.id)
		[
			table:table,
			score:cardService.scoreToDisplay(table.player),
			canCard:cardService.canCard(table.player)
		]
	}

	def card = {
		def table = Table.get(params.id)
		if(cardService.canCard(table.player)){
			table.addToPlayer(cardService.random())
			table.save(flush:true)
		} else {
			flash.message = "Mais puisque je vous dis que vous ne pouvez pas tirer de carte !!!"
		}
		redirect(action:"show",params:[id:table.id])
	}
}
