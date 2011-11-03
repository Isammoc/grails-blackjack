package net.isammoc.gbj.auth

import net.isammoc.gbj.util.SaltGenerator

class User {

	transient springSecurityService

	String username
	String password
	String salt
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		this.salt = SaltGenerator.generateSalt()
		password = springSecurityService.encodePassword(password, salt)
	}
}
