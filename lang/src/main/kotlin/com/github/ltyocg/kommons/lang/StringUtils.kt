package com.github.ltyocg.kommons.lang

import org.apache.commons.lang3.StringUtils
import java.nio.charset.Charset

object StringUtils {
    const val SPACE = StringUtils.SPACE
    const val LF = StringUtils.LF
    const val CR = StringUtils.CR
    const val INDEX_NOT_FOUND = StringUtils.INDEX_NOT_FOUND
    fun String.abbreviate(maxWidth: Int, abbrevMarker: String = "...", offset: Int = 0): String = StringUtils.abbreviate(this, abbrevMarker, offset, maxWidth)
    fun String.abbreviateMiddle(middle: String, length: Int): String = StringUtils.abbreviateMiddle(this, middle, length)
    fun String.appendIfMissing(suffix: CharSequence, ignoreCase: Boolean = false, vararg suffixes: CharSequence?): String =
        if (ignoreCase) StringUtils.appendIfMissing(this, suffix, *suffixes)
        else StringUtils.appendIfMissingIgnoreCase(this, suffix, *suffixes)

    @Deprecated("Use replaceFirstChar instead.", ReplaceWith("replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", "java.util.Locale"))
    fun String.capitalize(): String = StringUtils.capitalize(this)
    fun String.center(size: Int, padChar: Char = ' '): String = StringUtils.center(this, size, padChar)
    fun String.center(size: Int, padStr: String): String = StringUtils.center(this, size, padStr)
    fun String.chomp(): String = StringUtils.chomp(this)
    fun String.chop(): String = StringUtils.chop(this)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("searchChars.any { it in this }"))
    fun CharSequence.containsAny(vararg searchChars: Char): Boolean = StringUtils.containsAny(this, *searchChars)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("searchChars.any { it in this }"))
    fun CharSequence.containsAny(searchChars: CharSequence): Boolean = StringUtils.containsAny(this, searchChars)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("searchCharSequences.any { this.contains(it, ignoreCase) }"))
    fun <T : CharSequence?> CharSequence.containsAny(ignoreCase: Boolean = false, vararg searchCharSequences: T): Boolean =
        if (ignoreCase) StringUtils.containsAnyIgnoreCase(this, *searchCharSequences)
        else StringUtils.containsAny(this, *searchCharSequences)

    @Deprecated("Use none instead.", replaceWith = ReplaceWith("searchChars.none { it in this }"))
    fun CharSequence.containsNone(vararg searchChars: Char): Boolean = StringUtils.containsNone(this, *searchChars)

    @Deprecated("Use none instead.", replaceWith = ReplaceWith("invalidChars.none { it in this }"))
    fun CharSequence.containsNone(invalidChars: String): Boolean = StringUtils.containsNone(this, invalidChars)

    @Deprecated("Use all instead.", replaceWith = ReplaceWith("valid.all { it in this }"))
    fun CharSequence.containsOnly(vararg valid: Char): Boolean = StringUtils.containsOnly(this, *valid)

    @Deprecated("Use all instead.", replaceWith = ReplaceWith("validChars.all { it in this }"))
    fun CharSequence.containsOnly(validChars: String): Boolean = StringUtils.containsOnly(this, validChars)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("this.any(Char::isWhitespace)"))
    fun CharSequence.containsWhitespace(): Boolean = StringUtils.containsWhitespace(this)

    @Deprecated("Use count instead.", replaceWith = ReplaceWith("this.count { it == ch }"))
    fun CharSequence.countMatches(ch: Char): Int = StringUtils.countMatches(this, ch)
    fun CharSequence.countMatches(sub: CharSequence): Int = StringUtils.countMatches(this, sub)

    @Deprecated("Use ifBlank instead.", replaceWith = ReplaceWith("this.ifBlank { defaultStr }"))
    fun <T : CharSequence> T.defaultIfBlank(defaultStr: T?): T? = StringUtils.defaultIfBlank(this, defaultStr)

    @Deprecated("Use ifEmpty instead.", replaceWith = ReplaceWith("this.ifEmpty { defaultStr }"))
    fun <T : CharSequence> T.defaultIfEmpty(defaultStr: T?): T? = StringUtils.defaultIfEmpty(this, defaultStr)

    @Deprecated("", replaceWith = ReplaceWith("this ?: \"\""))
    fun String?.defaultString(): String? = StringUtils.defaultString(this)

    @Deprecated("Use filterNot instead.", replaceWith = ReplaceWith("this.filterNot(Char::isWhitespace)"))
    fun String.deleteWhitespace(): String = StringUtils.deleteWhitespace(this)
    infix fun String?.difference(str2: String?): String? = StringUtils.difference(this, str2)

    @Deprecated("Use kotlin.text.endsWith instead.", replaceWith = ReplaceWith("this.endsWith(suffix, ignoreCase)"))
    fun CharSequence.endsWith(suffix: CharSequence, ignoreCase: Boolean = false): Boolean = StringUtils.endsWith(this, suffix)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("searchStrings.any(this::endsWith)"))
    fun <T : CharSequence?> CharSequence.endsWithAny(vararg searchStrings: T): Boolean = StringUtils.endsWithAny(this, *searchStrings)

    @Deprecated("Use in instead.", replaceWith = ReplaceWith("this in searchStrings"))
    fun <T : CharSequence?> CharSequence.equalsAny(vararg searchStrings: T): Boolean = StringUtils.equalsAny(this, *searchStrings)

    @Deprecated("Use any instead.", replaceWith = ReplaceWith("searchStrings.any { this.equals(it, true) }"))
    fun <T : CharSequence?> CharSequence.equalsAnyIgnoreCase(vararg searchStrings: T): Boolean = StringUtils.equalsAnyIgnoreCase(this, *searchStrings)
    infix fun CharSequence?.equalsIgnoreCase(cs2: CharSequence?): Boolean = StringUtils.equalsIgnoreCase(this, cs2)

    @Deprecated("Use firstOrNull instead", replaceWith = ReplaceWith("values.firstOrNull { !it.isNullOrBlank() }"))
    fun <T : CharSequence?> firstNonBlank(vararg values: T): T = StringUtils.firstNonBlank(*values)

    @Deprecated("Use firstOrNull instead", replaceWith = ReplaceWith("values.firstOrNull { !it.isNullOrEmpty() }"))
    fun <T : CharSequence?> firstNonEmpty(vararg values: T): T = StringUtils.firstNonEmpty(*values)

    @Deprecated("Use toByteArray instead.", replaceWith = ReplaceWith("this.toByteArray(charset)"))
    fun String.getBytes(charset: Charset): ByteArray = StringUtils.getBytes(this, charset)

    @Deprecated("Use toByteArray instead.", replaceWith = ReplaceWith("this.toByteArray(Charset.forName(charset))", "java.nio.charset.Charset"))
    fun String.getBytes(charset: String): ByteArray = StringUtils.getBytes(this, charset)
    fun getCommonPrefix(vararg strs: String?): String = StringUtils.getCommonPrefix(*strs)

    @Deprecated("Use filter instead.", replaceWith = ReplaceWith("this.filter(Char::isDigit)"))
    fun String.getDigits(): String = StringUtils.getDigits(this)

    @Deprecated("Use ifBlank instead.", replaceWith = ReplaceWith("this.ifBlank(defaultSupplier)"))
    fun <T : CharSequence?> T.getIfBlank(defaultSupplier: () -> T): T = StringUtils.getIfBlank(this, defaultSupplier)

    @Deprecated("Use ifEmpty instead.", replaceWith = ReplaceWith("this.ifEmpty(defaultSupplier)"))
    fun <T : CharSequence?> T.getIfEmpty(defaultSupplier: () -> T): T = StringUtils.getIfEmpty(this, defaultSupplier)

    @Deprecated("Use kotlin.text.indexOf instead.", replaceWith = ReplaceWith("this.indexOf(searchSeq, startPos)"))
    fun CharSequence.indexOf(searchSeq: CharSequence, startPos: Int = 0): Int = StringUtils.indexOf(this, searchSeq, startPos)

    @Deprecated("Use kotlin.text.indexOf instead.", replaceWith = ReplaceWith("this.indexOf(searchChar, startPos)"))
    fun CharSequence.indexOf(searchChar: Char, startPos: Int = 0): Int = StringUtils.indexOf(this, searchChar.code)
    fun CharSequence.indexOfAny(vararg searchChars: Char): Int = StringUtils.indexOfAny(this, *searchChars)
    fun CharSequence.indexOfAny(vararg searchStrs: CharSequence): Int = StringUtils.indexOfAny(this, *searchStrs)
}
