package net.isammoc.gbj.util

import org.hibernate.cfg.ImprovedNamingStrategy
import org.hibernate.util.StringHelper

class MyNamingStrategy extends ImprovedNamingStrategy {
	String classToTableName(String className)
	{
		"gbj_" + addUnderscores(StringHelper.unqualify(className));
	}
	
	String propertyToColumnName(String propertyName) {
		"col_" + addUnderscores(StringHelper.unqualify(propertyName));
	}
}
