package com.mytiki.tiki_sdk_android.util

import com.squareup.moshi.*

import java.util.*

/**
 * Time stamp to date JSON adapter for Moshi.
 *
 * @constructor Create empty Time stamp to date adapter
 */
class TimeStampToDateAdapter : JsonAdapter<Date>() {

    @FromJson
    override fun fromJson(reader: JsonReader): Date? {
        if (reader.peek() == JsonReader.Token.NULL) return reader.nextNull()
        return try {
            val dateAsString = reader.nextString()
            Date(dateAsString.toLong())
        } catch (e: Exception) {
            null
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Date?) {
        writer.value(value?.time)
    }
}