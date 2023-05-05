package com.github.ltyocg.kommons.lang

import org.apache.commons.lang3.StringUtils

object StringUtils {
    const val LF = "\n"
    const val CR = "\r"
    fun String.abbreviate(maxWidth: Int, abbrevMarker: String = "...", offset: Int = 0): String =
        StringUtils.abbreviate(this, abbrevMarker, offset, maxWidth)

    fun String.abbreviateMiddle(middle: String, length: Int): String =
        StringUtils.abbreviateMiddle(this, middle, length)

    fun String.appendIfMissing(
        suffix: CharSequence,
        ignoreCase: Boolean = false,
        vararg suffixes: CharSequence
    ): String =
        if (ignoreCase) StringUtils.appendIfMissingIgnoreCase(this, suffix, *suffixes)
        else StringUtils.appendIfMissing(this, suffix, *suffixes)

    fun String.capitalize(): String = StringUtils.capitalize(this)
    fun String.center(size: Int, padChar: Char = ' '): String = StringUtils.center(this, size, padChar)
    fun String.center(size: Int, padStr: String): String = StringUtils.center(this, size, padStr)
    fun String.chomp(): String = StringUtils.chomp(this)
    fun String.chop(): String = StringUtils.chop(this)
    fun CharSequence.containsAny(vararg searchChars: Char): Boolean = StringUtils.containsAny(this, *searchChars)
    fun CharSequence.containsAny(searchChars: CharSequence): Boolean = StringUtils.containsAny(this, searchChars)
    fun CharSequence.containsAny(ignoreCase: Boolean = false, vararg searchCharSequences: CharSequence): Boolean =
        if (ignoreCase) StringUtils.containsAnyIgnoreCase(this, *searchCharSequences)
        else StringUtils.containsAny(this, *searchCharSequences)

    @Deprecated("", replaceWith = ReplaceWith("this.contains(searchStr, true)"))
    fun CharSequence.containsIgnoreCase(searchStr: CharSequence): Boolean =
        StringUtils.containsIgnoreCase(this, searchStr)

    fun CharSequence.containsNone(vararg searchChars: Char): Boolean = StringUtils.containsAny(this, *searchChars)
    fun CharSequence.containsNone(invalidChars: String): Boolean = StringUtils.containsAny(this, invalidChars)
    fun CharSequence.containsOnly(vararg valid: Char): Boolean = StringUtils.containsOnly(this, *valid)
    fun CharSequence.containsOnly(validChars: String): Boolean = StringUtils.containsOnly(this, validChars)
    fun CharSequence.containsWhitespace(): Boolean = StringUtils.containsWhitespace(this)
}