package com.github.ltyocg.kommons.lang

import com.github.ltyocg.kommons.lang.Supplementary.CharU20001
import com.github.ltyocg.kommons.lang.Supplementary.CharUSuppCharHigh
import com.github.ltyocg.kommons.lang.Supplementary.CharUSuppCharLow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object StringUtilsContainsTest : AbstractLangTest() {
    @Test
    fun containsAny() {
        fun CharSequence.r(vararg searchChars: Char): Boolean = searchChars.toSet().any { it in this }
        assertFalse("".r())
        assertFalse("".r('a', 'b'))
        assertFalse("zzabyycdxx".r())
        assertTrue("zzabyycdxx".r('z', 'a'))
        assertTrue("zzabyycdxx".r('b', 'y'))
        assertTrue("zzabyycdxx".r('z', 'y'))
        assertFalse("ab".r('z'))
        assertFalse(CharUSuppCharHigh.r(*CharU20001.toCharArray()))
        assertFalse("abc${CharUSuppCharHigh}xyz".r(*CharU20001.toCharArray()))
        assertFalse(CharU20001 in CharUSuppCharLow)
        assertFalse(CharUSuppCharLow.r(*CharU20001.toCharArray()))
        assertFalse(CharU20001.r(*CharUSuppCharHigh.toCharArray()))
        assertEquals(0, CharU20001.indexOf(CharUSuppCharLow))
        assertTrue(CharU20001.r(*CharUSuppCharLow.toCharArray()))
    }

    @Test
    fun containsNone() {
        fun CharSequence.r(vararg searchChars: Char): Boolean = searchChars.toSet().none { it in this }
    }
}
