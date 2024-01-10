package com.example.shivam_agarwal.util

import java.util.HashMap
import java.util.regex.Pattern

fun String.findCharsAtEveryIndex(atIndex :Int) :String {
    val every15thCharacter = StringBuilder()
    var i = atIndex - 1
    while (i < this.length) {
        every15thCharacter.append(this[i])
        i += atIndex
    }
    return every15thCharacter.toString()

}

fun String.getWordFrequency() : String {
    val list =  this.split(Pattern.compile("\\s+"))
    val freq: MutableMap<String, Int> = HashMap()
    for (word in list)
    {
        if(freq.containsKey(word))
            freq[word] = freq[word]!! + 1
        else
            freq[word] = 1
    }
    val sb = StringBuilder()
    freq.forEach {
        sb.append(it.key + " = " + it.value + "\n")
    }
    return sb.toString()
}

