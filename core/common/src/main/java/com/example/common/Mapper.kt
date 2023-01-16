package com.example.common

interface Mapper<INPUT, OUTPUT> {

    fun from(input: INPUT?): OUTPUT

    fun to(output: OUTPUT?): INPUT

    fun fromList(list : List<INPUT>?) : List<OUTPUT> {
        return list?.mapNotNull { from(it) } ?: listOf()
    }

    fun toList(list : List<OUTPUT>?) : List<INPUT> {
        return list?.mapNotNull { to(it) } ?: listOf()
    }

}