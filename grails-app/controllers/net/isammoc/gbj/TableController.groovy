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
		[table:table]
	}

	def card = {
		def table = Table.get(params.id)
		table.addToPlayer(cardService.random())
		table.save(flush:true)
		redirect(action:"show",params:[id:table.id])
	}
}
