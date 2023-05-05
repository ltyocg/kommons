package com.github.ltyocg.kommons.lang

import org.apache.commons.lang3.builder.ToStringStyle
import kotlin.test.AfterTest
import kotlin.test.assertNull

abstract class AbstractLangTest {
    @AfterTest
    fun validateNullToStringStyleRegistry() {
        val registry = ToStringStyle::class.java.getDeclaredMethod("getRegistry")
            .apply { isAccessible = true }
            .invoke(ToStringStyle::class.java)
        assertNull(registry, "Expected null, actual: $registry")
    }
}